package com.ty.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_app.dto.Person;

public interface PersonRepository  extends JpaRepository<Person, Integer>{

}
