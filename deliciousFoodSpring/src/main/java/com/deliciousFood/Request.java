package com.deliciousFood;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String namePerson;
	private String nameRestaurant;
	private String surnames;
	private String address;
	private String phonePerson;
	private String phoneRestaurant;
	private String postal;
	private Double price;
	private Long idRestaurant;
	private boolean delivered=false;
	
	
	@OneToMany
	private List<Product> products = new ArrayList<>();
	
	
	public Request(){
		
	}

	public Request(String namePerson, String nameRestaurant, String surnames, String address, String phonePerson,
			String phoneRestaurant, String postal, Double price, List<Product> products) {
		super();
		this.namePerson = namePerson;
		this.nameRestaurant = nameRestaurant;
		this.surnames = surnames;
		this.address = address;
		this.phonePerson = phonePerson;
		this.phoneRestaurant = phoneRestaurant;
		this.postal = postal;
		this.price = price;
		this.products = products;
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


	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}
	

	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public boolean isDelivered() {
		return delivered;
	}



	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public String getNamePerson() {
		return namePerson;
	}



	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}



	public String getNameRestaurant() {
		return nameRestaurant;
	}



	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhonePerson() {
		return phonePerson;
	}



	public void setPhonePerson(String phonePerson) {
		this.phonePerson = phonePerson;
	}



	public String getPhoneRestaurant() {
		return phoneRestaurant;
	}



	public void setPhoneRestaurant(String phoneRestaurant) {
		this.phoneRestaurant = phoneRestaurant;
	}

	public Long getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

}
