package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	public static String rootPath = "E:\\Tejas Shah\\Dropbox\\boot\\22-may-spring-boot-v\\src\\main\\resources\\static\\";

	public boolean profilePicUpload(MultipartFile file, String email) {

		File rootDir = new File(rootPath);
		File emailDir = new File(rootDir, email);// static,a@g.com
		emailDir.mkdir();// boolean -> true | false

		File p = new File(emailDir, file.getOriginalFilename());

		try {
			byte b[] = file.getBytes();//
			FileOutputStream fos = new FileOutputStream(p);
			fos.write(b);
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;

	}

}
