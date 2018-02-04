package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Brand;

public interface BrandService {

	public ResponseEntity<?> addBrand(Brand brand);
	
	public ResponseEntity<?> editBrand(Integer id ,Brand brand);
	
	public ResponseEntity<?> deleteBrand(Integer id);
	
	public ResponseEntity<?> getBrand(Integer id);
	
	public ResponseEntity<?> getAllBrands();
}
