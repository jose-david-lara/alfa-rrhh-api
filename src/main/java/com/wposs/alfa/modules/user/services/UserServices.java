package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.wposs.alfa.modules.user.dto.LoginInputDTO;
import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.alfa_framework.security.SecurityService;
import com.wposs.alfa_framework.spring.CodeResponseRequest;
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

	public ResponseModel loginService(LoginInputDTO loginInput) throws Exception {
		rspModel = new ResponseModel();
		Map<String, Object> mapResponse = loginRepository(loginInput);
		try {
			if( mapResponse.get("message").toString().equals(CodeResponseRequest.LOGIN_SUCCESS) ) {
				String token =  saveTokenRepository(SecurityService.generateToken( mapResponse.get("id_user").toString())).get("token").toString();
				if (token != null && !token.isEmpty()) {
					mapResponse.remove("id_user");
					mapResponse.put("token", token); 
					rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
					rspModel.setError(false);
					rspModel.setData(mapResponse);
				} else {
					rspModel.setCode("01");
					rspModel.setMessage(CodeResponseRequest.ERROR_LOGIN);
					rspModel.setError(true);
					rspModel.setData(new HashMap<>().put("message", "No se pudo guardar el token"));
				}
			} else {
				rspModel.setCode("01");
				rspModel.setMessage(CodeResponseRequest.ERROR_LOGIN);
				rspModel.setError(true);
				rspModel.setData(mapResponse.get("response"));
			}
		} catch(Exception e) {
			System.out.println("ERROR:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}
		
		return rspModel;
	}
	
}
