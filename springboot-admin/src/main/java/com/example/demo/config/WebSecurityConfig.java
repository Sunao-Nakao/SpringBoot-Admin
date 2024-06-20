package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
	
	
	private final String USRANAME_PARAMETER = "email";
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http
		.authorizeHttpRequests(
				authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
					.anyRequest().authenticated())
		
		.formLogin(
				login -> login.loginPage(UrlConst.SIGNIN)
					.usernameParameter(USRANAME_PARAMETER)
					.defaultSuccessUrl(UrlConst.CONTACTS));
		
	
		
		return http.build();
	}
	

}
