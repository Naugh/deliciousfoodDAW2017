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
	public String createUser(Model model, @RequestParam String userEmail, @RequestParam String password,
			@RequestParam String userType, @RequestParam String userName, @RequestParam String userSurname,
			@RequestParam String phone, @RequestParam String address, @RequestParam String postalCode,
			@RequestParam(required = false) String[] categories, @RequestParam MultipartFile image) throws IOException {

		if (userType.equals("person")) {
			Person u = new Person(userName, userSurname, password, userEmail, address, phone, postalCode);
			personRepository.save(u);
		} else {
			Map<String, String> cat = new HashMap<String, String>();
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					cat.put(categories[i].toUpperCase(), categories[i].toLowerCase());
				}
			}
			Restaurant r = new Restaurant(userName, password, userEmail, address, phone, postalCode, cat,
					new String(Base64.encodeBase64(image.getBytes())));
			restaurantRepository.save(r);
		}
		return "index";
	}

	@RequestMapping("/editUser")
	public String editUser(Model model, @RequestParam String userEmail, @RequestParam String password,
			@RequestParam String userName, @RequestParam(required = false) String userSurname,
			@RequestParam String phone, @RequestParam String address, @RequestParam String postalCode,
			@RequestParam(required = false) String[] categories, @RequestParam(required = false) MultipartFile image,
			HttpServletRequest request) throws IOException {

		if (request.isUserInRole("ROLE_RESTAURANT")) {
			Restaurant r = restaurantRepository.findByEmail(request.getUserPrincipal().getName());
			r.setPassword(password);
			r.setPhone(phone);
			r.setAddress(address);
			r.setPostalCode(postalCode);
			r.setName(userName);
			r.setEmail(userEmail);
			if (!image.isEmpty()) {
				r.setImage(new String(Base64.encodeBase64(image.getBytes())));
			}
			Map<String, String> cat = new HashMap<String, String>();
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					cat.put(categories[i].toUpperCase(), categories[i].toLowerCase());
				}
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

	@RequestMapping("/editProfile")
	public String editProfile(Model model, HttpServletRequest request) {
		if (request.isUserInRole("ROLE_RESTAURANT")) {
			Restaurant r = restaurantRepository.findByEmail(request.getUserPrincipal().getName());
			model.addAttribute("email", r.getEmail());
			model.addAttribute("password", r.getPassword());
			model.addAttribute("name", r.getName());
			model.addAttribute("phone", r.getPhone());
			model.addAttribute("address", r.getAddress());
			model.addAttribute("postalCode", r.getPostalCode());
			Map<String, String> categories = r.getCategories();
			model.addAttribute("categories0", categories.containsKey("PIZZA"));
			model.addAttribute("categories1", categories.containsKey("HAMBURGUESA"));
			model.addAttribute("categories2", categories.containsKey("JAPONESA"));
			model.addAttribute("categories3", categories.containsKey("ESPAÑOLA"));
			model.addAttribute("categories4", categories.containsKey("VEGETARIANA"));
			model.addAttribute("categories5", categories.containsKey("CHINA"));
			model.addAttribute("categories6", categories.containsKey("ITALIANA"));
			model.addAttribute("categories7", categories.containsKey("TURCA"));
			model.addAttribute("categories8", categories.containsKey("INDIA"));

		}
		if (request.isUserInRole("ROLE_PERSON")) {
			Person r = personRepository.findByEmail(request.getUserPrincipal().getName());
			model.addAttribute("email", r.getEmail());
			model.addAttribute("password", r.getPassword());
			model.addAttribute("name", r.getName());
			model.addAttribute("phone", r.getPhone());
			model.addAttribute("address", r.getAddress());
			model.addAttribute("postalCode", r.getPostalCode());
			model.addAttribute("surname", r.getSurnames());
		}
		;

		return "editProfile";
	}

	@RequestMapping("/loginUser")
	public String loginPage(HttpSession session) {

		return "login";
	}

}
