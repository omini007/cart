package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Product;


/**
 * @author Priyanka Bagul
 */

public interface ProductService {
	
	public ResponseEntity<?> addProduct( Product product);
	
	public ResponseEntity<?> editProduct( Integer id,  Product product);
	
	public ResponseEntity<?> deleteProduct( Integer id);
	
	public ResponseEntity<?> getProduct( Integer id);
	
	public ResponseEntity<?> getAllProducts();

	public ResponseEntity<?> getByCategory( Integer Categoryid);
	
	public ResponseEntity<?> getByBrand( Integer Brandid);

}
