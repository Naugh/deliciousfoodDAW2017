package com.deliciousFood;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@PostConstruct
	public void init() {
		
		Request o1 = new Request("Carlos", "Perez Gonzalez", "Calle Flores Nº 3 P 4º D", "91162111", "28999", 50.0);
		Restaurant r1 = new Restaurant("Telepizza", "Mostoles", "algo@algo.com", "911111111", "28999", "10:00", "23:00");
		r1.getRequests().add(o1);
		requestRepository.save(o1);
	
		
		Request o2 = new Request("Maria", "Hernandez Cabrera", "Calle Malta Nº21 8ºA", "91162451", "28989", 20.0);
		r1.getRequests().add(o2);
		requestRepository.save(o2);
		
		
		Request o3 = new Request("Teresa", "Garcia del Hoyo", "Avenida de Belgica Nº 2 Pº IZD", "96892111", "28699", 15.0);
		Restaurant r2 = new Restaurant("Dominos", "Mostoles", "algo@algo.com", "91123111", "28989", "13:00", "24:00");
		r2.getRequests().add(o3);
		requestRepository.save(o3);
		
		Request o4 = new Request("Pedro", "Gutierrez Pacheco", "Avenida de las cañas", "91758945", "28989", 70.0);
		Restaurant r3 = new Restaurant("Pizza Hut", "Mostoles", "algo@algo.com", "91257651", "28969", "12:00", "23:50");
		r3.getRequests().add(o4);
		requestRepository.save(o4);
		
		Request o5 = new Request("Victor", "Blanco Ruiz", "Calle del puerro Nº 9 Pº 9D", "91153411", "28994", 35.0);
		r3.getRequests().add(o5);
		requestRepository.save(o5);
		
		Request o6 = new Request("Susana", "Muñoz Martin", "Avenida Guadarrama Nº 21 P 2º B", "91162925", "28991", 43.0);
		r3.getRequests().add(o6);
		requestRepository.save(o6);
		
		
		restaurantRepository.save(r1);
		restaurantRepository.save(r2);
		restaurantRepository.save(r3);
		
	
	}
	

	@RequestMapping("/order")
	public String orderList(Model model){
		
		model.addAttribute("orders", requestRepository.findAll());
		
		return "order";
	}
}
