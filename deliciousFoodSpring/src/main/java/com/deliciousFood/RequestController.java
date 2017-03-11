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
		Restaurant r1 = new Restaurant("diCarlos", "Leganes", "diCarlos@algo.com", "911123111", "27999", "11:00", "23:00");
		r1.getRequests().add(o1);
		requestRepository.save(o1);
		restaurantRepository.save(r1);
	
	}
	

	@RequestMapping("/order")
	public String orderList(Model model){
		
		model.addAttribute("orders", requestRepository.findAll());
		
		return "order";
	}
}
