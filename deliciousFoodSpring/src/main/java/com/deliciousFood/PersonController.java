package com.deliciousFood;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
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
			Person u= new Person(userName, password, userSurname, address, userEmail, phone, postalCode);
			personRepository.save(u);
		}else{
			System.out.println("restaurante");
			Map<String, String> cat = new HashMap<String, String>();
			for(int i= 0; i<categories.length;i++){
				cat.put(categories[i].toUpperCase(), categories[i].toLowerCase());
			}
			Restaurant r = new Restaurant(userName,password,address,userEmail,phone,postalCode,cat,new String(Base64.encodeBase64(image.getBytes())));
			restaurantRepository.save(r);
		}
		return "index";
	}
}
