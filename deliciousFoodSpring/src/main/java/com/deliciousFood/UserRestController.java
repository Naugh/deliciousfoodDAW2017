package com.deliciousFood;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	UserService userService;
	
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
	
	
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson() throws IOException {
		if (userService.isLoggedUser()) {
			return new ResponseEntity<>(userService.getPerson(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	

	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	 public ResponseEntity<Restaurant> getRestaurant() throws IOException{
		if (userService.isLoggedUser()) {
			return new ResponseEntity<>(userService.getRestaurant(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
	
	
	@RequestMapping(value = "/person", method = RequestMethod.DELETE)
	 public ResponseEntity<Person> deletePerson( HttpSession session) throws IOException {
		if (userService.isLoggedUser()){
				personRepository.delete(userService.getPerson());
				session.invalidate();
			return new ResponseEntity<>(userService.getPerson(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
	@RequestMapping(value = "/restaurant", method = RequestMethod.DELETE)
	 public ResponseEntity<Restaurant> deleteRestaurant (HttpSession session) throws IOException {
		if (userService.isLoggedUser()){
				restaurantRepository.delete(userService.getRestaurant());
				session.invalidate();
			return new ResponseEntity<>(userService.getRestaurant(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	 public ResponseEntity<Person> setPerson(@RequestBody Person person) {
		if (userService.isLoggedUser()){
			personRepository.save(person);		
			return new ResponseEntity<>(userService.getPerson(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
	@RequestMapping(value = "/restaurant", method = RequestMethod.PUT)
	public ResponseEntity<Restaurant> setPerson(@RequestBody Restaurant restaurant) {
		if (userService.isLoggedUser()){
			restaurantRepository.save(restaurant);		
			return new ResponseEntity<>(userService.getRestaurant(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
	
	
	
	
}
