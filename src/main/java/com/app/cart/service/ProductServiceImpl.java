package com.app.cart.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.app.cart.entity.Product;
import com.app.cart.repository.ProductRepository;

/**
 * @author Priyanka Bagul
 * 
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository repo;

	@Override
	public ResponseEntity<?> addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return new ResponseEntity<Integer>(repo.save(product).getProductId(),new HttpHeaders(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editProduct(Integer id, Product product) {
		// TODO Auto-generated method stub
		Product datacopy=repo.findOne(id);
		
		if(datacopy==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		product.setProductId(datacopy.getProductId());
		
		return new ResponseEntity<Product>(repo.save(product), new HttpHeaders(),HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<?> deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
		Product delObject=repo.findOne(id);
		if(delObject==null)
		{
			return ResponseEntity.notFound().build();
			
		}
		else
		{
			repo.delete(id);
		}
		
		return new ResponseEntity<Product>(delObject,new HttpHeaders(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProduct(Integer id) {
		// TODO Auto-generated method stub
		Product reqObject=repo.findOne(id);
		if(reqObject==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Product>(reqObject,new HttpHeaders(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> productList=repo.findAll();
		
		if(productList==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return  new ResponseEntity<List<Product>>(productList,new HttpHeaders(),HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> getByCategory(Integer Categoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getByBrand(Integer Brandid) {
		// TODO Auto-generated method stub
		return null;
	}

}
