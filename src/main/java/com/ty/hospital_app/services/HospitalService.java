package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Hospital detail saved sucessfully");
		responseStructure.setData(dao.saveHospital(hospital));

		ResponseEntity<ResponseStructure<Hospital>> responseEntity = new ResponseEntity<ResponseStructure<Hospital>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital, int id) {
		Hospital hospital2 = dao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity = new ResponseEntity<ResponseStructure<Hospital>>(
				responseStructure, HttpStatus.OK);
		if (hospital2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Hospital detail updated sucessfully");
			responseStructure.setData(dao.updateHospital(hospital));
		}

		else {
			throw new UnableToUpdateException();
		}

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {
		Hospital hospital2 = dao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity = new ResponseEntity<ResponseStructure<Hospital>>(
				responseStructure, HttpStatus.OK);
		if (hospital2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Hospital detail received sucessfully");
			responseStructure.setData(dao.updateHospital(dao.getHospitalById(id)));
		}

		else {
			throw new NoSuchIdFoundException();
		}

		return responseEntity;

	}
	
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		Hospital hospital2 = dao.getHospitalById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		if (hospital2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Hospital detail deleted sucessfully");
			responseStructure.setData(dao.deleteHospitalById(id));
		}

		else {
			throw new NoSuchIdFoundException();
		}

		return responseEntity;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}