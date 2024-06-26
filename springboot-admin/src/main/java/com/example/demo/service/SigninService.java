package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admins;



/** サインイン画面 Service **/
@Service
public interface SigninService {

	Optional<Admins> searchUserByEmail(String email);
	
}
