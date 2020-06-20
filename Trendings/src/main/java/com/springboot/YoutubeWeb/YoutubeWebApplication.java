package com.springboot.YoutubeWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class YoutubeWebApplication extends SpringBootServletInitializer{
	
	 @Override
	    protected SpringApplicationBuilder configure(
	      SpringApplicationBuilder builder) {
	        return builder.sources(YoutubeWebApplication.class);
	    }
	 
    public static void main(String[] args) {
        SpringApplication.run(YoutubeWebApplication.class, args);
    }
}