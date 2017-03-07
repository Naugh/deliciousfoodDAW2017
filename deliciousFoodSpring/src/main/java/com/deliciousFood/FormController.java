package com.deliciousFood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping("/form")
	public String restaurantList(Model model) {
		return "form";
	}
}
