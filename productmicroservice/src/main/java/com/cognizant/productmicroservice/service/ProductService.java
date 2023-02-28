package com.cognizant.productmicroservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.productmicroservice.entity.Product;
import com.cognizant.productmicroservice.exception.ProductNotFoundException;
import com.cognizant.productmicroservice.model.ProductRating;
import com.cognizant.productmicroservice.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public List<Product> getLowestRatedProducts(){
		return productRepository.getLowestRatedProducts();
	}
	
	@Transactional
	public List<Product> getHighestRatedProducts(){
		return productRepository.getHighestRatedProducts();
	}
	
	@Transactional
	public List<Product> getProductByCategory(String category) throws ProductNotFoundException{
		List<Product> productList = productRepository.findByCategory(category);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Products of given Category not Found");
		}
		else {
			return productList;
		}
	}
	
	@Transactional
	public List<Product> getProductByCompanyName(String company_name) throws ProductNotFoundException{
		List<Product> productList = productRepository.findByCompanyName(company_name);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Products of given Company not Found");
		}
		else {
			return productList;
		}
	}
	
	@Transactional
	public Product getProductByName(String product_name) throws ProductNotFoundException {
		Product product = productRepository.findByName(product_name);
		if(product != null) {
			return product;
		}
		else {
			throw new ProductNotFoundException("Product with given name not Found");
		}
	}
	
	@Transactional
	public Product getProductById(int id) throws ProductNotFoundException {
		Product product = productRepository.findById(id).orElse(null);
		if(product != null) {
			return product;
		}
		else {
			throw new ProductNotFoundException("Product with given Id not Found");
		}
	}
	
	@Transactional
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@Transactional
	public Product updateRating(ProductRating productRating) throws ProductNotFoundException {
		Product product = productRepository.findById(productRating.getProductId()).orElse(null);
		if(product != null) {
			product.setRating(productRating.getRating());
			return productRepository.save(product);
		}
		else {
			throw new ProductNotFoundException("Product With given ID not Found");
		}
		
	}
	
}
