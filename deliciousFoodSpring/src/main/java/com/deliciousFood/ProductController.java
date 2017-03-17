package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;


//  LO QUE VE EL USUARIO
	@RequestMapping("/products/{id}")
	public String productList(Model model,@PathVariable String id){
		Long idR = Long.parseLong(id);
		Restaurant r = restaurantRepository.findById(idR);
		model.addAttribute("products", r.getProducts());
		model.addAttribute("restaurant", r.getId());
		return "products";
	}

	
/*  LO QUE VE EL RESTAURANTE
    @RequestMapping("/products/{id}")
	public String productList(Model model,@PathVariable String id){
	Long idR = Long.parseLong(id);
	Restaurant r = restaurantRepository.findById(idR);
	model.addAttribute("products", r.getProducts());
	model.addAttribute("restaurant", r.getId());
	return "editProducts";
} */
}

