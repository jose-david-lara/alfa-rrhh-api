package com.wposs.alfa.modules.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.user.dto.LoginInputDTO;
import com.wposs.alfa.modules.user.dto.UpdatePasswordInputDTO;
import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;


@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{
	protected ValidateBody validBody;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseModel> login(@RequestBody @Valid LoginInputDTO loginInput, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }
		return new ResponseEntity<ResponseModel>(loginService(loginInput), HttpStatus.OK);
	}
	
	@PostMapping("/updatePasswordUser")
	public ResponseEntity<ResponseModel> updatePasswordUser(@RequestBody @Valid UpdatePasswordInputDTO updatePasswordInputDTO, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }
		return new ResponseEntity<ResponseModel>(updatePasswordUserService(updatePasswordInputDTO), HttpStatus.OK);
	}

}

