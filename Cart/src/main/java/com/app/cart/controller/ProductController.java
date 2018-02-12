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
import com.app.cart.entity.Product;
import com.app.cart.service.ProductService;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 */

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	private static final Logger logger=Logger.getLogger(ProductController.class);

	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editProduct(@PathVariable Integer id, @RequestBody Product product) {
		return service.editProduct(id, product);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return service.deleteProduct(id);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		return service.getProduct(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllProducts() {
		return service.getAllProducts();
	} 

	@GetMapping("/getbycategory/{id}")
	public ResponseEntity<?> getByCategory(@PathVariable Integer id) {
		return service.getProductByCategory(id);
	}

	@GetMapping("/getbybrand/{id}")
	public ResponseEntity<?> getByBrand(@PathVariable Integer id) {
		return service.getProductByBrand(id);
	}


}
