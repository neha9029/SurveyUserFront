package com.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.user.entities.UserEntity;

public interface UserDao extends CrudRepository<UserEntity, Long>{
	
	UserEntity findUserByEmail(String email);
    UserEntity findUserByEmailAndEncryptedPassword(String email, String password);    
}
