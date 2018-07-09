package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class RibbonBalanceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RibbonBalanceApplication.class, args);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String port = environment.getProperty("server.port");
		System.out.println("***********************************************");
		System.out.println("		Eureka-Client:");
		System.out.println("		http://localhost:" + port);
		System.out.println("		is OK");
		System.out.println("***********************************************");
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
		
	}
}
