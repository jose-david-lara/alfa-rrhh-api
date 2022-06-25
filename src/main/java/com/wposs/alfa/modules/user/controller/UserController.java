package com.wposs.alfa.modules.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wposs.alfa.modules.user.model.LoginInput;
import com.wposs.alfa.modules.user.model.UpdatePasswordInput;
import com.wposs.alfa.modules.user.model.UpdatePersonalInfoInput;
import com.wposs.alfa.modules.user.model.UpdateStateUser;
import com.wposs.alfa.modules.user.services.UserServices;
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;


@RestController
@RequestMapping(path = "/users")
public class UserController extends UserServices{
	protected ValidateBody validBody;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseModel> login(@RequestBody @Valid LoginInput loginInput, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }
		return new ResponseEntity<ResponseModel>(loginService(loginInput), HttpStatus.OK);
	}
	
	@PostMapping("/updatePasswordUser")
	public ResponseEntity<ResponseModel> updatePasswordUser(@RequestBody @Valid UpdatePasswordInput updatePasswordInputDTO, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }
		return new ResponseEntity<ResponseModel>(updatePasswordUserService(updatePasswordInputDTO), HttpStatus.OK);
	}
	
	@PostMapping("/updatePersonalInformation")
	public ResponseEntity<ResponseModel> updatePersonalInformation(@RequestBody @Valid UpdatePersonalInfoInput updatePersonalInfoInput, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
	    }
		return new ResponseEntity<ResponseModel>(updatePersonalInfoService(updatePersonalInfoInput), HttpStatus.OK);
	}

	@PostMapping("/updateStateUser")
	public ResponseEntity<ResponseModel> updateStateUser(@RequestBody @Valid UpdateStateUser UpdateStateUser, BindingResult bindingResult ) throws Exception {
		if(bindingResult.hasErrors()){
			validBody = new ValidateBody();
			return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindingResult),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseModel>(updateStateUserService(UpdateStateUser), HttpStatus.OK);
	}	

}