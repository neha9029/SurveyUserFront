package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.dao.UserDto;
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
	 
	 	 
	 
	//Checking if email already exists in the database
	public boolean checkEmailExists(String email) {
		if(findByEmail(email) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//Verify whether database Password matches and password entered by user while login
	@Override
	public boolean dbPassworMatchesUserPassword(String password,String dbPassword) {
	   if(bCryptPasswordEncoder.matches(password, dbPassword)) {
		   return true;
	   }
	   else {
		   return false;
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

	
	//Method to get dbPassword and other details
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        UserEntity userEntity = userDao.findUserByEmail(email);
		
		if(null == userEntity) {
			throw new UsernameNotFoundException("Username not found");
		}
		
				//return  new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	    return userEntity;
	
	}



	@Override
	public List<UserDto> getUsers() {
		// TODO Auto-generated method stub
		
		List<UserDto> returnValue = new ArrayList<>();
		Iterable<UserEntity> userEntity= userDao.findAll();
		
		for(UserEntity userEntityDetails: userEntity) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntityDetails, userDto);
			returnValue.add(userDto);
		}
		return returnValue;
	}




	



	
	
	

}
