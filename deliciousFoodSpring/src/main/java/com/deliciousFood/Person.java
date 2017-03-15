package com.deliciousFood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	private String surnames;
	
	
	@OneToMany
	private List<Request> requests = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>(Arrays.asList("PERSON"));;
	
	public Person() {
	}

	public Person(String name, String surnames, String password, String email, String address, String phone, String postalCode) {
		super(name, password, email, address, phone, postalCode);
		this.surnames=surnames;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	

}

