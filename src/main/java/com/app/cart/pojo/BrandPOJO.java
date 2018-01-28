package com.app.cart.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author omkar.nikam
 * Table for Brand
 */

@Entity
@Table(name="Brand")
@Data
public class BrandPOJO {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="Brand_SEQ", sequenceName="Brand_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Brand_SEQ")
	private Integer brandId;
	
	@Column(unique = false, nullable = false, length=50)
	private String brandName;
	
	@OneToMany( mappedBy = "brand" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<ProductPOJO> products = new ArrayList<ProductPOJO>();
	
	@OneToMany( mappedBy = "brand" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<BrandOfferPOJO> offers = new ArrayList<BrandOfferPOJO>();
	
}
