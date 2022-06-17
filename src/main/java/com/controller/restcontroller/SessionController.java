package com.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController("sessionController2")
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUsers() {
		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

//	@PostMapping("/signup")
//	public ResponseEntity<?> signup(@RequestBody UserBean user) {
//		UserBean duplicate = userDao.findUserByEmail(user.getEmail());
//		if (duplicate == null) {
//			userDao.insertUser(user);
//			return ResponseEntity.ok(user);
//		} else {
//			// duplicate
//			return new ResponseEntity("Duplicate Email Address", HttpStatus.BAD_REQUEST);
//		}
//	}

	@PostMapping("/signup")
	public ResponseBean<?> signup(@RequestBody UserBean user) {
		UserBean duplicate = userDao.findUserByEmail(user.getEmail());
		ResponseBean<UserBean> resp = new ResponseBean<>();
		if (duplicate == null) {
			userDao.insertUser(user);
			resp.setData(user);
			resp.setStatus(200);
			resp.setMsg("signup done");
		} else {
			// duplicate
			resp.setData(user);
			resp.setStatus(-1);
			resp.setMsg("Email already exists");
		}
		return resp;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean user) {
		if (user.getEmail().equals("admin@gmail.com")) {
			UserBean user2 = new UserBean();
			user2.setFirstName("admin");
			user2.setEmail(user.getEmail());
			user2.setPassword(user.getPassword());
			return ResponseEntity.ok(user2);
		} else {
			ResponseEntity<?> resp = new ResponseEntity(user, HttpStatus.UNAUTHORIZED);
			return resp;
		}
	}
}
