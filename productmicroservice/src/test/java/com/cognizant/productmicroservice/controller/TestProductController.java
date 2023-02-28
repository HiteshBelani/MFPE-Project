package com.cognizant.productmicroservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.productmicroservice.model.ProductRating;
import com.cognizant.productmicroservice.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TestProductController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ProductService productService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void testGetAllProducts() throws Exception {
		this.mockMvc.perform(get("/products")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetProductById() throws Exception {
		this.mockMvc.perform(get("/product/4")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetProductByName() throws Exception {
		this.mockMvc.perform(get("/productname/C30")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetProductByCompanyName() throws Exception {
		this.mockMvc.perform(get("/products/APPLE")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetProductByCategory() throws Exception {
		this.mockMvc.perform(get("/productcategory/Fashion")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetHighestRatedProducts() throws Exception {
		this.mockMvc.perform(get("/products/gethighestratedproducts")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetLowestRatedProduct() throws Exception {
		this.mockMvc.perform(get("/products/getlowestratedproducts")).andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateRating() throws Exception {
		ProductRating productRating = new ProductRating(4,4.2);
		String jsonRequest = objectMapper.writeValueAsString(productRating);
		this.mockMvc.perform(put("/updaterating").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	}
	
	
}
