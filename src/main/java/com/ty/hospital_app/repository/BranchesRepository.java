package com.ty.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_app.dto.Branches;


public interface BranchesRepository extends JpaRepository<Branches, Integer> {

}
