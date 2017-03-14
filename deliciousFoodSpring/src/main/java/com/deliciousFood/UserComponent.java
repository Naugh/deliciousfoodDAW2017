package com.deliciousFood;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserComponent {

	private Person person;
	private Restaurant restaurant;

	public Person getLoggedUser() {
		return person;
	}

	public void setLoggedUser(Person person) {
		this.person = person;
	}

	public boolean isLoggedUser() {
		return this.person != null;
	}

}
