package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	 public Person addPerson(@RequestBody Person person) {
		
		
		personRepository.save(person);

		
		return person;
	}
	
	
	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	 public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {

		restaurantRepository.save(restaurant);
		
		return restaurant;
	}
}
