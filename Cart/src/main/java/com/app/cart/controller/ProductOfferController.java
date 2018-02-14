package com.app.cart.controller;

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
import com.app.cart.entity.ProductOffer;
import com.app.cart.service.ProductOfferService;

@RestController
@RequestMapping("/productoffer")
public class ProductOfferController {

	@Autowired
	private ProductOfferService service;

	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<?> addOffer(@RequestBody ProductOffer offer){	
		return service.addOffer(offer);
	}
	
	@PutMapping(value = "/edit/{id}", produces = "application/json")
	public ResponseEntity<?> editOffer(@PathVariable Integer id ,@RequestBody ProductOffer offer){	
		return service.editOffer(id, offer);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteOffer(@PathVariable Integer id){	
		return service.deleteOffer(id);
	}
	
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<?> getOffer(@PathVariable Integer id){
		return service.getOffer(id);
	}

	@GetMapping(value = "/getall", produces = "application/json")
	public ResponseEntity<?> getallOffers(){
		return service.getAllOffers();
	}

	@GetMapping(value = "/getbyproduct/{id}", produces = "application/json")
	public ResponseEntity<?> getOffersByProduct(@PathVariable Integer id){
		return service.getOffersByProduct(id);
	}
}
