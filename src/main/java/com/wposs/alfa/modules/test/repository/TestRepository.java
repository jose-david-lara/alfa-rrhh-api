package com.wposs.alfa.modules.test.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.test.model.TestInput;
import com.wposs.alfa_framework.spring.RepositoryDAO;


@Component
public class TestRepository extends RepositoryDAO{


	public  Map<String, Object> getTESTRepository( TestInput inputTest) throws Exception  {
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "SELECT  "
				+ "'JOSE' AS NUMERO "
				+ "FROM DUAL ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				System.out.println("RESPUESTA DB::"+(String) row.get("NUMERO"));
				respuesta.put("numero", (String) row.get("NUMERO"));
				
			}
		}
		
		return  respuesta;
	}
}
