package com.deliciousFood;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String surnames;
	private String address;
	private String phone;
	private String postal;
	private Double price;
	
	@ManyToOne
	Restaurant restaurant;
	
	public Request(){
		
	}



	public Request(String name, String surnames, String adress, String phone, String postal,Double price) {
		this.name = name;
		this.surnames = surnames;
		this.address = adress;
		this.phone = phone;
		this.postal = postal;
		this.setPrice(price);
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
		return address;
	}



	public void setAdress(String adress) {
		this.address = adress;
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
	

	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}
	

}
