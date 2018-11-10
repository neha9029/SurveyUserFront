package com.user.modelRequest;

public class RegisterRequest {
	
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String accountType;
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
	
	

}
