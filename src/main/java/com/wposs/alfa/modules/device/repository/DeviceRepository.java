package com.wposs.alfa.modules.device.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.core.jdbc.BaseResultSet;
import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.ResultSetIterator;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class DeviceRepository extends BaseRepositoryDAO{


	/*
	 * Ejemplo para TODO!!!
	 * 
	 */
	@Sql( name="getDevice",
			sql="SELECT SERIAL, MODELO FROM EQUIPOS WHERE ESTADO = ?"
			)
	public  Map<String, Object> getDevice(Transaction <?> t, Map<String, Object> request) throws Exception  {

		/*Map<String, Object> responseDB = new HashMap<>();
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

		return responseDB;*/
		
		executeQuery( t, "getDevice", new ResultSetIterator() {
			
			@Override
			public void iterate(BaseResultSet rs) throws Exception {
				System.err.println("RAFA::::Trae de la BD");
			}
		}, 1);
		return new HashMap<String, Object>();
		
		
	}
}
