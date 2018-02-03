package com.app.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.cart.entity.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {

}
