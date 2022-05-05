package com.wposs.alfa.modules.test.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.test.repository.TestRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class TestServices extends TestRepository{
	
	private ResponseModel rspModel;
	
	public ResponseModel getTEST(Map<String, Object> request) throws Exception {
		
		 rspModel = new ResponseModel();
		 
		 rspModel.setCode("0");
		 rspModel.setMessage("exitoso");
		 rspModel.setError(false);
		 rspModel.setData(getTESTRepository(request));
		
		return rspModel;
				
	}
}
