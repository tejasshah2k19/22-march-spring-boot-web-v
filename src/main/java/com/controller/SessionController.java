package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//stereo type ->  1 2 3 4 
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

	// login

	// forgetpassword

}
