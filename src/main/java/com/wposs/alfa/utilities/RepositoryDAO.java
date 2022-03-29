package com.wposs.alfa.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class RepositoryDAO {
	
	@Autowired
	@Qualifier("jdbcMaster")
	public JdbcTemplate jdbcTemplate;

}
