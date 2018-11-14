package com.user.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.user.dao.UserDao;
import com.user.dao.UserDto;
import com.user.entities.UserEntity;
import com.user.modelResponse.RegisterResponse;
import com.user.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/users")
		public List<RegisterResponse> getUsers() {
	    
		List<RegisterResponse> userResponse = new ArrayList<>();
		
		List<UserDto> users =  userService.getUsers();
		
		for(UserDto userDto: users) {
			RegisterResponse registerResponse = new RegisterResponse();
			BeanUtils.copyProperties(userDto, registerResponse);
			userResponse.add(registerResponse);
		}
		  return userResponse;
	}
	


}
