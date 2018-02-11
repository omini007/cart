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

import com.app.cart.entity.BrandOffer;
import com.app.cart.entity.Offer;
import com.app.cart.service.BrandOfferService;

/**
 * @author Pratik Upare
 * 
 */

@RestController
@RequestMapping("/brandoffer")
public class BrandOfferController {
	
	@Autowired
	private BrandOfferService brandOfferService;	
	
	private static final Logger logger=Logger.getLogger(BrandOfferController.class);

	@PostMapping(value="/add")
	public ResponseEntity<?> addBrandOffer(@RequestBody BrandOffer brandOffer)
	{	
		return brandOfferService.addBrandOffer(brandOffer);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editBrandOffer(@PathVariable Integer id ,@RequestBody BrandOffer brandOffer)
	{	
		return brandOfferService.editBrandOffer(id, brandOffer);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBrandOffer(@PathVariable Integer id)
	{	
		return brandOfferService.deleteBrandOffer(id);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getBrandOffer(@PathVariable Integer id)
	{		
		return brandOfferService.getBrandOffer(id);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllBrandOffers()
	{	
		return brandOfferService.getAllBrandOffers();
	}

	@GetMapping("/get/{brandName}")
	public ResponseEntity<?> getAllBrandOffersByBrandName(@PathVariable String brandName)
	{	
		return brandOfferService.getAllBrandOffersByBrandName(brandName);
	}
}
	
	
	
	


