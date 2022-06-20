package com.wposs.alfa.modules.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wposs.alfa.modules.test.model.Address;
import com.wposs.alfa.modules.test.model.Email;
import com.wposs.alfa.modules.user.model.LoginInput;
import com.wposs.alfa.modules.user.model.UpdatePasswordInput;
import com.wposs.alfa.modules.user.repository.UserRepository;
import com.wposs.alfa_framework.security.SecurityService;
import com.wposs.alfa_framework.spring.CodeResponseRequest;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class UserServices extends UserRepository{

	private ResponseModel rspModel;
	public final static Logger LOGGER = LoggerFactory.getLogger(UserServices.class);

	public ResponseModel loginService(LoginInput loginInput) throws Exception {
		rspModel = new ResponseModel();
		Map<String, Object> mapResponse = loginRepository(loginInput);
		try { 

			LOGGER.info(":::REQUEST LOGINSERVICE:::"+loginInput.toString(), UserServices.class.getName());

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
					mapResponse.clear();
					mapResponse.put("message", "No se pudo guardar el token");
					rspModel.setData(mapResponse);
				}
			} else {
				mapResponse.remove("id_user");
				mapResponse.remove("names");
				rspModel.setCode("01");
				rspModel.setError(false);
				rspModel.setData(mapResponse);
			}
		} catch(Exception e) {
			System.out.println("ERROR:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}

		LOGGER.info(":::RESPONSE LOGINSERVICE:::"+rspModel.toString(), UserServices.class.getName());

		return rspModel;
	}

	public ResponseModel updatePasswordUserService(UpdatePasswordInput updatePasswordInputDTO) throws Exception {
		rspModel = new ResponseModel();
		RestTemplate restTemplate = new RestTemplate();
		Address addressDTO =  new Address();
		List<Address> lisAddressDTO = new ArrayList<Address>();
		Email emailDTO = new Email();

		try { 

			LOGGER.info(":::REQUEST UPDATEPASSWORDUSERSERVICE:::"+updatePasswordInputDTO.toString(), UserServices.class.getName());

			Map<String, Object> mapResponse = updatePasswordUserRepository(updatePasswordInputDTO);
			if(mapResponse.get("message").toString().length() > 0) {

				addressDTO.setName(mapResponse.get("names").toString());
				addressDTO.setAddress(updatePasswordInputDTO.getUsername());
				addressDTO.setType_address("to");

				lisAddressDTO.add(addressDTO);

				emailDTO.setAttachments_flag(false);
				emailDTO.setBody("Tu Contraseña se ha actualizado");
				emailDTO.setDescription("actualizacion de contraseña");
				emailDTO.setFormat("text");
				emailDTO.setTitle("Actualización De Contraseña");
				emailDTO.setAddress(lisAddressDTO);
				LOGGER.info(":::REQUEST SENDEMAIL:::"+emailDTO.toString(), UserServices.class.getName());


				ResponseEntity<ResponseModel> responseEntity = restTemplate.postForEntity("http://localhost:13014/email/sendEmail", emailDTO, ResponseModel.class);
				System.out.println(":::RESPUESTA::::"+responseEntity.getBody());
				ResponseModel respEmail = responseEntity.getBody();
				
				LOGGER.info(":::RESPONSE SENDEMAIL:::"+respEmail.toString(), UserServices.class.getName());

				if(respEmail.getError() == false) {
					mapResponse.put("email_send", true);
				}else if(respEmail.getError() == true) {
					mapResponse.put("email_send", false);	
				}

				rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
				rspModel.setError(false);
				rspModel.setData(mapResponse);				
			} else {
				mapResponse.put("message", CodeResponseRequest.COD_ERROR_EXCEPTION_BD+"|"+CodeResponseRequest.ERROR_EXCEPTION_BD);
				rspModel.setCode(CodeResponseRequest.COD_MSG_SUCCESS);
				rspModel.setError(false);
				rspModel.setData(mapResponse);
			}
		} catch(Exception e) {
			System.out.println("ERROR:::"+e.getMessage());
			rspModel.setCode(CodeResponseRequest.COD_ERROR_EXCEPTION_BKND);
			rspModel.setMessage(CodeResponseRequest.ERROR_BACKEND);
			rspModel.setError(true);
		}
		LOGGER.info(":::RESPONSE UPDATEPASSWORDUSERSERVICE:::"+rspModel.toString(), UserServices.class.getName());
		return rspModel;
	}	



}
