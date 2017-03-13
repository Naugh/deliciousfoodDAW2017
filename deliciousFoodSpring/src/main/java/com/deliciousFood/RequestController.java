package com.deliciousFood;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	private RequestRepository requestRepository;
	
	
	@PostConstruct
	public void init() {

	}
	

	@RequestMapping("/request/{id}")
	public String orderList(Model model, @PathVariable String id, 
			@RequestParam String[] amounts, @RequestParam String[] products,
			@RequestParam String total){
		System.out.println(products[0]);
		List<Product> productList= new ArrayList<Product>();
		for(int i = 0; i<products.length;i++){
			Product p = productRepository.findById(Long.parseLong(products[i]));
			p.setAmount(Integer.parseInt(amounts[i]));
			productList.add(p);
		}
		model.addAttribute("restaurant",id);
		model.addAttribute("products", productList);
		model.addAttribute("total",total);
		return "request";
	}
	@RequestMapping("/requests")
	public String orderList(Model model){
		
		model.addAttribute("requests", requestRepository.findAll());
		
		return "listRequest";
	}
	
	
}
