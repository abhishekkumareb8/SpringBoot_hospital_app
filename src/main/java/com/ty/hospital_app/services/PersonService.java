package com.ty.hospital_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.Exception.UnableToUpdateException;
import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Person>> entity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Person detail saved sucessfully");
		responseStructure.setData(dao.savePerson(person));
		return entity;
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person,int id){
		Person person2 = dao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Person>> entity  = new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
       if(person2!=null) {
    	   person.setId(id);
    	   responseStructure.setStatus(HttpStatus.OK.value());
    	   responseStructure.setMessage("Person detail updated Sucessfully");
    	   responseStructure.setData(dao.updatePerson(person));
       }

       else {
    	   throw new UnableToUpdateException();
       }
       return entity;
		
	
	}
	
	public ResponseEntity<ResponseStructure<Person>>   getPerson(int id){
		Person person = dao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Person>> entity  = new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
       if(person!=null) {
    	   responseStructure.setStatus(HttpStatus.OK.value());
    	   responseStructure.setMessage("person detail received sucessfully");
    	   responseStructure.setData(dao.getPersonById(id));
       }
       else {
    	   throw new UnableToUpdateException();
       }
       
       return entity;
		

	
	public ResponseEntity<ResponseStructure<String>>   deletePerson(int id){
		Person person = dao.getPersonById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> entity  = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.CREATED);
       if(person!=null) {
    	   responseStructure.setStatus(HttpStatus.OK.value());
    	   responseStructure.setMessage("person detail deleted sucessfully");
    	   responseStructure.setData(dao.deletePersonById(id));
       }
       else {
    	   throw new NoSuchIdFoundException();
       }
       
       return entity;
		
	}

}
