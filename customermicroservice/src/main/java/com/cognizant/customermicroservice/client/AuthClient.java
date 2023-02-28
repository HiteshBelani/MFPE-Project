package com.cognizant.customermicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.customermicroservice.exception.UserNotFoundException;
import com.cognizant.customermicroservice.model.User;


@FeignClient(name="${auth.name}" , url="${auth.URL}")
public interface AuthClient {
	
	@PostMapping(value="/register")
	public User registerUser(@RequestBody User user);
	
	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	@GetMapping(value="/getuser/{userName}")
	public int getUserIdByUserName(@PathVariable("userName") String UserName) throws UserNotFoundException;
}
