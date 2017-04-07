package com.deliciousFood;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

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
	
	
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Person> getPerson(@PathVariable long id, HttpServletRequest request) throws IOException {

		if (request.isUserInRole("ROLE_PERSON")) {
			
			Person p = personRepository.findById(id);
			if (p != null){
				return new ResponseEntity<>(p, HttpStatus.OK);
			}
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Restaurant> getRestaurant(@PathVariable long id, HttpServletRequest request) throws IOException{
		
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			
			Restaurant r = restaurantRepository.findById(id);
			if (r != null){
				return new ResponseEntity<>(r, HttpStatus.OK);
			}
		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Person> deletePerson(@PathVariable long id, HttpServletRequest request) throws IOException {

		if (request.isUserInRole("ROLE_PERSON")) {
			
			Person p = personRepository.findById(id);
			if (p != null){
				
				personRepository.delete(p);
				return new ResponseEntity<>(p, HttpStatus.OK);
			}
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable long id, HttpServletRequest request) throws IOException{
		
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			
			Restaurant r = restaurantRepository.findById(id);
			if (r != null){
				
				restaurantRepository.delete(r);
				return new ResponseEntity<>(r, HttpStatus.OK);
			}
		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
}
