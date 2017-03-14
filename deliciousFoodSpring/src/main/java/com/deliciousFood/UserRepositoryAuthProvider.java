package com.deliciousFood;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAuthProvider implements AuthenticationProvider{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		boolean isUser=true;
		List<String>role;
		
		String pass;

		Person person = personRepository.findByName(username);
		Restaurant restaurant = restaurantRepository.findByName(username);

		if (person == null) {
			if(restaurant == null){
				throw new BadCredentialsException("User not found");
			}else{
				pass=restaurant.getPassword();
				role=restaurant.getRoles();
				isUser=false;
			}
		}else{
			pass=person.getPassword();
			role=person.getRoles();
		}
		
		if (!password.equals(pass)) {
			throw new BadCredentialsException("Wrong password");
		}else{
			if(isUser){
				userComponent.setLoggedUser(person);
			}else{
				userComponent.setLoggedUser(restaurant);
			}
			
			
			List<GrantedAuthority> roleAuth = new ArrayList<>();
			roleAuth.add(new SimpleGrantedAuthority(role.get(0)));

			return new UsernamePasswordAuthenticationToken(username, password,roleAuth);
		}
		
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}
