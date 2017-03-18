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
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostConstruct
	public void init() {
		
		Restaurant r1 = new Restaurant("Telepizza", "Mostoles", "Telepizza@telepi.com", "918370511", "28999", "10:00", "23:00");
		r1.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, carne picada, bacon y barbacoa", 8.0));
		r1.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 8.50));
		r1.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon", 9.0));
		r1.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 8.0));
		r1.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 7.50));
		r1.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 9.0));
		r1.getProducts().add(new Product("pizza extravaganza", "deliciosa mezcla de pimiento, aceitunas y atún", 8.0));
		r1.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 9.50));		
		
		
		Restaurant r2 = new Restaurant("Dominos", "Mostoles", "dominosPizza@dominos.com", "91123111", "28989", "13:00", "24:00");
		r2.getProducts().add(new Product("pizza cremoza barbacoa", "mozarella con base de tomate, bacon y barbacoa con crema", 7.0));
		r2.getProducts().add(new Product("pizza tropical", "base de mozarella y tomate, bacon y piña", 7.50));
		r2.getProducts().add(new Product("pizza fundie", "mítica cuatro quesos junto a queso de cabra", 8.0));
		r2.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 7.0));
		r2.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 8.50));
		r2.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
		r2.getProducts().add(new Product("pizza bourbon", "deliciosa salsa de bourbon acompaña de bacon y pollo", 9.0));
		r2.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 8.50));		
	
		
		Restaurant r3 = new Restaurant("Pizza Hut", "Mostoles", "pizzaHut@hut.com", "91257651", "28969", "12:00", "23:50");
		r3.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, maiz bacon y barbacoa", 10.0));
		r3.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 9.50));
		r3.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon y maiz", 10.0));
		r3.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 9.0));
		r3.getProducts().add(new Product("pizza campiña", "refrescante combinación de verduras", 9.50));
		r3.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
		r3.getProducts().add(new Product("pizza hamburguer", "el sabor de una hamburguesa en una pizza", 9.0));
		r3.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 10.50));		
	
		
		Request req1 = new Request("Carlos", "Perez Gonzalez", "Calle Flores Nº 3 P 4º D", "91162111", "28999", 50.0);
		r1.getRequests().add(req1);
		requestRepository.save(req1);
	
		
		Request req7 = new Request("Susana", "Muñoz Martin", "Avenida Guadarrama Nº 21 P 2º B", "91162925", "28991", 43.0, true);
		r2.getRequests().add(req7);
		requestRepository.save(req7);
		
		Request req2 = new Request("Maria", "Hernandez Cabrera", "Calle Malta Nº21 8ºA", "91162451", "28989", 20.0);
		r1.getRequests().add(req2);
		requestRepository.save(req2);
		
	
		
		
		Request req3 = new Request("Teresa", "Garcia del Hoyo", "Avenida de Belgica Nº 2 Pº IZD", "96892111", "28699", 15.0);
		r2.getRequests().add(req3);
		requestRepository.save(req3);
		
		Request req4 = new Request("Pedro", "Gutierrez Pacheco", "Avenida de las cañas", "91758945", "28989", 70.0);
		r3.getRequests().add(req4);
		requestRepository.save(req4);
		
		Request req5 = new Request("Victor", "Blanco Ruiz", "Calle del puerro Nº 9 Pº 9D", "91153411", "28994", 35.0);
		r3.getRequests().add(req5);
		requestRepository.save(req5);
		
		Request req6 = new Request("Susana", "Muñoz Martin", "Avenida Guadarrama Nº 21 P 2º B", "91162925", "28991", 43.0, true);
		r3.getRequests().add(req6);
		requestRepository.save(req6);
		
		Person p1= new Person("Jorge", "Ratón Lázaro", "asd", "jorge_raton@gmail.com","Av Alemania Nº3 P8ºA","685746523", "28915");
		p1.getRequests().add(req1);
		p1.getRequests().add(req2);
		Person p2= new Person("Pablo", "Gutierrez Anton", "asd", "pablito@gmail.com","Av Polonia Nº8 P8º2","615946523", "28815");
		p2.getRequests().add(req3);
		p2.getRequests().add(req4);
		p2.getRequests().add(req5);
		p2.getRequests().add(req6);
		
		restaurantRepository.save(r1);
		restaurantRepository.save(r2);
		restaurantRepository.save(r3);
		
		personRepository.save(p1);
		personRepository.save(p2);
	}
	
	@RequestMapping("/restaurant")
	public String restaurantList(Model model){
		
		model.addAttribute("restaurants", restaurantRepository.findAll());
		
		return "restaurants";
	}
	
	
		
}
