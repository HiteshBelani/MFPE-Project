package com.cognizant.feedbackmicroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feedbackmicroservice.entity.Feedback;
import com.cognizant.feedbackmicroservice.exception.FeedbackNotFoundException;
import com.cognizant.feedbackmicroservice.exception.ProductNotFoundException;
import com.cognizant.feedbackmicroservice.service.FeedbackService;

@RestController
@CrossOrigin
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@PostMapping(value  = "/addfeedback")
	public Feedback addProductFeedback(@RequestBody Feedback feedback) throws ProductNotFoundException {
		logger.info("addProductFeedback() start");
		logger.info("addProductFeedback() End");
		return feedbackService.addFeedback(feedback);
	}
	
	@GetMapping(value = "/getfeedback/{product_id}")
	public List<Feedback> getFeedbackById(@PathVariable("product_id") int id) throws FeedbackNotFoundException{
		 return feedbackService.getFeedbackById(id);
		
	}
	
	@GetMapping(value = "/getmyfeedback/{userName}")
	public List<Feedback> getMyFeedbackByUserName(@PathVariable("userName") String userName) throws FeedbackNotFoundException{
		 return feedbackService.getMyFeedbackByUserName(userName);
		
	}
}
