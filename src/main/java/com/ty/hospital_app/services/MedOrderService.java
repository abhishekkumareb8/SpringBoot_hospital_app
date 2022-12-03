package com.ty.hospital_app.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.Exception.NoSuchIdFoundException;
import com.ty.hospital_app.dao.MedOrderDao;
import com.ty.hospital_app.dto.MedOrder;
import com.ty.hospital_app.util.ResponseStructure;

@Service
public class MedOrderService {

	private MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		MedOrder medOrder = dao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<MedOrder>> entity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);
		if (medOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("medorder detail received");
			responseStructure.setData(dao.getMedOrderById(id));
		} else {
			throw new NoSuchIdFoundException();
		}
		return entity;

	}

	public ResponseEntity<ResponseStructure<MedOrder>> UpdateMedOrder(MedOrder medOrder, int id) {
		MedOrder medOrder1 = dao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<MedOrder>> entity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);
		if (medOrder1 != null) {
			medOrder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("medorder detail  updated sucessfully");
			responseStructure.setData(dao.updateMedOrder(medOrder));
		} else {
			throw new NoSuchIdFoundException();
		}
		return entity;

	}

}
