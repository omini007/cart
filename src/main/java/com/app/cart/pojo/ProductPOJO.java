package com.app.cart.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import lombok.Data;

/**
 * @author omkar.nikam
 * Table for Product
 */

@Entity
@Table(name="Product")
@Data
public class ProductPOJO {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="Product_SEQ", sequenceName="Product_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Product_SEQ")
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
	private CategoryPOJO category;
	
	@ManyToOne
	@JoinColumn( name = "brandId", nullable = false )
	private CategoryPOJO brand;
	
	@OneToMany( mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<ProductOfferPOJO> offers = new ArrayList<ProductOfferPOJO>();

}
