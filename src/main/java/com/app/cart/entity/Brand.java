package com.app.cart.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * Table for Brand
 */

@Entity
@Table(name="Brand")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "brandId")
@ToString(exclude= {"offers","products"})
@EqualsAndHashCode(exclude= {"offers","products"})
public class Brand {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="brand_seq", sequenceName="brand_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="brand_seq")
	private Integer brandId;
	
	@Column(unique = false, nullable = false, length=50)
	private String brandName;
	
	@OneToMany( mappedBy = "brand" , cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonIgnore
	private Set<Product> products;
	
	@OneToMany( mappedBy = "brand" , cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonIgnore
	private Set<BrandOffer> offers;
	
}
