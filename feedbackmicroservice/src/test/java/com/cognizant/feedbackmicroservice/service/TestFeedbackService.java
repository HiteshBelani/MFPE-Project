package com.cognizant.feedbackmicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.feedbackmicroservice.client.ProductClient;
import com.cognizant.feedbackmicroservice.entity.Feedback;
import com.cognizant.feedbackmicroservice.exception.FeedbackNotFoundException;
import com.cognizant.feedbackmicroservice.exception.ProductNotFoundException;
import com.cognizant.feedbackmicroservice.model.Product;
import com.cognizant.feedbackmicroservice.model.ProductRating;
import com.cognizant.feedbackmicroservice.repository.FeedbackRepository;

public class TestFeedbackService {

	@Mock
	FeedbackRepository feedbackRepository;
	
	@Mock
	ProductClient productClient;
	
	@InjectMocks
	FeedbackService feedbackService;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetMyFeedbackByUserNameSuccess() throws FeedbackNotFoundException {
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.add(new Feedback(5,2,"Good",3.6,"Ramesh"));
		when(feedbackRepository.findByUserName("Ramesh")).thenReturn(feedbackList);
		assertThat(feedbackService.getMyFeedbackByUserName("Ramesh")).isEqualTo(feedbackList);
	}
	
	@Test
	public void testGetMyFeedbackByUserNameException() throws FeedbackNotFoundException {
		List<Feedback> feedbackList = new ArrayList<>();
		Assertions.assertThrows(FeedbackNotFoundException.class, 
		() -> {
			when(feedbackRepository.findByUserName("Ramesh")).thenReturn(feedbackList);
			assertThat(feedbackService.getMyFeedbackByUserName("Ramesh")).isEqualTo(feedbackList);
		});
			
	}
	
	@Test	
	public void testAddFeedbackSuccess() throws ProductNotFoundException {
		ProductRating productRating = new ProductRating();
		Feedback feedback = new Feedback(3,2,"Great Product",4.1,"Ramesh");
		Product product = new Product(2,"iphone 11", "APPLE", "Electronic", 38000, 4.8);
		double rating = 3.5;
		when(productClient.getProductById(2)).thenReturn(product);
		when(feedbackRepository.save(feedback)).thenReturn(feedback);
		when(feedbackRepository.calcualteAvgRating(5)).thenReturn(rating);
		when(productClient.updateRating(productRating)).thenReturn(product);
		assertNotNull(feedbackService.addFeedback(feedback));
	}
	
	@Test
	public void testAddFeedbackException() throws ProductNotFoundException{
		Feedback feedback = new Feedback();
		Assertions.assertThrows(ProductNotFoundException.class,
			()	-> {		
				when(productClient.getProductById(22)).thenReturn(null);
				assertNull(feedbackService.addFeedback(feedback));
			});
	}
	
	@Test
	public void testGetFeedbackByIdSuccess() throws FeedbackNotFoundException {
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackList.add(new Feedback(1,5,"Expensive",3.2,"Ramesh"));
		when(feedbackRepository.findByProductId(5)).thenReturn(feedbackList);
		assertNotNull(feedbackService.getFeedbackById(5));
	}
	
	@Test
	public void testGetFeedbackByIdException() throws FeedbackNotFoundException {
		List<Feedback> feedbackList = new ArrayList<>();
		Assertions.assertThrows(FeedbackNotFoundException.class, 
		() -> {
			when(feedbackRepository.findByProductId(5)).thenReturn(feedbackList);
			assertThat(feedbackService.getFeedbackById(5)).isEqualTo(feedbackList);
		});
			
	}
}
