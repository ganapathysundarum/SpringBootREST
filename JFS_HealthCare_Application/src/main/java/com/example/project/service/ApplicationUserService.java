package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.project.Model.ApplicationUser;
import com.example.project.controller.ApplicationUserController;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.security.JwtUtil;



@Service
public class ApplicationUserService {
	
	private Logger log=LoggerFactory.getLogger(ApplicationUserController.class);
	
	@Autowired
	private ApplicationUserRepository repo;
	
	public String createNewUser(@RequestBody ApplicationUser user){
		String msg = "Password or username policy failed";
		try{
			repo.save(user);
			msg="Registration successful";
		}catch(Exception e){
			msg = "Password or username policy failed";
			e.printStackTrace();			
		}
		return msg;
	}
	
	public List<ApplicationUser> findAllApplicationUsers(){
		List<ApplicationUser> list = null;
		try{
			
			list = repo.findAll();
			
		}catch(Exception e){
			e.printStackTrace();			
		}
		return list;
	}
	
	public String findByUserName(String user_name, String password){
		String message = "Username or Password is Incorrect.";
		try{
			
			Optional<ApplicationUser> user = repo.findById(user_name);
			ApplicationUser finalUser = user.get();		
			log.info(finalUser.toString());
			if(finalUser.getUser_name().equals(user_name) && finalUser.getPassword().equals(password)){
				message = "Authentication successful!";
			}			
			
		}catch(Exception e){
			e.printStackTrace();			
			message = "Username or Password is Incorrect.";
		}
		log.info(message);
		return message;
	}
}

