package com.app.cart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.entity.Category;
import com.app.cart.service.CategoryService;

/**
 * 
 * @author omkar.nikam
 *
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

	private static final Logger logger=Logger.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		logger.info("Add Category : " + category);
		return service.addCategory(category);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editCategory(@PathVariable Integer id, Category category){
		logger.info("Edit Category, id : " + id + ", :" + category);
		return service.editCategory(id, category);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		logger.info("Delete Category, id : " + id);
		return service.deleteCategory(id);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Integer id){
		logger.info("Get Category, id : " + id);
		return service.getCategory(id);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCategories(){
		logger.info("Get All Categories");
		return service.getAllCategories();
	}
}
