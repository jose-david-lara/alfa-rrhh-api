package com.wposs.alfa.modules.params.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class ParamsServices extends ParamsRepository{
	
	public ResponseModel getParameters(Map<String, Object> request) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		rspModel.setData(getParameters( request));
		
		return rspModel;
				
	}

}
