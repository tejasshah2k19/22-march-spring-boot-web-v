package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

	// create 1 url for input type file
	@GetMapping("newprofile")
	public String newProfile() {
		return "NewProfile";
	}

	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, @RequestParam("title") String title) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		System.out.println(title);
		File dir = new File("E:\\Tejas Shah\\Dropbox\\boot\\22-may-spring-boot-v\\src\\main\\resources\\static\\");
		File p = new File(dir, file.getOriginalFilename());

		try {
			byte b[] = file.getBytes();//
			FileOutputStream fos = new FileOutputStream(p);
			fos.write(b);
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Success";
	}

	@GetMapping("/listprofile")
	public String listAllImages(Model model) {

		File f = new File("E:\\Tejas Shah\\Dropbox\\boot\\22-may-spring-boot-v\\src\\main\\resources\\static\\");
		String allFiles[] = f.list(); // String[] filenames
		model.addAttribute("allFiles", allFiles);
		return "AllImg";
	}

}
