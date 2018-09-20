package com.mindfire;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindfire.movies.Movie;
import com.mindfire.movies.Review;
import com.mindfire.utility.Date;

/**
 * This is the servlet for handling the search actions.
 * 
 * @author satyad
 *
 */
@WebServlet(urlPatterns = { "/home" }, initParams = { @WebInitParam(name = "appName", value = "reviewApp") })
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String APP_NAME;

	@Override
	public void init() throws ServletException {
		APP_NAME = getServletContext().getInitParameter("appName");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Movie movie = new Movie("Shawsank Redemption", new Date(1, 2, 1987), new Review("IMDB", 5, "Awesome") );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("movie", movie);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchQuery = req.getParameter("searchQuery");
		resp.getWriter().write(searchQuery);
	}
}
