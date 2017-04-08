package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserComponent userComponent;

	public boolean isIdLogged(long id) {
		if (isLoggedUser()) {
			User user = userComponent.getLoggedUser();
			if (user instanceof Person) {
				return ((Person) user).getId() == id;
			}
			if (user instanceof Restaurant) {
				return ((Restaurant) user).getId() == id;
			}
		}
		return false;
	}
	
	public Person getPerson(){
		if (userComponent.isLoggedUser() && userComponent.getLoggedUser() instanceof Person){
			return (Person) userComponent.getLoggedUser();
		}
		return null;
	}
	
	public Restaurant getRestaurant(){
		if (userComponent.isLoggedUser() && userComponent.getLoggedUser() instanceof Restaurant){
			return (Restaurant) userComponent.getLoggedUser();
		}
		return null;
	}
	
	public boolean isLoggedUser(){
		return userComponent.isLoggedUser();
	}
}
