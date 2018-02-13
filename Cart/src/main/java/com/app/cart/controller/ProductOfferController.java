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

	@PostMapping("/add")
	public ResponseEntity<?> addOffer(@RequestBody ProductOffer offer){	
		return service.addOffer(offer);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editOffer(@PathVariable Integer id ,@RequestBody ProductOffer offer){	
		return service.editOffer(id, offer);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOffer(@PathVariable Integer id){	
		return service.deleteOffer(id);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOffer(@PathVariable Integer id){
		return service.getOffer(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getallOffers(){
		return service.getAllOffers();
	}

	@GetMapping("/getbyproduct/{id}")
	public ResponseEntity<?> getOffersByProduct(@PathVariable Integer id){
		return service.getOffersByProduct(id);
	}
}
