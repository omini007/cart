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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for Product Offers
 */

@Entity
@Table(name="ProductOffer")
@Data
@EqualsAndHashCode(exclude = {"product"})
@ToString(exclude = {"product"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productOfferId")
@ApiModel
public class ProductOffer {

	@ApiModelProperty(required = true,value="Keep 0 , Id will be generated Automatically")
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="productoffer_seq", sequenceName="productoffer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productoffer_seq")
	private Integer productOfferId;
	
	@ApiModelProperty(value="Max Length is 50 Characters", required = true)
	@Column(unique = false, nullable = false, length=50)
	private String offerDescription;
	
	@ApiModelProperty(value="Max Length is 15 Characters", required = true)
	@Column(unique = false, nullable = false, length=15)
	private String couponCode;
	
	
	@ApiModelProperty(required = false, allowEmptyValue=true, value="Put 0 in case of nothing")
	@Column(unique = false, nullable = true)
	private Double discountPercent;
	
	@ApiModelProperty(required = false, allowEmptyValue=true, value="Put 0 in case of nothing")
	@Column(unique = false, nullable = true)
	private Double discountAmount;
	
	@ApiModelProperty(required = true)
	@Column(unique = false, nullable = false)
	private Double minOrderAmount;
	
	@ApiModelProperty(required = true)
	@Column(unique = false, nullable = false)
	private Double maxDiscountAmount;
	
	@ApiModelProperty(value="format : dd-MM-yyyy", required = true)
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date creationDate;
	
	@ApiModelProperty(value="format : dd-MM-yyyy", required = true)
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date expiryDate;
	
	@ApiModelProperty(value="Id of Existing Product", required = true)
	@ManyToOne
	@JoinColumn( name = "productId", nullable = false )
	private Product product;
	
}
