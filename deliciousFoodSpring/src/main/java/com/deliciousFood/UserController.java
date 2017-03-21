package com.deliciousFood;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	PersonRepository personRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
		
	@RequestMapping("/user")
	public String createUser(Model model, @RequestParam String userEmail,
			@RequestParam String password, @RequestParam String userType, 
			@RequestParam String userName, @RequestParam String userSurname,
			@RequestParam String phone, @RequestParam String address, 
			@RequestParam String postalCode, @RequestParam (required = false) String[] categories,
			@RequestParam MultipartFile image) throws IOException{
		
		if(userType.equals("user")){
			Person u= new Person(userName, userSurname, password, userEmail, address, phone, postalCode);
			personRepository.save(u);
		}else{
			Map<String, String> cat = new HashMap<String, String>();
			for(int i= 0; i<categories.length;i++){
				cat.put(categories[i].toUpperCase(), categories[i].toLowerCase());
			}
			Restaurant r = new Restaurant(userName,password, userEmail, address,phone,postalCode,cat,new String(Base64.encodeBase64(image.getBytes())));
			restaurantRepository.save(r);
		}
		return "index";
	}
	
	@RequestMapping("/editUser")
	public String editUser(Model model, @RequestParam String userEmail,
			@RequestParam String password, 
			@RequestParam String userName, @RequestParam String userSurname,
			@RequestParam String phone, @RequestParam String address, 
			@RequestParam String postalCode, @RequestParam (required = false) String[] categories,
			@RequestParam (required = false) MultipartFile image, HttpServletRequest request) throws IOException{
		
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			Restaurant r = restaurantRepository.findByEmail(request.getUserPrincipal().getName());
			r.setPassword(password);
			r.setPhone(phone);
			r.setAddress(address);
			r.setPostalCode(postalCode);
			r.setName(userName);
			r.setEmail(userEmail);
			r.setImage(new String(Base64.encodeBase64(image.getBytes())));
			Map<String, String> cat = new HashMap<String, String>();
			for(int i= 0; i<categories.length;i++){
				cat.put(categories[i].toUpperCase(), categories[i].toLowerCase());
			}
			r.setCategories(cat);
			
			restaurantRepository.save(r);
		
		}
		
		else if (request.isUserInRole("ROLE_PERSON")) {
			Person p = personRepository.findByEmail(request.getUserPrincipal().getName());
			p.setAddress(address);
			p.setName(userName);
			p.setSurnames(userSurname);
			p.setPassword(password);
			p.setPhone(phone);
			p.setPostalCode(postalCode);
			p.setEmail(userEmail);
			
			personRepository.save(p);
		}
			
		
		
		return "index";
	}
	
	
	@RequestMapping("/loginUser")
	public String loginPage(HttpSession session) {

		return "login";
	}
	
}
