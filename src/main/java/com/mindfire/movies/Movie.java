package com.mindfire.movies;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String movieName;
	private List<Review> reviews = new ArrayList<Review>();
	
	public Movie() {
		movieName = null;
	}

	public Movie(String name, Review review) {
		movieName = name;
		reviews.add(review);
	}

	public Movie(String name, List<Review> reviewsArg) {
		movieName = name;
		for (Review review : reviewsArg) {
			reviews.add(review);
		}
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
}
