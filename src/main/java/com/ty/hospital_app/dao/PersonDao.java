package com.ty.hospital_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.repository.PersonRepository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepository repository;
	
	public Person savePerson(Person person) {
		return repository.save(person);
		
	}
	
	public Person updatePerson(Person person) {
		return repository.save(person);
		
	}
	
	public Person getPersonById(int id) {
		Optional<Person> optional=repository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	
	public String deletePersonById(int id)
	{
		repository.deleteById(id);
		return "deleted";
		

	}
}