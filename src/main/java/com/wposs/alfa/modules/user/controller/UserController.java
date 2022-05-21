package com.wposs.alfa.modules.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.user.dto.ChangePasswordInput;
import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;

@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{
	
	protected ValidateBody validBody;

	@PostMapping("/searchUserByEmail")
	@Input(name="email",			required="true", 			type="Email",				values="")
	@Output(name="respuesta",			required="true", 			type="String",				values="")
	public ResponseEntity<ResponseModel> searchUserByEmail(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return new ResponseEntity<ResponseModel>(searchUserByEmail(request), HttpStatus.OK);
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<ResponseModel> changePassword(@RequestBody @Valid ChangePasswordInput changePasswordInput, BindingResult bindigResult ) throws Exception {
		if(bindigResult.hasErrors()) {
			validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseModel>(changePasswordService(changePasswordInput), HttpStatus.OK);
	}
	
}

