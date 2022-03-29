package com.wposs.alfa.modules.test.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.test.repository.TestRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class TestServices extends BaseSpringService<TestRepository>{
	
	public Map<String, Object> getTEST(Map<String, Object> request) throws Exception {
		return beginReadTransaction(new Transaction<Map<String, Object>>() {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().getTEST(this, request);
			}
			
		});
				
	}
}
