package com.wposs.alfa.config;

import org.springframework.stereotype.Component;

import com.wposs.core.model.BaseUser;

@Component
public class AlfaRrhhSecurityManager extends SecurityManager {
	
	public boolean isMainPage(String context, String uri, BaseUser user) {
		if(user != null) {
			if(uri.endsWith("findList")) {
				return true;
			}
		}
		return false;
	}

}
