package com.cognizant.feedbackmicroservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.feedbackmicroservice.client.ProductClient;
import com.cognizant.feedbackmicroservice.entity.Feedback;
import com.cognizant.feedbackmicroservice.exception.FeedbackNotFoundException;
import com.cognizant.feedbackmicroservice.exception.ProductNotFoundException;
import com.cognizant.feedbackmicroservice.model.Product;
import com.cognizant.feedbackmicroservice.model.ProductRating;
import com.cognizant.feedbackmicroservice.repository.FeedbackRepository;


@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	ProductClient productClient;
	
	@Transactional
	public Feedback addFeedback(Feedback feedback) throws ProductNotFoundException {
		ProductRating productRating = new ProductRating();
		Product product = productClient.getProductById(feedback.getProductId());
		if(product != null) {
			productRating.setProductId(feedback.getProductId());
			feedback.setProductName(product.getProductName());
			Feedback feedback1 = feedbackRepository.save(feedback);
			double rating = feedbackRepository.calcualteAvgRating(feedback.getProductId());
			rating = Math.round(rating*10.0)/10.0;
			productRating.setRating(rating);
			product = productClient.updateRating(productRating);
			return feedback1;
		}
		else {
			throw new ProductNotFoundException("Feedback cannot be added since the product with the given ID does not exists.");
		}	
	}
	
	@Transactional
	public List<Feedback> getFeedbackById(int id) throws FeedbackNotFoundException{
		List<Feedback> feedbacklist = feedbackRepository.findByProductId(id);
		if(feedbacklist.isEmpty() == false) {
			return feedbacklist;
		}
		else {
			throw new FeedbackNotFoundException("No Feedback was found for the given Product");
		}
	}

	@Transactional
	public List<Feedback> getMyFeedbackByUserName(String userName) throws FeedbackNotFoundException {
		List<Feedback> feedbacklist = feedbackRepository.findByUserName(userName);
		if(feedbacklist.isEmpty() == false) {
			return feedbacklist;
		}
		else {
			throw new FeedbackNotFoundException("No Feedback was found for the given Product");
		}
	}
}
