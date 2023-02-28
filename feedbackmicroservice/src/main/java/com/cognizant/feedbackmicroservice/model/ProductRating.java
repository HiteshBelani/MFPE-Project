package com.cognizant.feedbackmicroservice.model;

public class ProductRating {

	private int productId;
	private double rating;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public ProductRating(int productId, double rating) {
		super();
		this.productId = productId;
		this.rating = rating;
	}
	public ProductRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
