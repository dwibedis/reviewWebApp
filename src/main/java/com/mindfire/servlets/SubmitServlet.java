package com.mindfire.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindfire.constants.MovieReviewConstants;
import com.mindfire.utility.MovieDBAPI;

/**
 * 
 * @author satyad
 *
 */
@WebServlet(urlPatterns = { "/submit" })
public class SubmitServlet extends HttpServlet {

	private static final MovieDBAPI movieDBAPI = new MovieDBAPI();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieName = request.getParameter(MovieReviewConstants.MOVIE_NAME_ATTRIBUTE);
		Integer rating = Integer.parseInt(request.getParameter(MovieReviewConstants.RATING_ATTRIBUTE));
		String reviewStatement = request.getParameter(MovieReviewConstants.REVIEW_STATEMENT_ATTRIBUTE);
		movieDBAPI.insertAndUpdate(movieName, rating, reviewStatement, MovieReviewConstants.USER_NAME);
		response.sendRedirect(MovieReviewConstants.HOME);
	}

}
