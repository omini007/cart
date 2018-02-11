package com.app.cart.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

/**
 * @author omkar.nikam
 * @since 03-Feb-2018
 * Table for Brand Offers
 */

@Entity
@Table(name="BrandOffer")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "brandOfferId")
public class BrandOffer {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="brandoffer_seq", sequenceName="brandoffer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="brandoffer_seq")
	private Integer brandOfferId;
	
	@Column(unique = false, nullable = false, length=50)
	private String offerDescription;
	
	@Column(unique = false, nullable = false, length=15)
	private String couponCode;
	
	@Column(unique = false, nullable = true)
	private Double discountPercent;
	
	@Column(unique = false, nullable = true)
	private Double discountAmount;
	
	@Column(unique = false, nullable = false)
	private Double minOrderAmount;
	
	@Column(unique = false, nullable = false)
	private Double maxDiscountAmount;
	
	@Column(unique = false, nullable = false)
	private Date creationDate;
	
	@Column(unique = false, nullable = false)
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn( name = "brandId", nullable = false )
	private Brand brand;
	
}
