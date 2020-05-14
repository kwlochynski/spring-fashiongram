package com.wlochynski.fashiongram.utilites;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilites {

	public static String getLoggedUser() {
		String userEmail = null;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken))
		{
			userEmail = auth.getName();
		}
		return userEmail;
	}
	
}