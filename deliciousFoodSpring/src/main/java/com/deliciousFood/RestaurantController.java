package com.deliciousFood;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@PostConstruct
	public void init() {
		Restaurant r1 = new Restaurant("Telepizza", "Mostoles", "algo@algo.com", "911111111", "28999", "10:00", "23:00");
//		r1.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, carne picada, bacon y barbacoa", 8.0));
//		r1.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 8.50));
//		r1.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon", 9.0));
//		r1.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 8.0));
//		r1.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 7.50));
//		r1.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 9.0));
//		r1.getProducts().add(new Product("pizza extravaganza", "deliciosa mezcla de pimiento, aceitunas y atún", 8.0));
//		r1.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 9.50));		
		restaurantRepository.save(r1);
		/*
		Restaurant r2 = new Restaurant("Dominos", "Mostoles", "algo@algo.com", "91123111", "28989", "13:00", "24:00");
		r2.getProducts().add(new Product("pizza cremoza barbacoa", "mozarella con base de tomate, bacon y barbacoa con crema", 7.0));
		r2.getProducts().add(new Product("pizza tropical", "base de mozarella y tomate, bacon y piña", 7.50));
		r2.getProducts().add(new Product("pizza fundie", "mítica cuatro quesos junto a queso de cabra", 8.0));
		r2.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 7.0));
		r2.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 8.50));
		r2.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
		r2.getProducts().add(new Product("pizza bourbon", "deliciosa salsa de bourbon acompaña de bacon y pollo", 9.0));
		r2.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 8.50));		
		restaurantRepository.save(r2);
		
		Restaurant r3 = new Restaurant("Pizza Hut", "Mostoles", "algo@algo.com", "91257651", "28969", "12:00", "23:50");
		r3.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, maiz bacon y barbacoa", 10.0));
		r3.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 9.50));
		r3.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon y maiz", 10.0));
		r3.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 9.0));
		r3.getProducts().add(new Product("pizza campiña", "refrescante combinación de verduras", 9.50));
		r3.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
		r3.getProducts().add(new Product("pizza hamburguer", "el sabor de una hamburguesa en una pizza", 9.0));
		r3.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 10.50));		
		restaurantRepository.save(r3);*/
	}
	
	@RequestMapping("/restaurant")
	public String restaurantList(Model model){
		
		model.addAttribute("restaurants", restaurantRepository.findAll());
		
		return "restaurants";
	}
	
	
		
}
