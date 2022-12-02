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
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @NotNull
	private String name;
    @NotNull
	private long phone;
	private String hospitalHead;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branches>branches;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getManager() {
		return hospitalHead;
	}

	public void setManager(String manager) {
		hospitalHead = manager;
	}

	public List<Branches> getBranches() {
		return branches;
	}

	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", phone=" + phone + ", Manager=" + hospitalHead + ", branches="
				+ branches + "]";
	}
	


}
