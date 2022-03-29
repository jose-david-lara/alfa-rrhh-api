package com.wposs.alfa.modules.user.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.core.jdbc.BaseResultSet;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.ResultSetIterator;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class UserRepository extends BaseRepositoryDAO {

	
	@Sql(name="getUser",
		 sql="select email from users")
	public  Map<String, Object> searchUserByEmails(Transaction <?> t, Map<String, Object> request) throws Exception  {
		Map<String, Object> response = new HashMap<>();
		/*executeQuery(t, "getUser", new ResultSetIterator() {
			
		
			public void iterate(BaseResultSet rs) throws Exception {
				response.put("email", rs.getObject("email"));
				
			}
		});*/
		/*sql = "select email, state from users where email = ?";
		List<Map<String, Object>> result =  jdbcTemplate.queryForList(sql, new Object[] {
				request.get("email")
		});
		log.info("RESULTADO::"+result);
		result.forEach( rowMap -> {
			response.put("email", (String) rowMap.get("email"));
			response.put("state",  ((Long) rowMap.get("state")).intValue());
		});*/
		response.put("respuesta", "Exitoso!!!");
		return response;
	}

	

	@Sql(name="getUser",
		 sql="select email from users")
	public  Map<String, Object> searchUserByEmail0(Transaction <?> t, Map<String, Object> request) throws Exception  {
		Map<String, Object> response = new HashMap<>();
		executeQuery(t, "getUser", new ResultSetIterator() {
			
		
			public void iterate(BaseResultSet rs) throws Exception {
				response.put("email", rs.getObject("email"));
				
			}
		});
		/*sql = "select email, state from users where email = ?";
		List<Map<String, Object>> result =  jdbcTemplate.queryForList(sql, new Object[] {
				request.get("email")
		});
		log.info("RESULTADO::"+result);
		result.forEach( rowMap -> {
			response.put("email", (String) rowMap.get("email"));
			response.put("state",  ((Long) rowMap.get("state")).intValue());
		});*/
		return response;
	}


}
