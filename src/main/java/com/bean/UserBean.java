package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {

	private int userId;
	
	@NotBlank(message = "Please Enter FirstName")
	private String firstName;
	
	@NotBlank(message = "Please Enter Email")
	private String  email;
	
	@NotBlank(message = "Please Enter Password")
	private String password;

	private String profile;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
