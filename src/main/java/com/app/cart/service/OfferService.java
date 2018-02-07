package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.cart.entity.Offer;

public interface OfferService {

	public ResponseEntity<?> addOffer(@RequestBody Offer offer);
	
	public ResponseEntity<?> editOffer(@PathVariable Integer id ,@RequestBody Offer offer);
	
	public ResponseEntity<?> deleteOffer(@PathVariable Integer id);
	
	public ResponseEntity<?> getOffer(@PathVariable Integer id);
	
	public ResponseEntity<?> getAllOffers();
	
}
