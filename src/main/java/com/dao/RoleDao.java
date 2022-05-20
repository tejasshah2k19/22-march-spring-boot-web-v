package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import com.bean.RoleBean;

@Repository
public class RoleDao {

	@Autowired // this will inject JdbcTempalte dependency
	JdbcTemplate stmt; // new->X
	// spring ioc container->

	public void insertRole(RoleBean role) {
		stmt.update("insert into role (rolename) values (?)", role.getRoleName());
	}

	public List<RoleBean> getAllRoles() {

		List<RoleBean> roles = stmt.query("select * from role ", new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roles;
		// 5 row
		// while(rs.next()){
		// RoleBean roleBean = new RoleBean();
		// roleBean.setRoleName( rs.getString("roleName")) ;
		// roleBean.setRoleId(rs.getInt("roleId")) ;
		// alist.add(roleBean);
		// }
		// return alist;
	}

}
