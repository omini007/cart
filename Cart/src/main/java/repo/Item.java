package repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Item DTO
@Entity
@Data
@Table(name="item")
public class Item {

	
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="item")
	private String item;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="discount")
	private Long discount;
	
	@Column(name="price")
	private Long price;
	
	
	
	
	
}
