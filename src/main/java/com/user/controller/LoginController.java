package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.modelRequest.Login;
import com.user.service.UserService;

@Controller
public class LoginController {

	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		Login loginRequest = new Login();
		model.addAttribute("loginDetails", loginRequest);
		return "login";
		
	}
	
	@PostMapping("/login")
	public String postLogin(@Valid @ModelAttribute("loginDetails") Login userloginDetails, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
				return "login";
		 }
		
		if(!userService.checkEmailExists(userloginDetails.getEmail())){
		    bindingResult.rejectValue("email", "error.loginDetails", "Email not found, Please Register");
		}
	
		else if(!userService.checkUserExists(userloginDetails.getEmail(), userloginDetails.getPassword())){
			bindingResult.rejectValue("email", "email.loginDetails", "Invalid password");

		}
		
	    if(bindingResult.hasErrors()) {
			return "login";
		}
		else {
			return "register";
		}
		
		
	}
}
