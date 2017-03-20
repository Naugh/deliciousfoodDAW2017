package com.deliciousFood;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.h2.mvstore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	PersonRepository personRepository;

	@RequestMapping("/request/{id}")
	public String requestList(Model model, @PathVariable String id, @RequestParam String[] amounts,
			@RequestParam String[] products, @RequestParam String total) {
		List<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < products.length; i++) {
			Product p = productRepository.findById(Long.parseLong(products[i]));
			p.setAmount(Integer.parseInt(amounts[i]));
			productList.add(p);
		}
		model.addAttribute("restaurant", id);
		model.addAttribute("products", productList);
		model.addAttribute("total", total);
		return "request";
	}

	@RequestMapping("/requests")
	public String requestList(Model model, @RequestParam(required = false) boolean[] delivered,
			HttpServletRequest request) {
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			Restaurant r = restaurantRepository.findByEmail(request.getUserPrincipal().getName());
			if (delivered != null) {
				for (int i = 0; i < r.getRequests().size(); i++) {
					r.getRequests().get(i).setDelivered(delivered[i]);
					restaurantRepository.save(r);
				}
			}
			model.addAttribute("requests", r.getRequests());
			model.addAttribute("restaurant", r.getId());
		} else if (request.isUserInRole("ROLE_PERSON")) {
			Person p = personRepository.findByEmail(request.getUserPrincipal().getName());
			model.addAttribute("requests",p.getRequests());
		}
		return "listRequest";

	}

	
	@RequestMapping("/requestEnd")
	public String ending (Model model){
		
		return "requestEnd";
	}
}
