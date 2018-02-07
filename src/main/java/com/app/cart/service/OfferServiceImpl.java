package com.app.cart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cart.entity.Offer;
import com.app.cart.repository.OfferRepository;

/**
 * @author Nilesh Sargar
 * 
 */


@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository repo;
	
	
	
	@Override
	public ResponseEntity<?> addOffer(Offer offer) {
		// TODO Auto-generated method stub
		
		return new ResponseEntity<Integer>(repo.save(offer).getOfferId(),new HttpHeaders(),HttpStatus.OK);
	
	}

	
	@Override
	public ResponseEntity<?> editOffer(Integer id, Offer offer) {
		// TODO Auto-generated method stub
		
		Offer dbcopy= repo.findOne(id);
		
		if(null==dbcopy)
			return ResponseEntity.notFound().build();
		
		offer.setOfferId(dbcopy.getOfferId()); //Just set new received offer objects id field to the one we want to edit in DB and persist using save()
		
		return new ResponseEntity<Offer>(repo.save(offer),new HttpHeaders(),HttpStatus.OK);
	
	
	
	}

	@Override
	public ResponseEntity<?> deleteOffer(Integer id) {
		// TODO Auto-generated method stub
		Offer deletedObject=repo.findOne(id);
		if(null==deletedObject)
			return ResponseEntity.notFound().build();
		else {
		repo.delete(id);
		return new ResponseEntity<Offer>(deletedObject,new HttpHeaders(),HttpStatus.OK);}	
		
	}

	@Override
	public ResponseEntity<?> getOffer(Integer id) {
		// TODO Auto-generated method stub
		
		Offer requestedObject=repo.findOne(id);
		
		if(null==requestedObject)
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<Offer>(requestedObject,new HttpHeaders(),HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getAllOffers() {
		// TODO Auto-generated method stub
	
		List<Offer> list=repo.findAll();
		
		if(null==list)
			return ResponseEntity.notFound().build();
		
		return new ResponseEntity<List<Offer>>(list,new HttpHeaders(),HttpStatus.OK);

		
	}

}
