package com.deliciousFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration. In this class can be configured several aspects
 * related to security:
 * <ul>
 * <li>Security behavior: Login method, session management, CSRF, etc..</li>
 * <li>Authentication provider: Responsible to authenticate users. In this
 * example, we use an instance of UserRepositoryAuthProvider, that authenticate
 * users stored in a Spring Data database.</li>
 * <li>URL Access Authorization: Access to http URLs depending on Authenticated
 * vs anonymous users and also based on user role.</li>
 * </ul>
 * 
 * NOTE: The only part of this class intended for app developer customization is
 * the method <code>configureUrlAuthorization</code>. App developer should
 * decide what URLs are accessible by what user role.
 */
@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthProvider userRepoAuthProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.antMatcher("/api/**");
		
		// Private pages (all other pages)		 
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/person/**").hasRole("PERSON");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/restaurant/**").hasRole("RESTAURANT");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/person/**").hasRole("PERSON");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/restaurant/**").hasRole("RESTAURANT");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/person/**").hasRole("PERSON");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/restaurant/**").hasRole("RESTAURANT");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/product").hasRole("RESTAURANT");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/product").hasRole("RESTAURANT");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/request").hasRole("PERSON");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/request/**").hasAnyRole("PERSON", "RESTAURANT");
		
		// Public pages
		http.authorizeRequests().anyRequest().permitAll();
		
		
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {});
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}