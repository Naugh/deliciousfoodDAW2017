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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	@ElementCollection
	Map<String, String> categories;
	
	@ElementCollection
	List<String> categoryList;
	
	
	@Lob
	@Column(length=20000)
	private String image="";
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Product> products = new ArrayList<>();
	
	@OneToMany
	@JsonIgnore
	private List<Request> requests = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<String> roles = new ArrayList<>(Arrays.asList("ROLE_RESTAURANT"));;
	

	public Restaurant() {
	}


	public Restaurant(String name, String password, String email, String address, String phone, String postalCode,Map<String, String> categories, String image) {
		super(name, password, email, address, phone, postalCode);
		this.image=image;
		this.categories=categories;
	}

	public Product getProductById(long id){
		for(int i = 0; i<this.products.size();i++){
			if(products.get(i).getId()==id){
				return products.get(i);
			}
		}
		return null;
	}
	
	public boolean hasRequest(Long id){
		for(int i = 0; i < requests.size(); i++){
			if(requests.get(i).getId()==id){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasProductById(long id){
		for(int i = 0; i < this.products.size(); i++){
			if(products.get(i).getId()==id){
				return true;
			}
		}
		return false;
	}
	
	public void setProductById(long id, Product product){
		for(int i = 0; i < this.products.size(); i++){
			if(products.get(i).getId()==id){
				products.set(i, product);
				break;
			}
		}
	}
		
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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