package com.wposs.alfa.modules.persons.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.persons.dto.PersonByDocumentInputDTO;
import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.repository.PersonRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class PersonServices extends PersonRepository{
	
	public ResponseModel getPersonByDocumentService(PersonByDocumentInputDTO inputDTO) throws Exception  {
		ResponseModel responseModel = new ResponseModel(); 
		Person person = getPersonByDocument(inputDTO);
		responseModel.setCode("00");
		responseModel.setMessage("Su usuario existe");
		responseModel.setData(person);
		responseModel.setError(false);
		return responseModel; 
	}
	
	public ResponseModel getAllPersons(Map<String, Object> request) throws Exception  {
		return null; 
	}
	
}
