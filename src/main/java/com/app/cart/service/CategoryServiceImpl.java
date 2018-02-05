package com.app.cart.service;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.app.cart.entity.Category;
import com.app.cart.repository.CategoryRepository;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * This class implements CategoryService Interface methods
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger logger=Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryRepository repository;

	@Override
	public ResponseEntity<?> addCategory(Category category) {
		
		try {
			logger.info("Saving a Category : " + category);
			return new ResponseEntity<Integer>(repository.save(category).getCategoryId(), new HttpHeaders(), HttpStatus.CREATED); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in saving a Category : " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> editCategory(Integer id, Category category) {
		
		Category dbObject = repository.findOne(id);
		if (null == dbObject)
			return ResponseEntity.notFound().build();
		
		category.setCategoryId(dbObject.getCategoryId());
		
		try {
			return new ResponseEntity<Category>(repository.save(category), new HttpHeaders(), HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> deleteCategory(Integer id) {
		
		Category dbObject = repository.findOne(id);
		if (null == dbObject)
			return ResponseEntity.notFound().build();
		
		try {
			repository.delete(id);
			return new ResponseEntity<Category>(dbObject, new HttpHeaders(), HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<?> getCategory(Integer id) {
		logger.info("Getting a Category, id : " + id);
		Category dbObject = repository.findOne(id);
		logger.info("Category : " + dbObject);
		if (null == dbObject)
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<Category>(dbObject, new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllCategories() {
		
		List<Category> list = repository.findAll();
		if(null == list)
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK);
	}

}
