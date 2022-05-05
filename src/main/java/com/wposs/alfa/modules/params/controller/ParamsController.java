package com.wposs.alfa.modules.params.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wposs.alfa.modules.params.service.ParamsServices;
import com.wposs.alfa_framework.spring.Input;
import com.wposs.alfa_framework.spring.Output;
import com.wposs.alfa_framework.spring.ResponseModel;

@RestController
@RequestMapping(path = "/params")
public class ParamsController extends ParamsServices{

	@PostMapping("/getParameters")
	@Input(name="versionPOS",	    required="true", 			type="String",				values="")
	@Input(name="imeiPOS",	        required="true", 			type="String",				values="")
	@Input(name="model",	        required="true", 			type="String",				values="")
	@Input(name="semilla",	        required="true", 			type="String",				values="")
	@Input(name="serialPOS",	    required="true", 			type="String",				values="")
	@Input(name="id_equipo",	    required="true", 			type="String",				values="")
	@Output(name="json",			required="true", 			type="String",				values="")
	public ResponseEntity<ResponseModel>  getParameters(@RequestBody Map<String, Object> request, BindingResult bindigResult ) throws Exception {
		
		return new ResponseEntity<ResponseModel>(getParameters(request), HttpStatus.OK);
	}
}
