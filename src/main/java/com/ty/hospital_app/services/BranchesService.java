package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.BranchesDao;
import com.ty.hospital_app.dto.Branches;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class BranchesService {
   
	@Autowired
	private BranchesDao dao;
	
	
	public ResponseEntity<ResponseStructure<Branches>> updateBranches(Branches branches,int id){
		Branches branches2 = dao.getBranchesById(id);
		ResponseStructure<Branches> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Branches>> entity = new ResponseEntity<ResponseStructure<Branches>>(responseStructure,HttpStatus.OK);
		
		if(branches2!=null) {
			branches.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("branch updated sucessfully");
			responseStructure.setData(dao.updateBranches(branches));
		}
		else {
			throw new UnableToUpdateException();
		}
		
		return entity;
	}
	
	
	public ResponseEntity<ResponseStructure<Branches>> getBranches(int id) {
		Branches branches = dao.getBranchesById(id);
		ResponseStructure<Branches> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Branches>> responseEntity = new ResponseEntity<ResponseStructure<Branches>>(
				responseStructure, HttpStatus.OK);
		if (branches!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("branch detail received sucessfully");
			responseStructure.setData(dao.getBranchesById(id));
		}

		else {
			throw new NoSuchIdFoundException();
		}

		return responseEntity;

	}
}
