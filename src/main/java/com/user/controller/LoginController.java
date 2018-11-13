package com.user.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
	public String postLogin(@Valid @ModelAttribute("loginDetails") Login userloginDetails, BindingResult bindingResultLogin) {
		if(bindingResultLogin.hasErrors()) {
		    return "login";
		}

		if(!userService.checkEmailExists(userloginDetails.getEmail())){
		    bindingResultLogin.rejectValue("email", "error.loginDetails", "Email not found, Please Register");
		}
		
		//getting userDetails by user's email
		UserDetails userDetails = userService.loadUserByUsername(userloginDetails.getEmail());

        //Using Authentication to get password from dbPassword
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
  
	    String dbPassword = (String) authentication.getCredentials();
	    

	    //Validation if invalid password
	    if (!userService.dbPassworMatchesUserPassword(userloginDetails.getPassword(),dbPassword)) {
		    bindingResultLogin.rejectValue("password", "error.loginDetails", "Invalid Password");	
	    }
		
	    if(bindingResultLogin.hasErrors()) {
			return "login";
		}
		else {
			return "profile";
		}
	}

	
}
