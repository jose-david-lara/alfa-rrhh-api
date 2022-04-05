package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class UserServices extends BaseSpringService<UserRepository>{

	public Map<String, Object> searchUserByEmail(Map<String, Object> request) throws Exception {
		/*return beginReadTransaction( new Transaction<Map<String, Object>> () {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().searchUserByEmails( this, request );	
			}
		});*/
		Map<String, Object> response = new HashMap<>();
		response.put("respuesta", "Exitoso!!!");
		return response;
	}


	public Map<String, Object> login(Map<String, Object> request) throws Exception {
		return beginReadTransaction( new Transaction<Map<String, Object>> () {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().login( this, request );
			}
		});
	}

}
