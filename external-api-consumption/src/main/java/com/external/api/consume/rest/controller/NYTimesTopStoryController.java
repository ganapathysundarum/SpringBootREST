package com.external.api.consume.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.external.api.consume.rest.model.IfscBean;
import com.external.api.consume.rest.model.TopStoryBean;

@RestController
public class NYTimesTopStoryController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${nytimes.topstory.key}")
	private String apiKey;
	
	@GetMapping(path = "/nytimes/topstories")
	public TopStoryBean readTopStories(){
		TopStoryBean bean = null;
		try{
			System.out.println("apiKey="+apiKey);
			String url = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key="+apiKey;
			
			bean = restTemplate.getForObject(url, TopStoryBean.class);			
			//System.out.println(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}

}
