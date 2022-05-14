package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.RoleBean;
import com.dao.RoleDao;

@Controller
public class RoleController {

	@Autowired // no -> singleton --> server start -> @Repo @Contr [4 stereotype] -> ready
				// @Autowired -> ask --> get
	RoleDao roleDao;

	@GetMapping("/newrole") // GET
	public String newRole(Model model) {
		model.addAttribute("role", new RoleBean());
		return "NewRole";
	}

	@PostMapping("/saverole") // POST
	public String saveRole(@ModelAttribute("role") @Valid RoleBean role, BindingResult result, Model model) {
		System.out.println(role.getRoleName());
		model.addAttribute("role", role);
		if (result.hasErrors()) {
			// true
			// error
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldErrorCount());
			System.out.println(result.getAllErrors());
			return "NewRole";
		} else {

			// db insert
			roleDao.insertRole(role);
			return "";
		}
	}
}
