package com.app.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cart.entity.Category;

/**
 * @author Omkar Nikam
 * @since 04-Feb-2018
 * Category Repository
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// Query Methods go here
}
