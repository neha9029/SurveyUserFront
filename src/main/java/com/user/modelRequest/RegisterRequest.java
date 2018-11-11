package com.user.modelRequest;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class RegisterRequest {
	
	@NotEmpty(message="Please enter First Name")
	private String firstName;
	
	@NotEmpty(message="Please enter Last Name")
	private String lastName;
	
	@NotEmpty(message="Please enter your Email Id")
	@Email(message="Enter valid email")
	private String email;
	
	@NotEmpty(message="Enter password")
	//@Size(min = 4, message="Enter atleast 4 letter password")
	private String password;
	
	@NotEmpty(message="Enter password again")
	private String confirmPassword;
	
	private String accountType;
	
	
	@AssertTrue(message="Please accept terms")
	private boolean terms;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public boolean isTerms() {
		return terms;
	}
	public void setTerms(boolean terms) {
		this.terms = terms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
