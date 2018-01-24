package com.app.cart.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author omkar.nikam
 * Only for database testing purpose 
 * Actual POJO is not yet developed
 */

@Entity
@Data
public class Item {
	
	@Id
	Integer itemId;
	
	String itemName; 
	
}
