package com.cognizant.feedbackmicroservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.feedbackmicroservice.entity.Feedback;
import com.cognizant.feedbackmicroservice.service.FeedbackService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TestFeedbackController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	FeedbackService feedbackService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void testaddProductFeedback() throws Exception {
		Feedback feedback = new Feedback(1,2,"Good",3.9,"Ramesh");
		String jsonRequest = objectMapper.writeValueAsString(feedback);
		this.mockMvc.perform(post("/addfeedback").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	}
	
	@Test
	public void testGetFeedbackById() throws Exception {
		this.mockMvc.perform(get("/getfeedback/4")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetMyFeedbackByUserName() throws Exception {
		this.mockMvc.perform(get("/getmyfeedback/Suresh")).andExpect(status().isOk());
	}
	
}
