package com.wposs.alfa.modules.test.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Transaction;


@Component
public class TestRepository extends BaseRepositoryDAO{



	public  Map<String, Object> getTEST(Transaction <?> t, Map<String, Object> request) throws Exception  {
		int idEquipo = 1;
		Map<String, Object> response = new HashMap<>();
		
		response.put("TEST", request.get("test"));

		return response;
	}
}
