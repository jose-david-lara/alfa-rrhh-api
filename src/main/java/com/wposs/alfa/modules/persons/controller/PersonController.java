package com.wposs.alfa.modules.persons.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.service.PersonServices;
import com.wposs.core.controller.BaseSpringController;
import com.wposs.core.controller.ProcessController;
import com.wposs.core.model.BaseArrayModel;
import com.wposs.core.model.BaseResponse;
import com.wposs.core.spring.Input;

@RestController
@RequestMapping(path = "/persons")
public class PersonController extends BaseSpringController<PersonServices>{
	
	@PostMapping("/getPersonByDocument")
	@Input(name="documentType",				required="true", 			type="String",				values="")
	@Input(name="document",					required="true", 			type="String",				values="")
	public ResponseEntity<BaseResponse<Person>> getPersonByDocument(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception  {
		return processController( new ProcessController<BaseResponse<Person>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<Person>> onProcess( BaseResponse<Person> response ) throws Exception {
				response.setModel( getService().getPersonByDocument(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}
	
	@PostMapping("/getAllPersons")
	public ResponseEntity<BaseResponse<BaseArrayModel<Person>>> getAllPersons(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception  {
		return processController( new ProcessController<BaseResponse<BaseArrayModel<Person>>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<BaseArrayModel<Person>>> onProcess( BaseResponse<BaseArrayModel<Person>> response ) throws Exception {
				response.setModel( getService().getAllPersons(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}
	
}
