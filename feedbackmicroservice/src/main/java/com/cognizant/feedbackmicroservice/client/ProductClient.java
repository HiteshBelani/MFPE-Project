package com.cognizant.feedbackmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.feedbackmicroservice.exception.ProductNotFoundException;
import com.cognizant.feedbackmicroservice.model.Product;
import com.cognizant.feedbackmicroservice.model.ProductRating;

@FeignClient(name="${product.name}" , url="${product.URL}")
public interface ProductClient {

	@GetMapping(value="/product/{id}")
	public Product getProductById(@PathVariable("id") int id);
	
	@PutMapping(value="/updaterating")
	public Product updateRating(@RequestBody ProductRating productRating) throws ProductNotFoundException; 
}
