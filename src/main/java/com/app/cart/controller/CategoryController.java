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
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * Rest Controller for Category APIs
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

	private static final Logger logger=Logger.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService service;
	
	/**
	 * @param category - the entity Category
	 * @return id of the persisted Category entity
	 */
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		
		logger.info("Calling Category Service - Add : " + category);
		return service.addCategory(category);
	}
	
	/**
	 * @param id - id of the Category to be edited
	 * @param category - the entity Category
	 * @return the edited entity Category
	 */
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editCategory(@PathVariable Integer id, @RequestBody Category category) {
		
		logger.info("Calling Category Service - Edit, id : " + id + ", category :" + category);
		return service.editCategory(id, category);
	}
	
	/**
	 * @param id - id of the Category to be deleted
	 * @return the deleted entity Category
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		
		logger.info("Calling Category Service - Delete, id : " + id);
		return service.deleteCategory(id);
	}
	
	/**
	 * @param id - id of the Category to be retrieved
	 * @return the requested entity Category
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Integer id) {
		
		logger.info("Calling Category Service - Get, id : " + id);
		return service.getCategory(id);
	}

	/**
	 * @return list of Category Entities
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCategories() {
		
		logger.info("Calling Category Service - Get All");
		return service.getAllCategories();
	}
}
