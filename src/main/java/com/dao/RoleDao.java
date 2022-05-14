package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {

	@Autowired //this will inject JdbcTempalte dependency 
	JdbcTemplate stmt; //new->X 
				//spring ioc container-> 
	
	public void insertRole(RoleBean role) {
		stmt.update("insert into role (rolename) values (?)",role.getRoleName());
	}

}
