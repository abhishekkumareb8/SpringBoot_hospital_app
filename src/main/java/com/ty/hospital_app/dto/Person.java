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
public class Person {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
    private long phone;
	@NotNull
    private String email;
	@NotNull
    private String password;
    
    private List<Encounter>encounter;

    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Encounter> getEncounter() {
		return encounter;
	}

	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", encounter=" + encounter + "]";
	}
    
    

}
