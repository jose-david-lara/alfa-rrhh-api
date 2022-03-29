package com.wposs.alfa.utilities;

import org.springframework.beans.factory.annotation.Autowired;

import com.wposs.alfa.modules.user.services.UserServices;

public class BaseServices {


	@Autowired
	private UserServices userService;

	public UserServices getUserService() {
		return userService;
	}

	public void setUserService(UserServices userService) {
		this.userService = userService;
	}
	
	
	
}
