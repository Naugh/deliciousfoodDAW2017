package com.deliciousFood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Restaurant extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String opening;
	private String closing;
	
	@ElementCollection
	Map<String, String> categories;
	
	
	@Lob
	@Column(length=20000)
	private String image="";
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	
	@OneToMany
	private List<Request> requests = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>(Arrays.asList("RESTAURANT"));;
	

	public Restaurant() {
	}


	public Restaurant(String name, String password, String email, String address, String phone, String postalCode,Map<String, String> categories, String image) {
		super(name, password, email, address, phone, postalCode);
		this.image=image;
		this.categories=categories;
	}


	public Restaurant(String name, String address, String email, String phone, String postalCode, String opening, String closing) {
		super(name,address,email,phone,postalCode);
		this.opening=opening;
		this.closing=closing;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public Map<String, String> getCategories() {
		return categories;
	}


	public void setCategories(Map<String, String> categories) {
		this.categories = categories;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
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


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	

	
}