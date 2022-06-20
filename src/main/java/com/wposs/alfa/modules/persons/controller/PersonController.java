package com.wposs.alfa.modules.persons.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.persons.model.PersonByDocumentInput;
import com.wposs.alfa.modules.persons.service.PersonServices;
import com.wposs.alfa_framework.spring.ResponseModel;
import com.wposs.alfa_framework.spring.ValidateBody;

@RestController
@RequestMapping(path = "/persons")
public class PersonController extends PersonServices{
	
	protected ValidateBody validBody;

	@PostMapping("/getPersonByDocument")
	public ResponseEntity<ResponseModel> getPersonByDocument(@RequestBody @Valid PersonByDocumentInput inputDTO, BindingResult bindigResult ) throws Exception  {
		if(bindigResult.hasErrors()){
	    	validBody = new ValidateBody();
	    	return new ResponseEntity<ResponseModel>(validBody.validBodyRequest(bindigResult),HttpStatus.OK);
	    }	
		return new ResponseEntity<ResponseModel>(getPersonByDocumentService(inputDTO), HttpStatus.OK);
	}

	@GetMapping("/getAllPersons")
	public ResponseEntity<ResponseModel> getAllPersons(Map<String, Object> map) throws Exception  {	
		return new ResponseEntity<ResponseModel>(getAllPersonsService(), HttpStatus.OK);
	}

}
