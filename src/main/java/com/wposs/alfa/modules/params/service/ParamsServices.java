package com.wposs.alfa.modules.params.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.params.repository.ParamsRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class ParamsServices extends BaseSpringService<ParamsRepository>{
	
	public Map<String, Object> getParameters(Map<String, Object> request) throws Exception {
		return beginReadTransaction(new Transaction<Map<String, Object>>() {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().getParameters(this, request);
			}
			
		});
				
	}

}
