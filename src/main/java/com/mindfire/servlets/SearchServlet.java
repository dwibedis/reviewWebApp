package com.mindfire.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	private static final long serialVersionUID = 1L;
	private static final MovieDBAPI movieDBAPI = new MovieDBAPI();

	private static Movie movie;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		movie = movieDBAPI.fetchSourceAndReview(request.getParameter("searchQuery"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("movie", movie);
		request.setAttribute("movieName", request.getParameter("searchQuery"));
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchQuery = req.getParameter("searchQuery");
		resp.getWriter().write(searchQuery);
	}
}
