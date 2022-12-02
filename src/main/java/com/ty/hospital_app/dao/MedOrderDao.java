package com.ty.hospital_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.dto.MedOrder;
import com.ty.hospital_app.repository.MedOrderRepository;
@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepository repository;
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
		
	}
	
	public MedOrder updateMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
		
	}
	
	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional=repository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	
	public String deleteMedOrderById(int id)
	{
		repository.deleteById(id);
		return "deleted";
		

}
}