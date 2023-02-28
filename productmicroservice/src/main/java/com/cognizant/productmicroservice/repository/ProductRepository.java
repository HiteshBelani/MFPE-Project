package com.cognizant.productmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.productmicroservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "SELECT P FROM Product P WHERE P.productName LIKE :product_name")
	public Product findByName(String product_name);

	@Query(value = "SELECT P FROM Product P WHERE P.companyName LIKE :company_name")
	public List<Product> findByCompanyName(String company_name);

	public List<Product> findByCategory(String category);

	@Query(value = "select * from product order by rating desc limit 5",nativeQuery = true)
	public List<Product> getHighestRatedProducts();

	@Query(value = "select * from product  order by rating asc limit 5",nativeQuery = true)
	public List<Product> getLowestRatedProducts();

	//@Query(value = "UPDATE Product P SET P.rating = :rating WHERE P.id = :id")
	//public Product updateRating(double rating,int id);
}
