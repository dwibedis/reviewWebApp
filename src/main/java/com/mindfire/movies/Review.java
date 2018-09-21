package com.mindfire.movies;

public class Review {
	private String sourceName;
	private int ratingInStars;
	private String reviewStatement;
	
	public Review() {
		sourceName = "";
		ratingInStars = (Integer) null;
		reviewStatement = "";
		
	}
	public Review(String source, int rating, String review) {
		sourceName = source;
		ratingInStars =  rating;
		reviewStatement = review;
	}
	
	public String getSourceName() {
		return sourceName;
	}
	
	public int getRatingInStars() {
		return ratingInStars;
	}
	
	public String getReviewStatement() {
		return reviewStatement;
	}

}
