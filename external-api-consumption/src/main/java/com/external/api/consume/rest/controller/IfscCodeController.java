package com.external.api.consume.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.external.api.consume.rest.model.IfscBean;

@RestController
public class IfscCodeController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "/ifsc/{ifscCode}")
	public IfscBean retrieveDetailsByIFSC(@PathVariable String ifscCode){
		IfscBean ifscList = null;
		try{
			System.out.println("IFSC Code : "+ifscCode);
			String url = "https://ifsc.razorpay.com/"+ifscCode;
			
			ifscList = restTemplate.getForObject(url, IfscBean.class);			
			System.out.println(ifscList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ifscList;
	}

}
