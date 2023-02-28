package com.cognizant.feedbackmicroservice.model;

public class Product {

	private int id;
	private String productName;
	private String companyName;
	private String category;
	private int price;
	private double rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Product(int id, String productName, String companyName, String category, int price, double rating) {
		super();
		this.id = id;
		this.productName = productName;
		this.companyName = companyName;
		this.category = category;
		this.price = price;
		this.rating = rating;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
