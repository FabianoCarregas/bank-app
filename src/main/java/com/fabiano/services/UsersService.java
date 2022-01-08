package com.fabiano.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fabiano.security.UserSS;

public class UsersService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
