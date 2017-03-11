package com.deliciousFood;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostConstruct
	public void init() {
		Order o1 = new Order("Carlos", "Perez Gonzalez", "Calle Flores Nº 3 P 4º D", "91162111", "28999");
		o1.setRestaurant(new Restaurant("diCarlos", "Leganes", "diCarlos@algo.com", "911123111", "27999", "11:00", "23:00"));
		orderRepository.save(o1);
	}
	

	@RequestMapping("/order")
	public String orderList(Model model){
		
		model.addAttribute("orders", orderRepository.findAll());
		
		return "order";
	}
}
