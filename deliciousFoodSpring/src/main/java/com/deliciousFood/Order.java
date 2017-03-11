package com.deliciousFood;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String surnames;
	private String adress;
	private String phone;
	private String postal;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Restaurant restaurant;
	
	
	public Order(){
		
	}



	public Order(String name, String surnames, String adress, String phone, String postal) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.adress = adress;
		this.phone = phone;
		this.postal = postal;
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



	public String getSurnames() {
		return surnames;
	}



	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	

}
