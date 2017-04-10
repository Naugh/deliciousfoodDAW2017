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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	private String surnames;
	
	
	@OneToMany
	@JsonIgnore
	private List<Request> requests = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<String> roles = new ArrayList<>(Arrays.asList("ROLE_PERSON"));;
	
	public Person() {
	}

	public Person(String name, String surnames, String password, String email, String address, String phone, String postalCode) {
		super(name, password, email, address, phone, postalCode);
		this.surnames=surnames;
	}

	public boolean hasRequest(Long id){
		for(int i = 0; i < requests.size(); i++){
			if(requests.get(i).getId()==id){
				return true;
			}
		}
		return false;
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

