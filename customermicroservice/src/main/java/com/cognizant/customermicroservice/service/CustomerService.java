package com.cognizant.customermicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.customermicroservice.client.AuthClient;
import com.cognizant.customermicroservice.entity.Customer;
import com.cognizant.customermicroservice.exception.CustomerNotFoundException;
import com.cognizant.customermicroservice.exception.TokenExpiredException;
import com.cognizant.customermicroservice.exception.UserNotFoundException;
import com.cognizant.customermicroservice.model.CustInfo;
import com.cognizant.customermicroservice.model.User;
import com.cognizant.customermicroservice.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AuthClient authClient;
	
	@Transactional
	public Customer updatecustomer(Customer customer , String token) throws CustomerNotFoundException, TokenExpiredException {
		
		if(authClient.authorizeTheRequest(token) == true) {
			Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
			if(customer1 != null) {
				return customerRepository.save(customer);
			}
			else {
				throw new CustomerNotFoundException("Customer with given Id not Found");
			}
		}
		else {
			throw new TokenExpiredException("Token Expired");
		}
	}
	
	
	@Transactional
	public Customer getCustomer(String userName,String token) throws CustomerNotFoundException, TokenExpiredException, UserNotFoundException{
		if(authClient.authorizeTheRequest(token) == true) {
			int id = authClient.getUserIdByUserName(userName);
			Customer customer = customerRepository.findById(id).orElse(null);
			if(customer != null) {
				return customer;
			}
			else {
				throw new CustomerNotFoundException("Customer with given Id not Found");
			}
		}
		else {
			throw new TokenExpiredException("Token Expired");
		}
		
	}
	
	@Transactional
	public Customer registercustomer(CustInfo custInfo) {
		Customer customer = new Customer();
		customer.setAddress(custInfo.getAddress());
		customer.setEmailId(custInfo.getEmailId());
		customer.setName(custInfo.getName());
		customer.setPhoneNo(custInfo.getPhoneNo());
		customer = customerRepository.save(customer);
		User user = new User();
		user.setId(customer.getId());
		user.setUserName(custInfo.getUserName());
		user.setPassword(custInfo.getPassword());
		user = authClient.registerUser(user);
		return customer;
	}
}
