package com.user.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.user.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/",
			"/error/**",
			"/register",
			"/profile",
			"/login"

};

	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http
 		.authorizeRequests()
        .antMatchers("/**").permitAll();

 		
	}

	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
}
