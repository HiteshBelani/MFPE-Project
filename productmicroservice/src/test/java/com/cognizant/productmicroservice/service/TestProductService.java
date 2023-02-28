package com.cognizant.productmicroservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.productmicroservice.entity.Product;
import com.cognizant.productmicroservice.exception.ProductNotFoundException;
import com.cognizant.productmicroservice.model.ProductRating;
import com.cognizant.productmicroservice.repository.ProductRepository;

public class TestProductService {

	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testupdateRatingException() throws ProductNotFoundException{
		ProductRating productRating = new ProductRating();
		Assertions.assertThrows(ProductNotFoundException.class,
			()	-> {		
				when(productRepository.findById(1).orElse(null)).thenReturn(null);	
				assertNull(productService.updateRating(productRating));
			});
	}
	
	@Test
	public void testupdateRatingSuccess() throws ProductNotFoundException {
		Product product = new Product();
		ProductRating productRating = new ProductRating(1,4.5);
		when(productRepository.findById(1)).thenReturn(Optional.of(product));
		product.setRating(productRating.getRating());
		when(productRepository.save(product)).thenReturn(product);
		assertNotNull(productService.updateRating(productRating));
	}
	
	@Test
	public void testgetLowestRatedProducts() {
		List<Product> products = new ArrayList<>();
		when(productRepository.getLowestRatedProducts()).thenReturn(products);
		assertNotNull(productService.getLowestRatedProducts());
	}
	
	@Test
	public void testgetHighestRatedProducts() {
		List<Product> products = new ArrayList<>();
		when(productRepository.getHighestRatedProducts()).thenReturn(products);
		assertNotNull(productService.getHighestRatedProducts());
	}
	
	@Test
	public void testgetProductByCategoryException() throws ProductNotFoundException{
		List<Product> products = new ArrayList<>();
		Assertions.assertThrows(ProductNotFoundException.class,
			() ->	{
				when(productRepository.findByCategory("Electronic")).thenReturn(products);
				assertThat(productService.getProductByCategory("Electronic")).isEqualTo(products);
			});
	}
	
	@Test
	public void testgetProductByCategorySuccess() throws ProductNotFoundException {
		List<Product> products = new ArrayList<>();
		products.add(new Product(2,"iphone 11", "APPLE", "Electronic", 38000, 4.8));
		when(productRepository.findByCategory("Electronic")).thenReturn(products);
		assertThat(productService.getProductByCategory("Electronic")).isEqualTo(products);
	}
	
	
	@Test
	public void testgetProductByCompanyNameException() throws ProductNotFoundException{
		List<Product> products = new ArrayList<>();
		Assertions.assertThrows(ProductNotFoundException.class,
			() ->	{
				when(productRepository.findByCompanyName("Puma")).thenReturn(products);
				assertNull(productService.getProductByCompanyName("Puma"));
			});
	}
	
	@Test
	public void testgetProductByCompanyNameSuccess() throws ProductNotFoundException {
		List<Product> products = new ArrayList<>();
		products.add(new Product(2,"iphone 11", "APPLE", "Electronic", 38000, 4.8));
		when(productRepository.findByCompanyName("APPLE")).thenReturn(products);
		assertNotNull(productService.getProductByCompanyName("APPLE"));
	}
	
	@Test
	public void testgetProductByNameSuccess() throws ProductNotFoundException {
		Product product = new Product(16,"T1","Vivo", "Electronic", 15000, 4.3);
		when(productRepository.findByName("T1")).thenReturn(product);
		assertNotNull(productService.getProductByName("T1"));
	}
	
	@Test
	public void testgetProductByNameException() throws ProductNotFoundException{
		Assertions.assertThrows(ProductNotFoundException.class, 
				() -> {
					when(productRepository.findByName("Yelo")).thenReturn(null);
					assertNull(productService.getProductByName("Yelo"));
		});
	}
	
	@Test
	public void testGetProductByIdSuccess() throws ProductNotFoundException{
		Product product = new Product(16,"T1","Vivo", "Electronic", 15000, 4.3);
		when(productRepository.findById(1)).thenReturn(Optional.of(product));
		assertNotNull(productService.getProductById(1));
	}
	
	@Test
	public void testGetProductByIdException() throws ProductNotFoundException{
		Assertions.assertThrows(ProductNotFoundException.class, 
		() -> {
			when(productRepository.findById(22).orElse(null)).thenReturn(null);
			assertNull(productService.getProductById(1));
		});
	}
	
	@Test
	public void testgetAllProducts() {
		List<Product> products = new ArrayList<>();
		when(productRepository.findAll()).thenReturn(products);
		assertThat(productService.getAllProducts()).isEqualTo(products);
	}
	
}
