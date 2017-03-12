package com.deliciousFood;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {
	
	@Autowired
	private RequestRepository requestRepository;
	
	
	@PostConstruct
	public void init() {
		
			
	
	}
	

	@RequestMapping("/request")
	public String orderList(Model model){
		
		model.addAttribute("requests", requestRepository.findAll());
		
		return "request";
	}
}
