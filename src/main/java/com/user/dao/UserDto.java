package com.user.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserDto implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = -5550397243269915009L;

	private long id;
	
	private String userId;
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String encryptedPassword;
	
	private String accountType;
	
	private boolean terms;

	private int percentile;
	
	public int getPercentile() {
		return percentile;
	}

	public void setPercentile(int percentile) {
		this.percentile = percentile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
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
