package com.app.cart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.entity.Product;
import com.app.cart.service.ProductService;

/**
 * @author Priyanka Bagul
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
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editProduct(@PathVariable Integer id, @RequestBody Product product) {
		return service.editProduct(id, product);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return service.deleteProduct(id);
	}
	
	@PostMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		return service.getProduct(id);
	}
	
	@PostMapping("/getall")
	public ResponseEntity<?> getAllProducts() {
		return service.getAllProducts();
	} 
	
	@PostMapping("/getByCategory/{category}")
	public ResponseEntity<?> getByCategory(Integer Categoryid) {
		return service.getByCategory(Categoryid);
	}
	
	@PostMapping("/getByBrand/{brand}")
	public ResponseEntity<?> getByBrand(Integer Brandid) {
		return service.getByBrand(Brandid);
	}

	
}
