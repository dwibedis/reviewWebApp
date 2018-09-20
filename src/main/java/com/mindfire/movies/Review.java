package com.mindfire.movies;

public class Review {
	private String sourceName;
	private int ratingInStars;
	private String reviewStatement;
	
	public Review(String source, int rating, String review) {
		sourceName = source;
		ratingInStars =  rating;
		reviewStatement = review;
	}
	
	public String getSource() {
		return sourceName;
	}
	
	public int getRating() {
		return ratingInStars;
	}
	
	public String getReview() {
		return reviewStatement;
	}
}
