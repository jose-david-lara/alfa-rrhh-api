package com.wposs.alfa.modules.test.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.wposs.alfa.modules.test.dto.EmailDTO;
import com.wposs.alfa.modules.test.dto.TestInput;
import com.wposs.alfa.modules.test.repository.TestRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class TestServices extends TestRepository{

	private ResponseModel rspModel;
	public final static Logger LOGGER = LoggerFactory.getLogger(TestServices.class);

	public ResponseModel getTESTServices(TestInput inputTest) throws Exception {

		LOGGER.info(":::REQUEST GETTESTSERVICES:::"+inputTest.toString(), TestServices.class.getName());

		rspModel = new ResponseModel();
		Map<String, Object> response = new HashMap<String, Object>();
		
		response = getTESTRepository(inputTest);
		response.put("send_email", sendEmail());

		rspModel.setCode("0");
		rspModel.setMessage("exitoso");
		rspModel.setError(false);
		rspModel.setData(response);
		

		LOGGER.info(":::RESPONSE GETTESTSERVICES:::"+rspModel.toString(), TestServices.class.getName());

		return rspModel;

	}

	private Boolean sendEmail() {

		try {
			
			Gson gson = new Gson();
			RestTemplate restTemplate = new RestTemplate();
			EmailDTO emailDTO = new EmailDTO();
			emailDTO.setBody("hola");
			
			String str = "{\r\n"
					+ "    \"address\":[\r\n"
					+ "        {\r\n"
					+ "        \"address\":\"jose.david.lara@hotmail.com\",\r\n"
					+ "        \"name\":\"Jose Lara\",\r\n"
					+ "        \"type_address\":\"to\"\r\n"
					+ "        }\r\n"
					+ "    ],\r\n"
					+ "    \"attachments_file\":[{\r\n"
					+ "        \"name_file\":\"prueba\",\r\n"
					+ "        \"base64_file\":\"dsf\"\r\n"
					+ "    }],\r\n"
					+ "    \"format\":\"sdfsd\",\r\n"
					+ "   \r\n"
					+ "    \"body\":\"hola prueba\",\r\n"
					+ "    \"title\":\"Prueba\",\r\n"
					+ "    \"description\":\"mensaje de pruebas canal EMAIL\",\r\n"
					+ "    \"attachments_flag\":false\r\n"
					+ "    \r\n"
					+ "}";
			emailDTO = gson.fromJson(str, EmailDTO.class);
			
			System.out.println("::::ENVIO:::"+emailDTO.toString());
		    ResponseEntity<ResponseModel> responseEntity = restTemplate.postForEntity("http://localhost:13014/email/sendEmail", emailDTO, ResponseModel.class);
		    System.out.println(":::RESPUESTA::::"+responseEntity.getBody());
		    ResponseModel respEmail = responseEntity.getBody();
		    return respEmail.getError();
		    
		}catch (Exception e) {
			System.out.println("::::ERROR::::::"+e.getMessage());
			return false;
		}
		
	}
}
