package com.deliciousFood;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@RequestMapping("/user")
	public String createUser(Model model, @RequestParam String userEmail,
			@RequestParam String password, @RequestParam String userType, 
			@RequestParam String userName, @RequestParam String userSurname,
			@RequestParam String phone, @RequestParam String address, 
			@RequestParam String postalCode, @RequestParam String[] categories,
			@RequestParam MultipartFile image) throws IOException{
		
		if(userType.equals("user")){
			System.out.println("persona");
			User u= new User(userName, password, userSurname, address, userEmail, phone, postalCode);
			userRepository.save(u);
		}else{
			System.out.println("restaurante");
			Restaurant r = new Restaurant(userName,address,userEmail,phone,postalCode,new String(Base64.encodeBase64(image.getBytes())));
			restaurantRepository.save(r);
		}
		return "index";
	}
}
