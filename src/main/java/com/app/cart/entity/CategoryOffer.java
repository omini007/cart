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
import lombok.Data;

/**
 * @author omkar.nikam
 * Table for Category Offers
 */

@Entity
@Table(name="CategoryOffer")
@Data
public class CategoryOffer {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="CategoryOffer_SEQ", sequenceName="CategoryOffer_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CategoryOffer_SEQ")
	private Integer categoryOfferId;
	
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
	@JoinColumn( name = "categoryId", nullable = false )
	private Category category;
	
}
