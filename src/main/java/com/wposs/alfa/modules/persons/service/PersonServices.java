package com.wposs.alfa.modules.persons.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.persons.dto.PersonByDocumentInputDTO;
import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.repository.PersonRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class PersonServices extends PersonRepository{
	
	public ResponseModel getPersonByDocumentService(PersonByDocumentInputDTO inputDTO) throws Exception {
		ResponseModel responseModel = new ResponseModel(); 
		Person person = getPersonByDocument(inputDTO);
		responseModel.setCode("00");
		responseModel.setMessage("Su usuario existe");
		responseModel.setData(person);
		responseModel.setError(false);
		return responseModel; 
	}
	
	public ResponseModel getAllPersonsService() throws Exception  {
		ResponseModel responseModel = new ResponseModel(); 
		ArrayList<Person> person = getAllPersons();
		if (person.size() != 0 ) {
			responseModel.setCode("00");
			responseModel.setMessage("Estos son los usuarios que existen");
			responseModel.setData(person);
			responseModel.setError(false);
		} else {
			responseModel.setCode("01");
			responseModel.setMessage("No existen usuarios registrados");
			responseModel.setData(null);
			responseModel.setError(false);
		}
		return responseModel;
	}
	
}
