package com.wposs.alfa.modules.device.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.device.model.Device;
import com.wposs.alfa.modules.device.service.DeviceServices;
import com.wposs.core.controller.BaseSpringController;
import com.wposs.core.controller.ProcessController;
import com.wposs.core.model.BaseResponse;
import com.wposs.core.spring.Input;
import com.wposs.core.spring.Output;

@RestController
@RequestMapping(path = "/device")
public class DeviceController extends BaseSpringController<DeviceServices>{
	
	@PostMapping("/getDevices")
	@Input(name="id_equipo",	    required="true", 			type="String",				values="")
	@Output(name="device",			required="true", 			type="String",				values="")
	@Output(name="message",			required="true", 			type="String",				values="")
	public ResponseEntity<BaseResponse<Map<String, Object>>> getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		return processController( new ProcessController<BaseResponse<Map<String, Object>>>( request, bindigResult ) {
			public ResponseEntity<BaseResponse<Map<String, Object>>> onProcess( BaseResponse<Map<String, Object>> response ) throws Exception {
				response.setModel( getService().getDevice(request) );
				return new ResponseEntity<>( response, HttpStatus.OK );
			}
		} ) ;
	}	

}
