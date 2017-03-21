package com.deliciousFood;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	RestaurantRepository restaurantRepository;

	@RequestMapping("/products/{id}")
	public String productList(Model model, @PathVariable String id, HttpServletRequest request) {
		Long idR = Long.parseLong(id);
		Restaurant r = restaurantRepository.findById(idR);
		model.addAttribute("products", r.getProducts());
		model.addAttribute("restaurant", r.getId());
		if (request.isUserInRole("ROLE_PERSON")) {
			return "products";
		} else if (request.isUserInRole("ROLE_RESTAURANT")) {
			return "editProducts";
		}
		return "login";
	}

	@RequestMapping("/products")
	public String productListRestaurant(Model model, @RequestParam(required=false) String[] nomProd, 
			@RequestParam(required=false) double[] price,@RequestParam(required=false) String[] description,
			HttpServletRequest request) {
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			Restaurant r = restaurantRepository.findByEmail(request.getUserPrincipal().getName());
			if(nomProd!=null){
				List<Product> products = new ArrayList<>();
				for(int i = 0; i<nomProd.length;i++){
					products.add(new Product(nomProd[i], description[i], price[i]));
				}
				r.setProducts(products);
				restaurantRepository.save(r);
			}
			model.addAttribute("products", r.getProducts());
			model.addAttribute("restaurant", r.getId());
			return "editProducts";
		} else {
			return "index";
		}
	}
}
