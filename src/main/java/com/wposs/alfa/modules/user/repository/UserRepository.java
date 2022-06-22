package com.wposs.alfa.modules.user.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.wposs.alfa.modules.user.dto.LoginInputDTO;
import com.wposs.alfa.modules.user.dto.UpdatePasswordInputDTO;
import com.wposs.alfa.modules.user.dto.UpdatePersonalInfoDTO;
import com.wposs.alfa_framework.spring.RepositoryDAO;

import net.bytebuddy.asm.Advice.Return;

@Component
public class UserRepository extends RepositoryDAO {
	public Map<String, Object> exampleQueySimple(Map<String, Object> request) throws Exception  {
		
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "SELECT  "
				+ "'JOSE' AS NUMERO "
				+ "FROM DUAL ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				System.out.println("RESPUESTA DB::"+(String) row.get("NUMERO"));
				respuesta.put("numero", (String) row.get("NUMERO"));
				
			}
		}
		
		return  respuesta;
	}
	
	public Map<String, Object> exampleCallPackage(Map<String, Object> request) throws Exception  {
		
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

	public Map<String, Object> loginRepository( LoginInputDTO loginInput) {
		
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlOutParameter("id_user", Types.VARCHAR));
		paramList.add(new SqlOutParameter("names", Types.VARCHAR));
		paramList.add(new SqlOutParameter("message", Types.VARCHAR));

		return jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call RRHH.PKG_GENERALES.PROCD_LOGIN(?,?,?,?,?,?,?,?)}");
				cs.setString(1, loginInput.getUsername());
				cs.setString(2, loginInput.getPassword());
				cs.setString(3, loginInput.getIp());
				cs.setString(4, loginInput.getDevice_last());
				cs.setString(5, loginInput.getType_device());
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.VARCHAR);
				return cs;
			}
		}, paramList);
	}
	
	public Map<String, Object> saveTokenRepository(Map<String, Object> request) {
		
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlOutParameter("token", Types.VARCHAR));
		paramList.add(new SqlOutParameter("response", Types.VARCHAR));

		return jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call RRHH.PKG_GENERALES.PROCD_SAVE_TOKEN(?,?,?,?,?,?)}");
				cs.setString(1, request.get("token").toString());
				cs.setString(2, request.get("creationDateToken").toString());
				cs.setString(3, request.get("expirationDateToken").toString());
				cs.setString(4, request.get("id_user").toString());
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				return cs;
			}
		}, paramList);
		
	}
	
	
	public Map<String, Object> updatePasswordUserRepository(UpdatePasswordInputDTO updatePasswordInputDTO) {
		
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlOutParameter("names", Types.VARCHAR));
		paramList.add(new SqlOutParameter("message", Types.VARCHAR));

		return jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call RRHH.PKG_GENERALES.PROCD_UPDATE_PASSWORD(?,?,?,?,?,?)}");
				cs.setString(1, updatePasswordInputDTO.getUsername());
				cs.setString(2, updatePasswordInputDTO.getOld_password());
				cs.setString(3, updatePasswordInputDTO.getUpdate_password());
				cs.setString(4, updatePasswordInputDTO.getToken());
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				return cs;
			}
		}, paramList);
		
	}	
	
	public Map<String, Object> updatePersonalInformationRespository (UpdatePersonalInfoDTO updatePersonalInfoDTO) {
		List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlParameter(Types.VARCHAR));
		paramList.add(new SqlOutParameter("codeResponse", Types.VARCHAR));
		paramList.add(new SqlOutParameter("message", Types.VARCHAR));

		return jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call RRHH.PKG_GENERALES.PROCD_UPDATE_PASSWORD(?,?,?,?,?,?)}");
				cs.setString(1, updatePersonalInfoDTO.getUsername());
				cs.setString(2, updatePersonalInfoDTO.getNames());
				cs.setString(3, updatePersonalInfoDTO.getSurnames());
				cs.setString(4, updatePersonalInfoDTO.getPersonal_mail());
				cs.setString(5, updatePersonalInfoDTO.getToken());
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.VARCHAR);
				return cs;
			}
		}, paramList);
	}
	
}
