package com.user.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.modelRequest.RegisterRequest;

@Controller
public class RegisterController {

	
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		RegisterRequest registerRequest = new RegisterRequest();
		model.addAttribute("registerDetails", registerRequest);
		return "register";
	}
	
	@PostMapping("/register")
	public String RegisterPost(@Valid @ModelAttribute("registerDetails") RegisterRequest registerRequest, BindingResult bindingResult ) {
		
		System.out.println(bindingResult.hasErrors());
		System.out.println("email" +registerRequest.getEmail());

		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		else {
			return "redirect:/login";
		}
		
	}
	
	
	
	
	
}
	

