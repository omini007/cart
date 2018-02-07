package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
