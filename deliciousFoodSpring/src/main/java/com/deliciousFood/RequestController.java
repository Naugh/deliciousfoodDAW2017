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
public class RequestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RequestRepository requestRepository;

	@RequestMapping("/request/{id}")
	public String requestList(Model model, @PathVariable String id, @RequestParam String[] amounts,
			@RequestParam String[] products, @RequestParam String total, HttpServletRequest request) {
		List<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < products.length; i++) {
			Product p = productRepository.findById(Long.parseLong(products[i]));
			p.setAmount(Integer.parseInt(amounts[i]));
			productList.add(p);
		}
		
		Person p = personRepository.findByEmail(request.getUserPrincipal().getName());
		model.addAttribute("person",p);
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
				}
				restaurantRepository.save(r);
			}
			model.addAttribute("requests", r.getRequests());
			model.addAttribute("restaurant", r.getId());
			return "listRequest";
			
		} else if (request.isUserInRole("ROLE_PERSON")) {

			Person p = personRepository.findByEmail(request.getUserPrincipal().getName());
							
			model.addAttribute("requests",p.getRequests());
			
			return "listRequestU"; 
		} 
		
		return null;
	}

	
	@RequestMapping("/request")
	public String endRequest (Model model, @RequestParam String name,@RequestParam String surname,
			@RequestParam String phone,@RequestParam String address, @RequestParam String postal,
			@RequestParam double total, @RequestParam int[] amounts, @RequestParam long restaurant, HttpServletRequest request, @RequestParam long[] products){
		Person p = personRepository.findByEmail(request.getUserPrincipal().getName());
		Restaurant re = restaurantRepository.findById(restaurant);
		
		
		List<Product> prod = new ArrayList<Product>();
		for(int i = 0; i<products.length;i++){
			Product product = productRepository.findById(products[i]);
			product.setAmount(amounts[i]);
			prod.add(product);
		}

		Request r = new Request(name,re.getName(),surname, address, phone, re.getPhone(), postal, total, prod);
	
		p.getRequests().add(r);
		re.getRequests().add(r);
		
		requestRepository.save(r);
		restaurantRepository.save(re);
		personRepository.save(p);
		return "requestEnd";
	}
	
	@RequestMapping("/requests/products")
	public String productDetail (Model model, @RequestParam long selectedRequest){
		
			Request req = requestRepository.findById(selectedRequest);
			model.addAttribute("products", req.getProducts());
			model.addAttribute("total", req.getPrice());
		    
		    return "productDetail";
	}
}
