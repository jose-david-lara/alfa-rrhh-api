package com.wposs.alfa.modules.params.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ListResourceBundle;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import com.wposs.core.jdbc.BaseResultSet;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.ResultSetIterator;
import org.springframework.jdbc.core.JdbcTemplate;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class ParamsRepository extends BaseRepositoryDAO{

	String sql;
	Map<String, Object> response = new HashMap<>();
	List<String> lisResponse;
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Sql(	name="getParameters",
			sql="select serial from equipos where id_equipo = ? "
			)
	public  Map<String, Object> getParameters(Transaction <?> t, Map<String, Object> request) throws Exception  {
		
		Map<String, Object> responseDB = new HashMap<>();
		
		
		
		
		
		
		sql = "select serial, modelo from equipos where estado = 1";
		

		
		
		/*List<Map<String, Object>> result =  jdbcTemplate.queryForList(sql, new Object[] {
				request.get("id_equipo")
		});
		System.out.println("RESULTADO::"+result);
		
		
		
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
		
		
		
		result.forEach( rowMap -> {
			responseDB.put("serial", (String) rowMap.get("serial"));
			responseDB.put("modelo",  (String) rowMap.get("modelo"));
		});*/
		
		System.out.println("Response::"+responseDB.toString());
		
		return responseDB;
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
