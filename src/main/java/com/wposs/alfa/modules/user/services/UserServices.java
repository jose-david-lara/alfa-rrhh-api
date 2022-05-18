package com.wposs.alfa.modules.user.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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


	public Map<String, Object> login(Map<String, Object> request) throws Exception {
		return beginReadTransaction( new Transaction<Map<String, Object>> () {
			public Map<String, Object> doTransaction() throws Exception{
				Map<String, Object> mapResponse = getRepository().login( this, request );
				String response = (String) mapResponse.get("response");
				if( response.equals("Login exitoso")) {
					Map<String, Object> mapToken = generateToken((String) mapResponse.get("id_user"));
					String rep_token = saveToken(mapToken);
					System.out.println(rep_token);
				}
				return mapResponse; 
			}
		});
	}
	
	private static Map<String, Object> generateToken(String id_user) {
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
		return beginReadTransaction( new Transaction<String> () {
			public String doTransaction() throws Exception{
				Map<String, Object> map = getRepository().saveToken(this, tokenParams);
				return (String)map.get("response"); 
			}
		});
	}

}
