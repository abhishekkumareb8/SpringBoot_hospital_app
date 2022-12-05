package com.ty.hospital_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.services.AddressService;
import com.ty.hospital_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	private AddressService service;

	@ApiOperation(value = "Update Address", notes = "It is used to Update Address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<ResponseStructure<Address>> updateAddrss(@RequestBody @Valid  Address address,@RequestParam int id ){
		return service.updateAddress(address, id);
	}
	
	@ApiOperation(value = "Get Address", notes = "It is used to Get Address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id){
		return service.getBranches(id);
	}
}
