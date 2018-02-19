package com.app.cart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Omkar Nikam
 * @since 03-Feb-2018
 * Table for General Offers
 */

@Entity
@Table(name="Offer")
@Data
@ApiModel
public class Offer {


	@ApiModelProperty(required = true, value="Keep 0 , Id will be generated Automatically")
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="offer_seq", sequenceName="offer_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="offer_seq")
	private Integer offerId;

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

	@ApiModelProperty(required = false, allowEmptyValue=true, value="Put 0 in case of nothing")
	@Column(unique = false, nullable = true)
	private Double minOrderAmount;

	@ApiModelProperty(required = false, allowEmptyValue=true, value="Put 0 in case of nothing")
	@Column(unique = false, nullable = true)
	private Double maxDiscountAmount;

	@ApiModelProperty(required = false, allowEmptyValue=true, value="Put 0 in case of nothing")
	@Column(unique = false, nullable = true)
	private Integer minNumberOfProducts;

	@ApiModelProperty(value="format : dd-MM-yyyy", required = true)
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date creationDate;

	@ApiModelProperty(value="format : dd-MM-yyyy", required = true)
	@Column(unique = false, nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date expiryDate;
	
}
