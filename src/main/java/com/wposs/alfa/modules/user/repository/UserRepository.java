package com.wposs.alfa.modules.user.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.wposs.core.repository.BaseRepositoryDAO;
import com.wposs.core.repository.Sql;
import com.wposs.core.repository.Transaction;

@Component
public class UserRepository extends BaseRepositoryDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;


	//Example Consume DB
	public Map<String, Object> exampleQueySimple(Transaction <?> t, Map<String, Object> request) throws Exception  {

		Map<String, Object> response = new HashMap<>();
		List<String> listExample = new ArrayList<>();
		String sql = "SELECT  "
				+ "1 AS NUMBER"
				+ "FROM DUAL "
				+ "WHERE STATE = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, request.get("state"));

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				String exampleObj;
				exampleObj = (String) row.get("NUMBER");
				listExample.add(exampleObj);
			}
		}
		response.put("RESPONSE", listExample);
		return response;
	}

	public Map<String, Object> exampleCallPackage(Transaction <?> t, Map<String, Object> request) throws Exception  {

		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlOutParameter("username", Types.VARCHAR));
		paramList.add(new SqlOutParameter("device", Types.VARCHAR));
		paramList.add(new SqlOutParameter("message", Types.VARCHAR));

		return jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call RRHH.PKG_GENERALES.PROCD_AUTHENTICATION(?,?,?,?,?,?,?,?,?)}");
				cs.setString(1, request.get("user_app").toString());
				cs.setString(2, request.get("user").toString());
				cs.setString(3, request.get("password").toString());
				cs.setString(4, request.get("device").toString());
				cs.setString(5, request.get("version").toString());
				cs.setString(6, request.get("ip").toString());	        
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.VARCHAR);
				return cs;
			}
		}, paramList);
	}

	@Sql(name="getUser",
			sql="select email from users")
	public  Map<String, Object> searchUserByEmail0(Transaction <?> t, Map<String, Object> request) throws Exception  {
		Map<String, Object> response = new HashMap<>();
		return response;
	}


}
