package com.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.bean.UserBean;

@Service
public class EmailService {

	public void welcomeEmail(UserBean user) {
		final String from = "tejasshah2k19@gmail.com";// from address
		final String appPassword = "bfngzdwelyzbfmld"; // tejas123

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(from);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Welcome");
//			message.setContent("Welcome to Bingo.com");

			Multipart mp = new MimeMultipart();
			MimeBodyPart bodyMessagePart = new MimeBodyPart();
			bodyMessagePart.setContent("body", "UTF-8");
			mp.addBodyPart(bodyMessagePart);

			message.setContent(mp);
			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}

	public void forgetPasswordEmail(UserBean user) {

	}
}
