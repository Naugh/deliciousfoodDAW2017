package com.deliciousFood;

import java.util.List;

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
@RequestMapping("/api/request")
public class RequestRestController {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	 public Request addRequest(@RequestBody Request request) {
		
		Restaurant r = restaurantRepository.findById(request.getIdRestaurant());
		
		List<Product> products = request.getProducts();
		
		for(int i = 0; i < products.size(); i++){
			Product p = productRepository.findById(products.get(i).getId());
			p.setAmount(products.get(i).getAmount());
			products.set(i, p);
		}
		
		request.setProducts(products);
		request.setNameRestaurant(r.getName());
		request.setPhoneRestaurant(r.getPhone());
		
		requestRepository.save(request);
		r.getRequests().add(request);
		Person p = personRepository.findById(userService.getPerson().getId());
		p.getRequests().add(request);
		restaurantRepository.save(r);
		personRepository.save(p);
		return request;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Request> getRequest(@PathVariable long id) {
		Request req = requestRepository.findById(id);
		if (req != null) {	
			if (userService.getPerson() != null) {
				Person person = personRepository.findById(userService.getPerson().getId());
				if (person.hasRequest(req.getId())) {
					return new ResponseEntity<>(req, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				}
			}else {
				Restaurant restaurant = restaurantRepository.findById(userService.getRestaurant().getId());
				if (restaurant.hasRequest(req.getId())) {
					return new ResponseEntity<>(req, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.FORBIDDEN);
				}
			}
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
		
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getRequests() {
			if (userService.getPerson() != null) {
				Person person = personRepository.findById(userService.getPerson().getId());
				return new ResponseEntity<>(person.getRequests(), HttpStatus.OK);
			}else {
				Restaurant restaurant = restaurantRepository.findById(userService.getRestaurant().getId());
				return new ResponseEntity<>(restaurant.getRequests(), HttpStatus.OK);
			}
		} 
}
