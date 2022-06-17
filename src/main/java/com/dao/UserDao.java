package com.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertUser(UserBean user) {
		// insert -> auto generated id --> stmt [ back ]

		KeyHolder keyHolder = new GeneratedKeyHolder();

		stmt.update(con -> {
			PreparedStatement ps = con.prepareStatement("insert into users (firstname,email,password) values (?,?,?)",
					new String[] { "userid" });
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			return ps;
		}, keyHolder);

		int userId = keyHolder.getKey().intValue();
//
//		keyHolder.getKeys().get("userid");
//		keyHolder.getKeys().get("firstname");
		updateProfile(userId, user.getProfile());
	}

	public void updateProfile(int userId, String profile) {

		// stmt.update("update user_profile where userid = ? ", userId);
		stmt.update("insert into user_profile (userid,profile,active)  values (?,?,true)", userId, profile);
		// read order by
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public UserBean findUserByEmail(String email) {
//		UserBean user = null;
//		try {
//			user = stmt.queryForObject("select * from users where email =  ?",
//					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
//		} catch (Exception e) {
//			System.out.println("exception in finduserbyemail");
//			System.out.println(e.getMessage());
//		}
//
//		return user;
		List<UserBean> users = stmt.query("select * from users where email = ? ", new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { email });

		if (users.size() == 0) {
			return null;//0 user email not present 
		} else {
			return users.get(0); // 1 user return 
		}
	}

}
