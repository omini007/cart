package com.app.cart.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author omkar.nikam
 * Table for Product
 */

@Entity
@Table(name="Product")
@Data
@EqualsAndHashCode(exclude = {"category","brand","offers"})
@ToString(exclude = {"category","brand","offers"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
public class Product {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="product_seq", sequenceName="product_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	private Integer productId;

	@Column(unique = false, nullable = false, length=50)
	private String productName;
	
	@Column(unique = false, nullable = false, length=200)
	private String productDescription;
	
	@Column(unique = false, nullable = false)
	private Integer unit;
	
	@Column(unique = false, nullable = false)
	private Integer quantity;
	
	@Column(unique = false, nullable = false)
	private Double rate;
	
	@Column(unique = false, nullable = true, length=50)
	private String productImagePath;
	
	@Column(unique = false, nullable = false)
	private Date stockUpdatedDate;
	
	@ManyToOne
	@JoinColumn( name = "categoryId", nullable = false )
	private Category category;
	
	@ManyToOne
	@JoinColumn( name = "brandId", nullable = false )
	private Category brand;
	
	@OneToMany( mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = false )
	@JsonIgnore
	private Set<ProductOffer> offers;

}
