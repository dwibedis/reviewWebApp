package com.mindfire.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mindfire.movies.Movie;
import com.mindfire.movies.Review;

public class MovieDBAPI {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/MovieReview";
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "mindfire";

	private static Properties property = new Properties();

	public MovieDBAPI() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
		}
		property.setProperty("user", USER_NAME);
		property.setProperty("password", PASSWORD);
	}

	public Movie fetchSourceAndReview(String name) {
		Movie movie = null;

		try {
			Connection connection = DriverManager.getConnection(URL, property);
			Statement statement = connection.createStatement();
			String query = "Select * from movie_review_db where moviename =" + "'" + name + "'"
					+ "order by rating desc";
			ResultSet rs = statement.executeQuery(query);
			movie = getMovie(rs, name);

		} catch (SQLException ex) {

		}
		return movie;
	}

	private Movie getMovie(ResultSet rs, String name) throws SQLException {
		List<Review> reviews = new ArrayList<Review>();
		if (rs.wasNull()) {
			// no action yet!!
		} else {
			while (rs.next()) {
				reviews.add(new Review(rs.getString(4), rs.getInt(3), rs.getString(5)));
			}
		}
		return new Movie(name, reviews);
	}

}
