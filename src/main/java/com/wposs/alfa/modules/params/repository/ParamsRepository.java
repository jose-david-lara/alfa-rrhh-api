package com.wposs.alfa.modules.params.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa_framework.spring.RepositoryDAO;

@Component
public class ParamsRepository extends RepositoryDAO{


	public  Map<String, Object> getParametersRepository( Map<String, Object> request) throws Exception  {
		
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
	
	private void utilsBD () {
		List<Map<String, Object>> result = null;
		
		for (Map<String, Object> map : result) {
		    for (Map.Entry<String, Object> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + " - " + entry.getValue());
		    }
		}
		
		System.out.println("PASOOOOO");
		
		for (Map<String, Object> map : result) {
		    for (Map.Entry<String, Object> entry : map.entrySet()) {
		        String key = entry.getKey();
		        Object value = entry.getValue();
		    }
		    System.out.println("PASE PRIMERO");
		}
	}

}
