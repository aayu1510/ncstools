package com.concretepage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {  
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }       
	
	
}            