package com.deliciousFood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@RequestMapping("/restaurant")
	public String restaurantList(Model model){
		return "restaurants.html";
	}
	
	
		
}
