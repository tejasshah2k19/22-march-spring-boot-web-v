package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

//stereo type ->  1@Controller 2 @Repository 3@Service  4@Component  
@Controller
public class SessionController {
	// singleton design pattern
	// life-cycle - ioc container

	// signup
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		System.out.println("Signup()");
		return "Signup"; // Signup.jsp

	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(UserBean user,Model model) {
		System.out.println("saveUser()");
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		model.addAttribute("user", user);
		
		return "Home";
	}

	// login

	// forgetpassword

}
