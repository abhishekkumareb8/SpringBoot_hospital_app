package com.ty.hospital_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.repository.HospitalRepository;
@Repository
public class HospitalDao {
	
	
	@Autowired
	private HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
		
	}
	
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
		
	}
	
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional=repository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	
	public String deleteHospitalById(int id)
	{
		repository.deleteById(id);
		return "deleted";
		
	}
}
