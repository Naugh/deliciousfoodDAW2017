package com.deliciousFood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor extends HandlerInterceptorAdapter{
	
	
    	
	@Override
    public void postHandle(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler,
            final ModelAndView modelAndView) throws Exception {

		boolean isPerson = request.isUserInRole("ROLE_PERSON");
		boolean isRestaurant = request.isUserInRole("ROLE_RESTAURANT");
        if (modelAndView != null) {
        	modelAndView.getModelMap().addAttribute("isPerson", isPerson);
            modelAndView.getModelMap().addAttribute("isRestaurant", isRestaurant);
        //    CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        //    modelAndView.addObject("token", token.getToken()); 
        }
    }
}
