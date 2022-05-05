package com.wposs.alfa.modules.test.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.test.service.TestServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;
import com.wposs.alfa_framework.spring.ResponseModel;


@RestController
@RequestMapping(path = "/test")
public class TestController extends TestServices {
	
	@PostMapping("/getTest")
	@Input(name="test",	            required="true", 			type="String",				values="")
	@Output(name="json",			required="true", 			type="String",				values="")
	public ResponseEntity<ResponseModel> getTEST(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {

	  
		return new ResponseEntity<ResponseModel>(getTEST(request), HttpStatus.OK);

	}

}
