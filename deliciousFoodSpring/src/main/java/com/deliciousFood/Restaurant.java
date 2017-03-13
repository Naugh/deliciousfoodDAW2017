package com.deliciousFood;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Value;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String address;
	private String email;
	private String phone;
	private String postalCode;
	private String opening;
	private String closing;
	
	@ElementCollection
	Map<String, String> categories;
	
	
	@Lob
	@Column(length=20000)
	private String image;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	
	@OneToMany
	private List<Request> requests = new ArrayList<>();
	

	public Restaurant() {
	}

	public Restaurant(String name, String address, String email, String phone, String postalCode,Map<String, String>  categories, String image) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.postalCode = postalCode;
		this.categories=categories;
		this.image=image;
	}
	
	public Restaurant(String name, String address, String email, String phone, String postalCode,
			String opening, String closing) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.postalCode = postalCode;
		this.opening = opening;
		this.closing = closing;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getOpening() {
		return opening;
	}

	public void setOpening(String opening) {
		this.opening = opening;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, String>  getCategories() {
		return categories;
	}

	public void setCategories(Map<String, String>  categories) {
		this.categories = categories;
	}
	
	
	
}
