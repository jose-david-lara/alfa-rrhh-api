package com.wposs.alfa.modules.persons.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.repository.PersonRepository;
import com.wposs.core.model.BaseArrayModel;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class PersonServices extends BaseSpringService<PersonRepository>{
	
	public Person getPersonByDocument(Map<String, Object> request) throws Exception  {
		return beginReadTransaction( new Transaction<Person> () {
			public Person doTransaction() throws Exception{
				return getRepository().getPersonByDocument( this, request );	
			}
		});
	}
	
	public BaseArrayModel<Person> getAllPersons(Map<String, Object> request) throws Exception  {
		return beginReadTransaction( new Transaction<BaseArrayModel<Person>> () {
			public BaseArrayModel<Person> doTransaction() throws Exception{
				return getRepository().getAllPersons( this, request );	
			}
		});
	}
	
}
