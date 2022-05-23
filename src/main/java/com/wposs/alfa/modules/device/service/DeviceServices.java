package com.wposs.alfa.modules.device.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.device.repository.DeviceRepository;
import com.wposs.alfa_framework.spring.ResponseModel;

@Component
public class DeviceServices extends DeviceRepository{
	
	public ResponseModel getDevice(Map<String, Object> request) throws Exception {
		
		ResponseModel rspModel = new ResponseModel();
		rspModel.setData(getDeviceRepository( request));
		
		return rspModel;
				
	}
}
