package com.ty.hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.services.PersonService;
import com.ty.hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@ApiOperation(value = "Save User", notes = "It is used to save User")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person){
		return service.savePerson(person);
	} 
	
	@ApiOperation(value = "Save User", notes = "It is used to save User")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id){
		return service.getPerson(id);
	}

	@ApiOperation(value = "Save User", notes = "It is used to save User")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ResponseStructure<Person>> updatePersonById(@RequestBody Person person, @RequestParam int id){
		return service.updatePerson(person, id);
	}
	
	@ApiOperation(value = "Save User", notes = "It is used to save User")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@RequestParam int id){
		return service.deletePerson(id);
	}
	
}
