package com.cognizant.customermicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.customermicroservice.client.AuthClient;
import com.cognizant.customermicroservice.entity.Customer;
import com.cognizant.customermicroservice.exception.CustomerNotFoundException;
import com.cognizant.customermicroservice.exception.TokenExpiredException;
import com.cognizant.customermicroservice.exception.UserNotFoundException;
import com.cognizant.customermicroservice.model.CustInfo;
import com.cognizant.customermicroservice.model.User;
import com.cognizant.customermicroservice.repository.CustomerRepository;

public class TestCustomerService {
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	Customer customer;
	
	@Mock
	User user;
	
	@Mock
	CustInfo custInfo;
	
	@InjectMocks
	CustomerService customerService;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRegistercustomerSuccess() {
		CustInfo custInfo = new CustInfo(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra",
		"Ramesh","ramesh@1234"); 
		Customer customer = new Customer(); 
		user = new User();
		customer.setAddress(custInfo.getAddress());
		customer.setEmailId(custInfo.getEmailId());
		customer.setName(custInfo.getName());
		customer.setPhoneNo(custInfo.getPhoneNo());
		customer.setId(1);
		when(customerRepository.save(customer)).thenReturn(customer);
		user.setId(customer.getId());
		user.setUserName(custInfo.getUserName());
		user.setPassword(custInfo.getPassword());
		when(authClient.registerUser(user)).thenReturn(user);
		assertNotNull(customerService.registercustomer(custInfo));
		
	}
	
	@Test
	public void testGetCustomerSuccess() throws CustomerNotFoundException, TokenExpiredException, UserNotFoundException
	{
		Customer customer = new Customer();
		when(authClient.authorizeTheRequest(anyString())).thenReturn(true);
		when(authClient.getUserIdByUserName("Suresh")).thenReturn(1);
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		assertNotNull(customerService.getCustomer("Suresh", anyString()));
	}
	
	@Test
	public void testGetCustomerException() throws CustomerNotFoundException, TokenExpiredException{
		Assertions.assertThrows(CustomerNotFoundException.class,
			() -> {
				when(authClient.authorizeTheRequest("token")).thenReturn(true);
				when(authClient.getUserIdByUserName("Suresh")).thenReturn(4);
				when(customerService.getCustomer("Suresh","token")).thenReturn(null);
				assertNull(customerService.getCustomer("Suresh", "token"));
			});
		
	}
	
	@Test
	public void testGetCustomerToken() throws CustomerNotFoundException, TokenExpiredException{
		Customer customer = new Customer();
		Assertions.assertThrows(TokenExpiredException.class,
				() -> {
					when(authClient.getUserIdByUserName("Suresh")).thenReturn(4);
					when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
					assertThat(customerService.getCustomer("Suresh", null)).isEqualTo(customer);
				});
			
	}
	
	
	@Test
	public void testUpdateCustomer() throws CustomerNotFoundException, TokenExpiredException{
		Customer customer = new Customer(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra");
		when(authClient.authorizeTheRequest(anyString())).thenReturn(true);
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		when(customerRepository.save(customer)).thenReturn(customer);
		assertNotNull(customerService.updatecustomer(customer, anyString()));
	}
	
	
	@Test
	public void testUpdateCustomerException() throws CustomerNotFoundException, TokenExpiredException{
		Customer customer = new Customer(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra");
		Assertions.assertThrows(CustomerNotFoundException.class,
			() -> {
				when(authClient.authorizeTheRequest(anyString())).thenReturn(true);
				when(customerRepository.findById(4).orElse(null)).thenReturn(null);
				assertThat(customerService.updatecustomer(customer, anyString())).isEqualTo(null);
			});
		
	}
	
	@Test
	public void testUpdateCustomerToken() throws CustomerNotFoundException, TokenExpiredException{
		Customer customer = new Customer(1,"Ramesh","ramesh@gmail.com","9658214378","Mumbai,Maharashtra");
		Assertions.assertThrows(TokenExpiredException.class,
				() -> {
					when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
					assertThat(customerService.updatecustomer(customer, null)).isEqualTo(customer);
				});
			
	}
	
}
