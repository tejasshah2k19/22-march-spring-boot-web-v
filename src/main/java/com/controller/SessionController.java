package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String signup(Model model) {
		UserBean user1223 = new UserBean();
		model.addAttribute("user",user1223);
		System.out.println("Signup()");
		return "Signup"; // Signup.jsp

	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid UserBean user123, BindingResult result, Model model) {
		System.out.println("saveUser()");
		System.out.println(user123.getFirstName());
		System.out.println(user123.getEmail());
		System.out.println(user123.getPassword());

		model.addAttribute("user", user123);

		if (result.hasErrors()) { // true --> if errors
			return "Signup";// goBack
		} else {
			return "Home";
		}

	}

	// login

	// forgetpassword

}
