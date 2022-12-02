package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.ItemsDao;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;
	
	
	public ResponseEntity<ResponseStructure<Items>>  getItemsById(int id){
		Items items = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Items>> entity = new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		if(items!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(items);
			responseStructure.setMessage("Items detailed received");
		}
		else {
			throw new NoSuchIdFoundException();
		}
		return entity;
		
	}
	
	
	public ResponseEntity<ResponseStructure<Items>>  UpdateItems(Items items,int id){
		Items items1 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Items>> entity = new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		if(items1!=null) {
			items.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.updateItems(items));
			responseStructure.setMessage("Items detailed received");
		}
		else {
			throw new UnableToUpdateException();
		}
		return entity;
		
	}
}
