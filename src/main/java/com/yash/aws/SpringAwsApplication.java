package com.yash.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringAwsApplication extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringAwsApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsApplication.class, args);
	}
	
}
