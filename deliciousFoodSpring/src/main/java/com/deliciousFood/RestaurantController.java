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
		restaurantRepository.save(r1);
	}
	
	@RequestMapping("/restaurant")
	public String restaurantList(Model model){
		
		model.addAttribute("restaurants", restaurantRepository.findAll());
		
		return "restaurants";
	}
	
	
		
}
