package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantRestController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	@RequestMapping(value = "/restaurant/", method = RequestMethod.GET)
	public Page<Restaurant> restaurantList(Pageable page){
		
		Page<Restaurant> result = restaurantRepository.findAll(page);
		
		return result;
		
	}
	
	
		
}
