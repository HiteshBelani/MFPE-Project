package com.cognizant.customermicroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.customermicroservice.entity.Customer;
import com.cognizant.customermicroservice.exception.CustomerNotFoundException;
import com.cognizant.customermicroservice.exception.TokenExpiredException;
import com.cognizant.customermicroservice.exception.UserNotFoundException;
import com.cognizant.customermicroservice.model.CustInfo;
import com.cognizant.customermicroservice.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PutMapping(value = "/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer, @RequestHeader(value = "Authorization") String token)
			throws CustomerNotFoundException, TokenExpiredException {
		logger.info("Start updateCustomer() method");
		Customer customer1 = customerService.updatecustomer(customer, token);
		logger.info("Customer Details updated");
		logger.info("End updateCustomer() method");
		return customer1;
	}

	@GetMapping(value = "/getcustomer/{userName}")
	public Customer getCustomer(@PathVariable("userName") String userName , @RequestHeader(value = "Authorization") String token) throws CustomerNotFoundException, TokenExpiredException, UserNotFoundException {
		logger.info("Start getCustomer() method");
		Customer customer = customerService.getCustomer(userName,token);
		logger.info("Customers : - {}", customer);
		logger.info("End getCustomer() method");
		return customer;
	}

	@PostMapping(value = "/registercustomer")
	public Customer registerCustomer(@RequestBody CustInfo custInfo) {
		logger.info("Start registerCustomer() method");
		Customer cust = customerService.registercustomer(custInfo);
		logger.info("Customer Details : - {}", cust);
		logger.info("End registerCustomer() method");
		return cust;
	}

}
