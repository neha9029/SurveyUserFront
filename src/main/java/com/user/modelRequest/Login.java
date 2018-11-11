package com.user.modelRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
	
	
	@NotNull(message="Please enter your Email Id")
	@Email(message="Enter valid email")
	private String email;
	
	@NotNull(message="Please enter password")
	private String password;
	
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
	
	

}
