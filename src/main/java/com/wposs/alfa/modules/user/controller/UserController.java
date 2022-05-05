package com.wposs.alfa.modules.user.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;
import com.wposs.alfa_framework.spring.ResponseModel;

@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{

	@PostMapping("/searchUserByEmail")
	@Input(name="email",			required="true", 			type="Email",				values="")
	@Output(name="respuesta",			required="true", 			type="String",				values="")
	public ResponseEntity<ResponseModel> searchUserByEmail(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return new ResponseEntity<ResponseModel>(searchUserByEmail(request), HttpStatus.OK);
	}
}

