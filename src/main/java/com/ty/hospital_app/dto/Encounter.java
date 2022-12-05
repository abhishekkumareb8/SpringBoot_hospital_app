package com.ty.hospital_app.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String reason;
	
	
	private List<Branches>branches;
	
	private List<MedOrder>medorders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<Branches> getBranches() {
		return branches;
	}

	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}

	public List<MedOrder> getMedorders() {
		return medorders;
	}

	public void setMedorders(List<MedOrder> medorders) {
		this.medorders = medorders;
	}

	@Override
	public String toString() {
		return "Encounter [id=" + id + ", name=" + name + ", reason=" + reason + ", branches=" + branches
				+ ", medorders=" + medorders + "]";
	}

	
	
}
