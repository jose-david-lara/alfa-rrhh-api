package com.wposs.alfa.modules.employess.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.employess.repository.EmployeeRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class EmployeeServices extends EmployeeRepository{
	
	public ResponseModel getEmployees(Map<String, Object> request) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		rspModel.setData(getExampleOneQuery( request));
		
		return rspModel;
				
	}
}
