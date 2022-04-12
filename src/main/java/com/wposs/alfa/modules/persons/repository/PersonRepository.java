package com.wposs.alfa.modules.persons.repository;

import java.util.Map;

//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.persons.model.Person;
import com.wposs.core.jdbc.BaseResultSet;
import com.wposs.core.model.BaseArrayModel;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.ResultSetIterator;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class PersonRepository extends BaseRepositoryDAO{

	@Sql(	name="getPersonByDocument",
			/*sql="SELECT "
					+ "NAME, "
					+ "LAST_NAMES, "
					+ "CORPORATE_MAIL, "
					+ "PERSONAL_MAIL, "
					+ "BIRTHDAY_DATE "
					+ "FROM "
					+ "RRHH.RRHH_PERSONS "
					+ "WHERE "
					+ "DOCUMENT_TYPE = 'CC' "
					+ "AND DOCUMENT = '1026584110' "*/
			sql="SELECT sysdate FROM dual"
			)
	public Person getPersonByDocument(Transaction <?> t, Map<String, Object> request) throws Exception  {
		/*String sql = "SELECT "
				+ "NAMES, "
				+ "LAST_NAMES, "
				+ "CORPORATE_MAIL, "
				+ "PERSONAL_MAIL, "
				+ "BIRTHDAY_DATE "
				+ "FROM "
				+ "RRHH.RRHH_PERSONS "
				+ "WHERE "
				+ "DOCUMENT_TYPE = 'CC' "
				+ "AND DOCUMENT = '1026584110' ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, request.get("documentType").toString(), request.get("document").toString());
		Person person = new Person();

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				person.setName( row.get("NAMES").toString());
				person.setLastName( row.get("LAST_NAMES").toString() );
				person.setCorporateMail( row.get("CORPORATE_MAIL").toString() );
				person.setPersonalMail( row.get("PERSONAL_MAIL").toString() );
				person.setBirthdayDate( (Date) row.get("BIRTHDAY_DATE") );
			}
		}*/

		executeQuery( t, "getPersonByDocument", new ResultSetIterator() {
			@Override
			public void iterate(BaseResultSet rs) throws Exception {
				System.err.println("RAFA::::Trae de la BD");
			}
		} );
		return new Person();
	}

	public BaseArrayModel<Person> getAllPersons(Transaction <BaseArrayModel<Person>> t, Map<String, Object> request) throws Exception  {
		String sql = "SELECT "
				+ "NAMES, "
				+ "LAST_NAMES, "
				+ "CORPORATE_MAIL, "
				+ "PERSONAL_MAIL, "
				+ "BIRTHDAY_DATE "
				+ "FROM "
				+ "RRHH.RRHH_PERSONS ";

		/*List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);*/
		BaseArrayModel<Person> persons = new BaseArrayModel<>();

		/*if(rows != null) {
			for (Map<String, Object> row : rows) {
				Person person = new Person();
				person.setName( row.get("NAMES").toString());
				person.setLastName( row.get("LAST_NAMES").toString() );
				person.setCorporateMail( row.get("CORPORATE_MAIL").toString() );
				person.setPersonalMail( row.get("PERSONAL_MAIL").toString() );
				person.setBirthdayDate( (Date) row.get("BIRTHDAY_DATE") );
				persons.add(person);
			}
		}*/
		return persons;
	}


}
