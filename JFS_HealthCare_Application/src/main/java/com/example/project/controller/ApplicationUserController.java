package com.example.project.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.ApplicationUser;
import com.example.project.jwt.JwtAuthenticationRestController;
import com.example.project.jwt.JwtTokenRequest;
import com.example.project.service.ApplicationUserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@CrossOrigin("*")
@RestController
public class ApplicationUserController {
	
	private Logger log=LoggerFactory.getLogger(ApplicationUserController.class);

	@Autowired
	private ApplicationUserService service;
	
	@Autowired
	private JwtAuthenticationRestController jwtController;
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, consumes = "application/json")
	public String createRegistration(@RequestBody ApplicationUser model){
		String message = "";
		try{			
			message = service.createNewUser(model);
			log.info("Registration for the user - ["+model.getUser_name()+"] is created...!");
						
		}catch(Exception e){
			e.printStackTrace();
			message = "Password or username policy failed";
		}	
		return message;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public List<ApplicationUser> findAllAppUsers(){
		List<ApplicationUser> list = null;
		try{			
			list = service.findAllApplicationUsers();
			log.info("List of ApplicationUser is - ["+list.size()+"] ");
						
		}catch(Exception e){
			e.printStackTrace();			
		}	
		return list;
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public ResponseEntity<?> validateSignin(@RequestBody ApplicationUser model){
		/*String message  = "";
		try{		*/	
			String message = service.findByUserName(model.getUser_name(), model.getPassword());
			log.info("returned message = "+message);
			JwtTokenRequest request = new JwtTokenRequest();
			request.setUsername("in28minutes");
			request.setPassword("dummy");
			return jwtController.createAuthenticationToken(request);			
		/*}catch(Exception e){
			e.printStackTrace();			
		}	*/
		//return message;
	}
	
}
