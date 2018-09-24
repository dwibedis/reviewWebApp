package com.mindfire.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mindfire.exception.MovieReviewException;
import com.mindfire.movies.Movie;
import com.mindfire.movies.Review;

public class MovieDBAPI {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/MovieReview";
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "mindfire";


	private static final Properties property = new Properties();

	private static Connection connection;
	private static Statement statement;

	static {
		property.setProperty("user", USER_NAME);
		property.setProperty("password", PASSWORD);
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, property);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			new MovieReviewException("Driver Not Found");
		} catch (SQLException e) {
			new MovieReviewException("Error while setting up connection");
		}
	}

	public Movie fetchSourceAndReview( String name) {
		Movie movie = null;
		if (QueryHelper.doesHaveSpecial(name)) {
			name = QueryHelper.reformat(name);
		}

		try {
			String query = "Select * from movie_review_db where moviename =" + "'" + name + "'"
					+ "order by rating desc";
			ResultSet rs = statement.executeQuery(query);
			movie = getMovie(rs, name);

		} catch (Exception ex) {
			ex.getCause();
			new MovieReviewException(ex.getMessage());
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

	public void insertAndUpdate(String movieName, Integer rating, String reviewStatement, String userName) {

		try {
			Connection connection = DriverManager.getConnection(URL, property);
			Statement statement = connection.createStatement();
			String query = String.format("Insert into movie_review_db values (DEFAULT,'%s', %d, '%s', '%s') returning id;",
					movieName, rating, userName, reviewStatement);
			statement.executeQuery(query);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
