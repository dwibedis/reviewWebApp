package com.mindfire.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindfire.constants.MovieReviewConstants;
import com.mindfire.movies.Movie;
import com.mindfire.utility.MovieDBAPI;

/**
 * This is the servlet for handling the search actions.
 * 
 * @author satyad
 *
 */
@WebServlet(urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {

	private static final MovieDBAPI movieDBAPI = new MovieDBAPI();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieName = request.getParameter(MovieReviewConstants.SEARCH_QUERY)
				.replaceAll(MovieReviewConstants.SPACE, " ").trim();
		Movie movie = movieDBAPI.fetchSourceAndReview(movieName);
		RequestDispatcher dispatcher = request.getRequestDispatcher(MovieReviewConstants.INDEX);
		request.setAttribute(MovieReviewConstants.MOVIE_ATTRIBUTE, movie);
		request.setAttribute(MovieReviewConstants.USER_NAME_ATTRIBUTE, MovieReviewConstants.USER_NAME);
		dispatcher.forward(request, response);
	}
}
