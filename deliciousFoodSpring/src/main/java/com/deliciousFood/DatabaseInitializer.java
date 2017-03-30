package com.deliciousFood;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

	final String imgTest = "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";
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void init() {

		Restaurant r1 = new Restaurant("Telepizza","asd","telepizza@telepizza.com", "Mostoles",  "918370511", "28999", null, imgTest);
		r1.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, carne picada, bacon y barbacoa", 8.0));
		r1.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 8.50));
		r1.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon", 9.0));
		r1.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 8.0));
		r1.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 7.50));
		r1.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 9.0));
		r1.getProducts().add(new Product("pizza extravaganza", "deliciosa mezcla de pimiento, aceitunas y atún", 8.0));
		r1.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 9.50));

		Restaurant r2 = new Restaurant("Dominos","asd",  "dominosPizza@dominos.com","Mostoles", "91123111", "28989", null, imgTest);
		r2.getProducts().add(new Product("pizza cremoza barbacoa", "mozarella con base de tomate, bacon y barbacoa con crema", 7.0));
		r2.getProducts().add(new Product("pizza tropical", "base de mozarella y tomate, bacon y piña", 7.50));
		r2.getProducts().add(new Product("pizza fundie", "mítica cuatro quesos junto a queso de cabra", 8.0));
		r2.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 7.0));
		r2.getProducts().add(new Product("pizza peperoni", "mozarella y tomate junto a una sorpresa picante", 8.50));
		r2.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
		r2.getProducts().add(new Product("pizza bourbon", "deliciosa salsa de bourbon acompaña de bacon y pollo", 9.0));
		r2.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 8.50));
		
		for(int i = 0; i<45;i++){
			Restaurant r3 = new Restaurant("Pizza Hut","asd", "pizzahut@pizzahut.com", "Mostoles", "91257651", "28969", null, imgTest);
			r3.getProducts().add(new Product("pizza barbacoa", "mozarella con base de tomate, maiz bacon y barbacoa", 10.0));
			r3.getProducts().add(new Product("pizza carbonara", "crema con champiñones, bacon y salsa carbonara", 9.50));
			r3.getProducts().add(new Product("pizza tejana", "característica cebolla con jamon y maiz", 10.0));
			r3.getProducts().add(new Product("pizza cuatro quesos", "deliciosa mezcla de quesos", 9.0));
			r3.getProducts().add(new Product("pizza campiña", "refrescante combinación de verduras", 9.50));
			r3.getProducts().add(new Product("pizza pecado carnal", "deliciosa combinacíon de carne", 10.0));
			r3.getProducts().add(new Product("pizza hamburguer", "el sabor de una hamburguesa en una pizza", 9.0));
			r3.getProducts().add(new Product("pizza ibérica", "pizza abundante de tomate y jamón", 10.50));
			Request req4 = new Request("Pedro", "Gutierrez Pacheco", "Avenida de las cañas", "91758945", "28989", 70.0);
			r3.getRequests().add(req4);
			requestRepository.save(req4);
	
			Request req5 = new Request("Victor", "Blanco Ruiz", "Calle del puerro Nº 9 Pº 9D", "91153411", "28994", 35.0);
			r3.getRequests().add(req5);
			requestRepository.save(req5);
	
			Request req6 = new Request("Susana", "Muñoz Martin", "Avenida Guadarrama Nº 21 P 2º B", "91162925", "28991", 43.0, true);
			r3.getRequests().add(req6);
			requestRepository.save(req6);
			restaurantRepository.save(r3);
		}
		Request req1 = new Request("Carlos", "Perez Gonzalez", "Calle Flores Nº 3 P 4º D", "91162111", "28999", 50.0);
		r1.getRequests().add(req1);
		requestRepository.save(req1);

		Request req7 = new Request("Susana", "Muñoz Martin", "Avenida Guadarrama Nº 21 P 2º B", "91162925", "28991",
				43.0, true);
		r2.getRequests().add(req7);
		requestRepository.save(req7);

		Request req2 = new Request("Maria", "Hernandez Cabrera", "Calle Malta Nº21 8ºA", "91162451", "28989", 20.0);
		r1.getRequests().add(req2);
		requestRepository.save(req2);

		Request req3 = new Request("Teresa", "Garcia del Hoyo", "Avenida de Belgica Nº 2 Pº IZD", "96892111", "28699",
				15.0);
		r2.getRequests().add(req3);
		requestRepository.save(req3);

		

		Person p1 = new Person("Jorge", "Ratón Lázaro", "asd", "jorge_raton@gmail.com", "Av Alemania Nº3 P8ºA", "685746523", "28915");
		p1.getRequests().add(req1);
		p1.getRequests().add(req2);
		Person p2 = new Person("Pablo", "Gutierrez Anton", "asd", "pablito@gmail.com", "Av Polonia Nº8 P8º2","615946523", "28815");
		p2.getRequests().add(req3);

		restaurantRepository.save(r1);
		restaurantRepository.save(r2);

		personRepository.save(p1);
		personRepository.save(p2);
	}
}
