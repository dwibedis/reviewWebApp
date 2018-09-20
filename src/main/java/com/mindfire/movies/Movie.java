package com.mindfire.movies;

import java.util.ArrayList;
import java.util.List;

import com.mindfire.utility.Date;

public class Movie {
	private String movieName;
	private Date releaseDate;
	private List<Review> reviews = new ArrayList<Review>();
	
	public Movie() {
		movieName = null;
		releaseDate = null;
	}
	public Movie(String name, Date date, Review review) {
		movieName = name;
		releaseDate = date;
		reviews.add(review);
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public Date getDate() {
		return releaseDate;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
}
