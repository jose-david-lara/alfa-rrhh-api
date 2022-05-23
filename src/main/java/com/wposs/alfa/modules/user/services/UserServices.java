package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class UserServices extends UserRepository{
	
	

	public ResponseModel searchUserByEmail(Map<String, Object> request) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<>();
		response.put("respuesta", "Exitoso!!!");
		rspModel.setData(response);
		return rspModel;
	}
	
}
