package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Product;
import com.app.cart.entity.ProductOffer;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategoryCategoryId(Integer id);
	
	List<Product> findByBrandBrandId(Integer id);
	
}
