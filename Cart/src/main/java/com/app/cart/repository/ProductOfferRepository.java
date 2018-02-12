package com.app.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.cart.entity.Product;
import com.app.cart.entity.ProductOffer;

@Repository
public interface ProductOfferRepository extends JpaRepository<ProductOffer, Integer> {
	
	@Query(value="from ProductOffer c where c.product.productId=?1")
	List<ProductOffer> findByProduct(Integer id);
}
