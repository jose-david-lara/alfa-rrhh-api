package com.wposs.alfa.modules.user.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.dto.LoginInput;
import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class UserServices extends UserRepository{
	
	private ResponseModel rspModel;

	public ResponseModel searchUserByEmail(Map<String, Object> request) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<>();
		response.put("respuesta", "Exitoso!!!");
		rspModel.setData(response);
		return rspModel;
	}

	public ResponseModel loginService(LoginInput loginInput) throws Exception {
		rspModel = new ResponseModel();
		Map<String, Object> mapResponse = loginRepository(loginInput);
		String response = (String) mapResponse.get("response");
		if( response.equals("Login exitoso") ) {
			Map<String, Object> mapToken = generateToken((String) mapResponse.get("id_user"));
			String rep_token = saveToken(mapToken);
			System.out.println(rep_token);
			rspModel.setCode("00");
			rspModel.setMessage("Login exitoso");
			rspModel.setError(false);
			rspModel.setData("El login fue realizado exitosamente");
		} else {
			rspModel.setCode("01");
			rspModel.setMessage("Login fallido");
			rspModel.setError(true);
			rspModel.setData("El login fue realizado exitosamente");
		}
		
		return rspModel;
	}
	
	private Map<String, Object> generateToken(String id_user) {
		Map<String, Object> maptoken = new HashMap<>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Random random = new Random();
		maptoken.put("token", String.valueOf( random.nextInt(999999 - 000000 + 1) + 000000));
		maptoken.put("creationDateToken",  String.valueOf(dtf.format(LocalDateTime.now())));
		maptoken.put("expirationDateToken",  String.valueOf(dtf.format(LocalDateTime.now())));
		maptoken.put("id_user", id_user);
		return maptoken; 
	}
	
	private String saveToken(Map<String, Object> tokenParams) throws Exception {
		Map<String, Object> map = saveTokenRepository( tokenParams);
		return (String)map.get("response"); 
	}

}
