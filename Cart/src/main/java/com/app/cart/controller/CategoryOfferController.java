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
import com.app.cart.entity.CategoryOffer;
import com.app.cart.service.CategoryOfferService;

/**
 * @author Omkar Nikam
 * @since 06-Feb-2018
 * Rest Controller for Category Offer APIs
 */

@RestController
@RequestMapping("/categoryoffer")
public class CategoryOfferController {

	private static final Logger logger=Logger.getLogger(CategoryOfferController.class);
	
	@Autowired
	CategoryOfferService service;
	
	/**
	 * @param categoryOffer - the entity CategoryOffer
	 * @return id of the persisted CategoryOffer entity
	 */
	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<?> addCategoryOffer(@RequestBody CategoryOffer categoryOffer) {
		
		logger.info("Calling CategoryOffer Service - Add : " + categoryOffer);
		return service.addCategoryOffer(categoryOffer);
	}
	
	/**
	 * @param id - id of the CategoryOffer to be edited
	 * @param categoryOffer - the entity CategoryOffer
	 * @return the edited entity CategoryOffer
	 */
	@PutMapping(value = "/edit/{id}", produces = "application/json")
	public ResponseEntity<?> editCategoryOffer(@PathVariable Integer id, @RequestBody CategoryOffer categoryOffer) {
		
		logger.info("Calling CategoryOffer Service - Edit, id : " + id + ", categoryOffer :" + categoryOffer);
		return service.editCategoryOffer(id, categoryOffer);
	}
	
	/**
	 * @param id - id of the CategoryOffer to be deleted
	 * @return the deleted entity CategoryOffer
	 */
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteCategoryOffer(@PathVariable Integer id) {
		
		logger.info("Calling CategoryOffer Service - Delete, id : " + id);
		return service.deleteCategoryOffer(id);
	}
	
	/**
	 * 
	 * @param id - id of the CategoryOffer to be retrieved
	 * @return the requested entity CategoryOffer
	 */
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<?> getCategoryOffer(@PathVariable Integer id) {
		
		logger.info("Calling CategoryOffer Service - Get, id : " + id);
		return service.getCategoryOffer(id);
	}
	
	/**
	 * @return list of CategoryOffer Entities
	 */
	@GetMapping(value = "/getall", produces = "application/json")
	public ResponseEntity<?> getAllCategoryOffers() {
		
		logger.info("Calling CategoryOffer Service - Get All");
		return service.getAllCategoryOffers();
	}
	
	/**
	 * @param categoryId - id of the Category of which the offers are to be retrieved
	 * @return list of CategoryOffer Entities
	 */
	@GetMapping(value = "/getbycategory/{categoryId}", produces = "application/json")
	public ResponseEntity<?> getOffersByCategoryId(@PathVariable Integer categoryId){
		
		logger.info("Calling CategoryOffer Service - Get Offers by Category Id");
		return service.getOffersByCategoryId(categoryId);
	}
}
