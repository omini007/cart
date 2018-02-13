package com.app.cart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.entity.Category;
import com.app.cart.entity.Offer;
import com.app.cart.repository.CategoryRepository;
import com.app.cart.service.OfferService;


/**
 * @author Nilesh Sargar
 * 
 */

@RestController
@RequestMapping("/offer")
public class OfferController {
	
	@Autowired
	private OfferService service;	
	
	@Autowired
	private CategoryRepository repo;
	
	private static final Logger logger=Logger.getLogger(OfferController.class);

	@PostMapping("/add")
	public ResponseEntity<?> addOffer(@RequestBody Offer offer)
	{	
		return service.addOffer(offer);
	}

	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editOffer(@PathVariable Integer id ,@RequestBody Offer offer)
	{	
	
		return service.editOffer(id, offer);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteOffer(@PathVariable Integer id)
	{	
		return service.deleteOffer(id);
	}
	

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOffer(@PathVariable Integer id)
	{	
	
		return service.getOffer(id);
	}
	

	@GetMapping("/getcat/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Integer id)
	{	
	
		return new ResponseEntity<Category>(repo.findOne(id),new HttpHeaders(),HttpStatus.OK);
	}

	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllOffers()
	{	
		return service.getAllOffers();
	}







}
	
	
	
	


