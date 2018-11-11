package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.user.modelRequest.Login;
import com.user.modelRequest.RegisterRequest;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String getRegister(Model model) {
		Login loginRequest = new Login();
		model.addAttribute("loginDetails", loginRequest);
		return "login";
		
	}
	
}
