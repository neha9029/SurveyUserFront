package com.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.user.entities.UserEntity;
import com.user.modelRequest.RegisterRequest;

public interface UserService extends UserDetailsService {

	UserEntity findByEmail(String email);
	boolean checkEmailExists(String email);
	boolean checkUserExists(String email,String password);
    void saveUser(RegisterRequest registerDetails);
    
}
