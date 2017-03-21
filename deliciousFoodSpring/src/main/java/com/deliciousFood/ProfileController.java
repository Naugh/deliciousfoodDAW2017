package com.deliciousFood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

	@RequestMapping("/editProfile")
	public String editProfile(Model model) {
		
		return "editProfile";
	}
}
