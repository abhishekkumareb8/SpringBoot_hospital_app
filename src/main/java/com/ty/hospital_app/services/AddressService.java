package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branches;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;
	
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address ,int id){
		Address address2 = dao.getAddressById(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Address>> entity = new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		
		if(address2!=null) {
			address.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Address detail updated sucessfully");
			responseStructure.setData(dao.updateAddress(address));
		}
		else {
			throw new UnableToUpdateException();
		}
		
		return entity;
	}
	
	public ResponseEntity<ResponseStructure<Address>> getBranches(int id) {
		Address address = dao.getAddressById(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Address>> responseEntity = new ResponseEntity<ResponseStructure<Address>>(
				responseStructure, HttpStatus.OK);
		if (address!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Address detail received sucessfully");
			responseStructure.setData(dao.getAddressById(id));
		}

		else {
			throw new NoSuchIdFoundException();
		}

		return responseEntity;

	}

}
