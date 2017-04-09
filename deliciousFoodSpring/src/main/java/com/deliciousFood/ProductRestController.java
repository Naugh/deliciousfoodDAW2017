package com.deliciousFood;

import java.util.ArrayList;
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
@RequestMapping("/api")
public class ProductRestController {

	

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	RestaurantRepository productRepository;

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(@PathVariable long id){
		
		Restaurant r = restaurantRepository.findById(id);
		if (r != null) {			
			return new ResponseEntity<>(r.getProducts(), HttpStatus.OK);
		
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	 public Product addProduct(@RequestBody Product product) {
		
		if (userService.isLoggedUser()){
			productRepository.save(product);
			Restaurant r = userService.getRestaurant();
			r.getProducts().add(product);
			restaurantRepository.save(r);
			}
		
		return product;
	}
	
}
