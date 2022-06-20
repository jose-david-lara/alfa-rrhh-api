package com.wposs.alfa.modules.persons.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.alfa.modules.persons.model.PersonByDocumentInput;
import com.wposs.alfa_framework.spring.RepositoryDAO;

@Component
public class PersonRepository extends RepositoryDAO{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Person getPersonByDocument(PersonByDocumentInput inputDTO) throws Exception  {
		String sql = "SELECT "
				+ "NAMES, "
				+ "LAST_NAMES, "
				+ "DOCUMENT_TYPE, "
				+ "DOCUMENT, "
				+ "CORPORATE_MAIL, "
				+ "PERSONAL_MAIL, "
				+ "BIRTHDAY_DATE "
				+ "FROM "
				+ "RRHH.RRHH_PERSONS "
				+ "WHERE "
				+ "DOCUMENT_TYPE = ? "
				+ "AND DOCUMENT = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, inputDTO.getDocument_type(), inputDTO.getDocument());
		Person person = new Person();
		
		if(rows != null) {
			for (Map<String, Object> row : rows) {
				person.setName( row.get("NAMES").toString());
				person.setLastName( row.get("LAST_NAMES").toString() );
				person.setDocumentType(row.get("DOCUMENT_TYPE").toString() );
				person.setDocument(row.get("DOCUMENT").toString() );
				person.setCorporateMail( row.get("CORPORATE_MAIL").toString() );
				person.setPersonalMail( row.get("PERSONAL_MAIL").toString() );
				person.setBirthdayDate( (Date) row.get("BIRTHDAY_DATE") );
			}
		}
		return person;
	}

	public ArrayList<Person> getAllPersons() throws Exception  {
		ArrayList<Person> persons = new ArrayList<>(); 
		String sql = "SELECT "
				+ "NAMES, "
				+ "LAST_NAMES, "
				+ "DOCUMENT_TYPE, "
				+ "DOCUMENT, "
				+ "CORPORATE_MAIL, "
				+ "PERSONAL_MAIL, "
				+ "BIRTHDAY_DATE "
				+ "FROM "
				+ "RRHH.RRHH_PERSONS ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		if(rows != null) {
			for (Map<String, Object> row : rows) {
				Person person = new Person();
				person.setName( row.get("NAMES").toString());
				person.setLastName( row.get("LAST_NAMES").toString() );
				person.setDocumentType(row.get("DOCUMENT_TYPE").toString() );
				person.setDocument(row.get("DOCUMENT").toString() );
				person.setCorporateMail( row.get("CORPORATE_MAIL").toString() );
				person.setPersonalMail( row.get("PERSONAL_MAIL").toString() );
				person.setBirthdayDate( (Date) row.get("BIRTHDAY_DATE") );
				persons.add(person);
			}
		}
		return persons;
	}

}
