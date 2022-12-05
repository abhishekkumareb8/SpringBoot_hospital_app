package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Branches;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	Branches branches;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		int bId= branches.getId();
		ResponseEntity<ResponseStructure<Encounter>> entity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Person detail saved sucessfully");
		responseStructure.setData(dao.saveEncounter(encounter));
		return entity;
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		Encounter encounter = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Encounter>> entity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.OK);

		if (encounter != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Encounter detail received");
			responseStructure.setData(dao.getEncounterById(id));
		} else {
			throw new NoSuchIdFoundException();
		}

		return entity;
	}

	public ResponseEntity<ResponseStructure<Encounter>> UpdateEncounter(Encounter encounter, int id) {
		Encounter encounter2 = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Encounter>> entity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.OK);
		if (encounter2 != null) {
			encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Encounter detail update Sucessfully");
			responseStructure.setData(dao.updateEncounter(encounter));
		} else {
			throw new UnableToUpdateException();
		}

		return entity;
	}
}
