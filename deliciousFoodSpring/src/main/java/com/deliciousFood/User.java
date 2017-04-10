package com.deliciousFood;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@MappedSuperclass
public abstract class User {
	
	private String name;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;
	private String address;
	private String phone;
	private String postalCode;
	
	public User() {
	}

	public User(String name, String password, String email, String address, String phone, String postalCode) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.postalCode = postalCode;
	}

	public User(String name, String address, String email, String phone, String postalCode) {
		this.name=name;
		this.address=address;
		this.email=email;
		this.phone=phone;
		this.postalCode=postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	
}
