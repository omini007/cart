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

	@PostMapping(value="/add", produces = "application/json")
	public ResponseEntity<?> addBrandOffer(@RequestBody BrandOffer brandOffer)
	{	
		return brandOfferService.addBrandOffer(brandOffer);
	}

	@PutMapping(value = "/edit/{id}", produces = "application/json")
	public ResponseEntity<?> editBrandOffer(@PathVariable Integer id ,@RequestBody BrandOffer brandOffer)
	{	
		return brandOfferService.editBrandOffer(id, brandOffer);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteBrandOffer(@PathVariable Integer id)
	{	
		return brandOfferService.deleteBrandOffer(id);
	}
	
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<?> getBrandOffer(@PathVariable Integer id)
	{		
		return brandOfferService.getBrandOffer(id);
	}
	
	@GetMapping(value = "/getall", produces = "application/json")
	public ResponseEntity<?> getAllBrandOffers()
	{	
		return brandOfferService.getAllBrandOffers();
	}

	/*@GetMapping(value = "/get/{brandName}", produces = "application/json")
	public ResponseEntity<?> getAllBrandOffersByBrandName(@PathVariable String brandName)
	{	
		return brandOfferService.getAllBrandOffersByBrandName(brandName);
	}*/
	
	@GetMapping(value = "/getbybrand/{id}", produces = "application/json")
	public ResponseEntity<?> getAllBrandOffersByBrandId(@PathVariable Integer id){
		
		return brandOfferService.getAllBrandOffersByBrandId(id);
	}
}
	
	
	
	


