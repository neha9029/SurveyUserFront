package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.user.modelRequest.RegisterRequest;
import com.user.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		RegisterRequest registerRequest = new RegisterRequest();
		model.addAttribute("registerDetails", registerRequest);
		return "register";
	}
	
	@PostMapping("/register")
	public String RegisterPost(@Valid @ModelAttribute("registerDetails") RegisterRequest registerRequest, BindingResult bindingResult ) {
		

		if(userService.checkEmailExists(registerRequest.getEmail())) {
			bindingResult.rejectValue("email", "error.registerDetails", "Email Exists");
		}
		if(bindingResult.hasErrors()) {
			return "register";
		}
	
		else {
			userService.saveUser(registerRequest);
			return "redirect:/login";
		}
		
	}
	
	
	
	
	
	
	
}
	

