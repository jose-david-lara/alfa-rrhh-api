package com.wposs.alfa.modules.params.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class ParamsRepository extends BaseRepositoryDAO{

	String sql;
	Map<String, Object> response = new HashMap<>();
	List<String> lisResponse;

	@Sql(	name="getParameters",
			sql="select serial from equipos where id_equipo = ? "
			)
	public  Map<String, Object> getParameters(Transaction <?> t, Map<String, Object> request) throws Exception  {
		Map<String, Object> responseDB = new HashMap<>();
		sql = "select serial, modelo from equipos where estado = 1";
		System.out.println("Response::"+responseDB.toString());
		return responseDB;
	}

}
