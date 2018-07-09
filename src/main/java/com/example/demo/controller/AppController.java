package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 请求代理端
 * @author PC
 *
 */
@RestController
@RequestMapping
public class AppController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/app")
	public String getResult(){
		String url = "http://eureka-client/world";
		return restTemplate.getForObject(url, String.class);
		
	}
}
