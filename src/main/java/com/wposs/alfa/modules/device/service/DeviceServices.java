package com.wposs.alfa.modules.device.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.device.model.Device;
import com.wposs.alfa.modules.device.repository.DeviceRepository;
import com.wposs.core.repository.Transaction;
import com.wposs.core.service.BaseSpringService;

@Component
public class DeviceServices extends BaseSpringService<DeviceRepository>{
	
	public Map<String, Object> getDevice(Map<String, Object> request) throws Exception {
		return beginReadTransaction(new Transaction<Map<String, Object>>() {
			public Map<String, Object> doTransaction() throws Exception{
				return getRepository().getDevice(this, request);
			}
			
		});
				
	}
}
