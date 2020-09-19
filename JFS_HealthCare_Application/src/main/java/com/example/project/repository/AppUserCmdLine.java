package com.example.project.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.project.Model.ApplicationUser;
import com.example.project.controller.ApplicationUserController;

@Component
public class AppUserCmdLine implements CommandLineRunner {
	
	private Logger log=LoggerFactory.getLogger(AppUserCmdLine.class);
	
	@Autowired
	private ApplicationUserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new ApplicationUser("admin1","admin1@test.com","admin1","123213123123","Chennai1"));
		repo.save(new ApplicationUser("admin2","admin2@test.com","admin2","223213123123","Chennai2"));
		repo.save(new ApplicationUser("admin3","admin3@test.com","admin3","323213123123","Chennai3"));
		repo.save(new ApplicationUser("admin4","admin4@test.com","admin4","423213123123","Chennai4"));
		log.info("Application User created ..!");
	}

}

