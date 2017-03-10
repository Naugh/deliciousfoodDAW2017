package com.deliciousFood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/product")
	public String productList(Model model){
		return "products";
	}
	
}
