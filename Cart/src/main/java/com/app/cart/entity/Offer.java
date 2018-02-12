package com.app.cart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for General Offers
 */

@Entity
@Table(name="Offer")
@Data
public class Offer {

	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="offer_seq", sequenceName="offer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="offer_seq")
	private Integer offerId;
	
	@Column(unique = false, nullable = false, length=50)
	private String offerDescription;
	
	@Column(unique = false, nullable = false, length=15)
	private String couponCode;
	
	@Column(unique = false, nullable = true)
	private Double discountPercent;
	
	@Column(unique = false, nullable = true)
	private Double discountAmount;
	
	@Column(unique = false, nullable = true)
	private Double minOrderAmount;
	
	@Column(unique = false, nullable = true)
	private Double maxDiscountAmount;
	
	@Column(unique = false, nullable = true)
	private Integer minNumberOfProducts;
	
	@Column(unique = false, nullable = false)
	private Date creationDate;
	
	@Column(unique = false, nullable = false)
	private Date expiryDate;
	
}
