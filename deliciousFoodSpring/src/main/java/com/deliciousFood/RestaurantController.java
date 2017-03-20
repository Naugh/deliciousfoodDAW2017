package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	@RequestMapping("/restaurant")
	public String restaurantList(Model model){
		
		model.addAttribute("restaurants", restaurantRepository.findAll());
		
		return "restaurants";
	}
	
	
		
}
