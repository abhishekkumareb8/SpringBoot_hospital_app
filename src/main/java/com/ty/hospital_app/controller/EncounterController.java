package com.ty.hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.services.EncounterService;
import com.ty.hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("encounter")
public class EncounterController {

	@Autowired
	private EncounterService service;
	
	@ApiOperation(value = "Get Encounter", notes = "It is used to Get Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id){
		return service.getEncounterById(id);
	}
	
	@ApiOperation(value = "Update Encounter", notes = "It is used to Update Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(@RequestBody @Valid  Encounter encounter, @RequestBody int id ){
		return service.UpdateEncounter(encounter, id);
	}
	
	@ApiOperation(value = "Save Encounter", notes = "It is used to Save Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounEntity(@RequestBody @Valid Encounter encounter ,@RequestParam int id){
		return service.saveEncounter(encounter);
	}
	
}
