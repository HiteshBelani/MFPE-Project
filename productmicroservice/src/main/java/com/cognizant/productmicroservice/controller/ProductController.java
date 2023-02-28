package com.cognizant.productmicroservice.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.productmicroservice.entity.Product;
import com.cognizant.productmicroservice.exception.ProductNotFoundException;
import com.cognizant.productmicroservice.model.ProductRating;
import com.cognizant.productmicroservice.repository.ProductRepository;
import com.cognizant.productmicroservice.service.ProductService;
 @CrossOrigin
 @RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping(value="/products/getlowestratedproducts")
	public List<Product> getLowestRatedProducts() throws ProductNotFoundException{
		logger.info("start getLowestRatedProducts() method");
		logger.info("End of getLowestRatedProducts() method");
		return productService.getLowestRatedProducts();
	}
	
	@GetMapping(value="/products/gethighestratedproducts")
	public List<Product> getHighestRatedProducts() throws ProductNotFoundException{
		logger.info("start getHighestRatedProducts() method");
		logger.info("End of getHighestRatedProducts() method");
		return productService.getHighestRatedProducts();
	}
	
	
	@GetMapping(value="/productcategory/{category}")
	public List<Product> getProductByCategory(@PathVariable("category") String category) throws ProductNotFoundException{
		logger.info("start getProductByCategory() method");
		List<Product> productlist = productService.getProductByCategory(category);
		logger.info("End of getProductByCategory() method");
		return productlist;
	}
	
	@GetMapping(value="/products/{company_name}")
	public List<Product> getProductByCompanyName(@PathVariable("company_name") String company_name) throws ProductNotFoundException{
		logger.info("start getProductByCompanyName() method");
		logger.info("End of getProductByCompanyName() method");
		List<Product> productlist = productService.getProductByCompanyName(company_name);
		return productlist;
	}
	
	
	@GetMapping(value = "/products")
	public List<Product> getAllProducts(){
		logger.info("Inside getAllProducts() method");
		logger.info("End of getAllProducts() method");
		return productService.getAllProducts();
		
	}
	
	@GetMapping(value="/product/{id}")
	public Product getProductById(@PathVariable("id") int id) throws ProductNotFoundException{
		logger.info("start getProductById() method");
		logger.info("End of getProductById() method");
		Product product = productService.getProductById(id);
		return product;
	}
	
	@GetMapping(value="/productname/{product_name}")
	public Product getProductByName(@PathVariable("product_name") String product_name) throws ProductNotFoundException{
		logger.info("start getProductByName() method");
		logger.info("End of getProductByName() method");
		Product product = productService.getProductByName(product_name);
		return product;
	}
	
	@PutMapping(value="/updaterating")
	public Product updateRating(@RequestBody ProductRating productRating) throws ProductNotFoundException {
		logger.info("updateRating() start");
		logger.info("updateRating() End");
		return productService.updateRating(productRating);
	}
}
