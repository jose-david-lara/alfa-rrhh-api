package com.wposs.alfa.modules.employess.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.wposs.alfa_framework.spring.RepositoryDAO;

@Component
public class EmployeeRepository extends RepositoryDAO{




	/*
	 * Ejemplo para TODO!!!
	 * 
	 */

	public Map<String, Object> getExampleOneQuery( Map<String, Object> request) throws Exception  {

		Map<String, Object> categories = null;
		String sql = "SELECT  "
				+ "ID_CATEGORIE_BUSINESS, NAME, DESCRIPTION, URL_IMG "
				+ "FROM DANKO.DANKO_CATEGORIES_BUSINESS "
				+ "WHERE DANKO_STATE = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				1);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				/*Categories categorie = new Categories();
				categorie.setIdCategorie(((Number)row.get("ID_CATEGORIE_BUSINESS")).toString());
				categorie.setName((String) row.get("NAME"));
				categorie.setDescription((String) row.get("DESCRIPTION"));
				categorie.setImg((String) row.get("URL_IMG"));
				categories.add(categorie);*/
			}
		}
		
		return categories;
	}
		

	public Map<String, Object>  getExampleTwoPackages( Map<String, Object> request) throws Exception  {
		
		Map<String, Object>  business = null;
		String sql = "SELECT  "
				+ "ID_BUSINESS,NAME, DESCRIPTION,IMG, URL,ID_CATEGORIE "
				+ "FROM DANKO.DANKO_BUSINESS ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				/*Business bussn = new Business();
				bussn.setIdCategorie(((Number) row.get("ID_BUSINESS")).toString());
				bussn.setName((String) row.get("NAME"));
				bussn.setDescription((String) row.get("DESCRIPTION"));
				bussn.setImg((String) row.get("IMG"));
				bussn.setUrlBusiness((String) row.get("URL"));
				bussn.setIdCategorie(((Number) row.get("ID_CATEGORIE")).toString());
				business.add(bussn);*/
			}
		}
		
		return business;
	}
	
	public void exampleGetPackages () {
		
	    List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
	    
	     jdbcTemplate.call(new CallableStatementCreator() {
	      @Override
	      public CallableStatement createCallableStatement(Connection con) throws SQLException {
	        CallableStatement cs = con.prepareCall("{call DANKO.PKG_GENERALES.PROCD_CATEGORIES(?,?)}");
	        cs.setString(1, "1");
	        cs.registerOutParameter(2, Types.VARCHAR);
	        cs.execute();
	        
	        System.out.println("resultado consulta::"+cs.getString(2));
	        return cs;
	      }
	    }, parameters);
	}
}
