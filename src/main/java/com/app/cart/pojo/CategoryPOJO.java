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
 * Table for Category
 */

@Entity
@Table(name="Category")
@Component
@Data
public class CategoryPOJO {
	
	@Id
	@Column(unique = true, nullable = false)
	@SequenceGenerator(name="Category_SEQ", sequenceName="Category_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Category_SEQ")
	private Integer categoryId;
	
	@Column(unique = false, nullable = false, length=50)
	private String categoryName;
	
	@Column(unique = false, nullable = true, length=50)
	private String categoryImagePath;
	
	@Column(unique = false, nullable = true)
	private Integer parentCategoryId;
	
	@OneToMany( mappedBy = "category" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<ProductPOJO> products = new ArrayList<ProductPOJO>();
	
	@OneToMany( mappedBy = "category" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<CategoryOfferPOJO> offers = new ArrayList<CategoryOfferPOJO>();
	
}
