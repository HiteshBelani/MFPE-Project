package com.cognizant.feedbackmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeedbackmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackmicroserviceApplication.class, args);
	}

}
