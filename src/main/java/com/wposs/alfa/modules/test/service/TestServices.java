package com.wposs.alfa.modules.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
		 
		 rspModel.setCode("0");
		 rspModel.setMessage("exitoso");
		 rspModel.setError(false);
		 rspModel.setData(getTESTRepository(inputTest));
		 
		 LOGGER.info(":::RESPONSE GETTESTSERVICES:::"+rspModel.toString(), TestServices.class.getName());
		
		return rspModel;
				
	}
}
