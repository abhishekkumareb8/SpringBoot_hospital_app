package com.ty.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_app.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {

}
