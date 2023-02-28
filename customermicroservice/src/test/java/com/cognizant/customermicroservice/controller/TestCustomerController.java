package com.cognizant.customermicroservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.customermicroservice.entity.Customer;
import com.cognizant.customermicroservice.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCustomerController {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CustomerService customerService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void testRegisterCustomer() throws Exception {
		Customer customer = new Customer(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra");
		String jsonRequest = objectMapper.writeValueAsString(customer);
		this.mockMvc.perform(post("/registercustomer").content(jsonRequest)
		.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
	}
	
	@Test
	public void testGetCustomer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/getcustomer/4")
				.header("Authorization","@Authorization"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateCustomer() throws Exception {
		Customer customer = new Customer(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra");
		String jsonRequest = objectMapper.writeValueAsString(customer);
		this.mockMvc.perform(put("/updatecustomer").content(jsonRequest)
				.header("Authorization","@Authorization")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
	}
}
