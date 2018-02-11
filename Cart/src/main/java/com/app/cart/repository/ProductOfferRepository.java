package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.ProductOffer;

@Repository
public interface ProductOfferRepository extends JpaRepository<ProductOffer, Integer> {
	
}
