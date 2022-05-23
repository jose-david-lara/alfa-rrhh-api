package com.wposs.alfa.modules.user.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.dto.ChangePasswordInputDTO;
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
	
	public ResponseModel changePasswordService(ChangePasswordInputDTO changePasswordInput) throws Exception {
		Map<String, Object> map = changePasswordRespository(changePasswordInput);
		ResponseModel responseModel = new ResponseModel(); 
		if (map.get("response").equals("Cambio de clave exitoso")) {
			responseModel.setCode("00");
			responseModel.setError(false);
			responseModel.setData(map.get("response"));
			responseModel.setMessage("Su clave fue actualizada exitosamente");
			return responseModel; 
		} else {
			responseModel.setCode("01");
			responseModel.setError(true);
			responseModel.setData(map.get("response"));
			responseModel.setMessage("Su clave no fue actualizada");
			return responseModel; 
		}
	}

}
