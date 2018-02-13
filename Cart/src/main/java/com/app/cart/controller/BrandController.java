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
import com.app.cart.entity.Brand;
import com.app.cart.service.BrandService;

/**
 * @author pradnya.katkar
 * @since 04-02-2018
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	private static final Logger logger=Logger.getLogger(BrandController.class);

	@Autowired
	BrandService service;

	/**
	 * @param brand
	 * @return brand.id
	 */
	@PostMapping("/add")
	public ResponseEntity<?> addBrand(@RequestBody Brand brand){	
		logger.info("Object ->"+brand);
		return service.addBrand(brand);
	}

	/**
	 * @param id
	 * @param brand
	 * @return
	 */
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editBrand(@PathVariable Integer id ,@RequestBody Brand brand){
		logger.info("Object and ID -> "+brand+ ", ID -> "+id);
		return service.editBrand(id, brand);
	}

	/**
	 * @param id
	 * @return 
	 */	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable Integer id){	
		logger.info("Id to be deleted -> "+id);
		return service.deleteBrand(id);
	}

	/**
	 * @param id
	 * @return BrandEntity
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getBrand(@PathVariable Integer id){	
		logger.info("Id to be deleted -> "+id);
		return service.getBrand(id);
	}

	/**
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllBrands(){
		return service.getAllBrands();
	}
}
