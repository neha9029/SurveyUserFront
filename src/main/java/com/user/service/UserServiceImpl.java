package com.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.entities.UserEntity;
import com.user.modelRequest.RegisterRequest;
import com.user.securityConfig.RandomKey;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	RandomKey randomKey;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	//Finding User by Email
	 public UserEntity findByEmail(String email) {
		 
		return userDao.findUserByEmail(email);
	 }
	 
	 
	 public UserEntity findByEmailAndPassword(String email, String password) {
		 			
		 return userDao.findUserByEmailAndEncryptedPassword(email, bCryptPasswordEncoder.encode(password));
	 }
	 
	 
	//Checking if email already exists in the database
	public boolean checkEmailExists(String email) {
		if(findByEmail(email) != null) {
			System.out.println(findByEmail(email));
			return true;
		}
		else {
			System.out.println(findByEmail(email));
			return false;
		}
	}
	
	
	//Check user exits in database by email and password
	public boolean checkUserExists(String email,String password) {		
		
		if(findByEmail(email) == null) {
			return false;
		}
		else if(findByEmailAndPassword(email, password) == null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	//Saving user Details to Database
	public void saveUser(RegisterRequest registerDetails) {
		UserEntity userEntity = new UserEntity();
		
		//Copy all the properties from registerDetails to userEntity
		BeanUtils.copyProperties(registerDetails, userEntity);

		//generated Random string to be used as user id for passing as requestParams or Path Variables
		String publicUserId = randomKey.generateUserId(30);
		userEntity.setUserId(publicUserId);
		
		//Used BCrypt to encode password before storing to database;
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(registerDetails.getPassword()));
		userDao.save(userEntity);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	

}
