package com.deliciousFood;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product {

	@JsonView(Show.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	interface Show{};
	
	@JsonView(Show.class)
	private String name;
	
	@JsonView(Show.class)
	private String description;
	
	@JsonView(Show.class)
	private Double price;
	private Integer amount;
	
	
	public Product() {
	}


	public Product(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public boolean equals(Product product){
		return product.getName().equals(this.getName()) &&
				product.getDescription().equals(this.getDescription()) &&
				product.getPrice() == this.getPrice();
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
