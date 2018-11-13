package com.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.user.entities.UserEntity;
import com.user.modelRequest.RegisterRequest;

public interface UserService extends UserDetailsService {

	UserEntity findByEmail(String email);
	boolean checkEmailExists(String email);
    void saveUser(RegisterRequest registerDetails);
    boolean dbPassworMatchesUserPassword(String password ,String dbPassword );
    
}
