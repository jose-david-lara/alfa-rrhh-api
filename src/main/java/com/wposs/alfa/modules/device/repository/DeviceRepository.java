package com.wposs.alfa.modules.device.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.device.model.Device;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Transaction;

@Component
public class DeviceRepository extends BaseRepositoryDAO{


	@Autowired
	private JdbcTemplate jdbcTemplate;


	/*
	 * Ejemplo para TODO!!!
	 * 
	 */
	public  Map<String, Object> getDevice(Transaction <?> t, Map<String, Object> request) throws Exception  {

		Map<String, Object> responseDB = new HashMap<>();
		List<Device> devices = new ArrayList<>();
		String sql = "select serial, modelo from equipos where estado = ?";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {
				request.get("id_equipo")
		});

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				Device device = new Device();
				device.setSerial((String) row.get("serial"));
				device.setModel((String) row.get("modelo"));
				devices.add(device);
			}
			responseDB.put("device", devices);
			responseDB.put("message", "consulta exitosa");
			
		}else {
			responseDB.put("message", "no existen datos");
		}

		return responseDB;
		
		
	}
}
