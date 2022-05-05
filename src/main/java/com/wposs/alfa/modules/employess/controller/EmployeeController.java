package com.wposs.alfa.modules.employess.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.employess.service.EmployeeServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;
import com.wposs.alfa_framework.spring.ResponseModel;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController extends EmployeeServices{
	
	@PostMapping("/getEmployees")
	@Input(name="id_equipo",	    required="true", 			type="String",				values="")
	@Output(name="employess",		required="true", 			type="String",				values="")
	@Output(name="message",			required="true", 			type="String",				values="")
	public ResponseEntity<ResponseModel> getEmployees(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return new ResponseEntity<ResponseModel>(getEmployees(request), HttpStatus.OK);
	}
}
