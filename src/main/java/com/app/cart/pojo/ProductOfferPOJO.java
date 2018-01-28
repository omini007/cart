package com.app.cart.pojo;

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
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author omkar.nikam
 * Table for Product Offers
 */

@Entity
@Table(name="ProductOffer")
@Data
public class ProductOfferPOJO {

	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="ProductOffer_SEQ", sequenceName="ProductOffer_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ProductOffer_SEQ")
	private Integer productOfferId;
	
	@Column(unique = false, nullable = false, length=50)
	private String offerDescription;
	
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
	@JoinColumn( name = "productId", nullable = false )
	private ProductPOJO product;
	
}
