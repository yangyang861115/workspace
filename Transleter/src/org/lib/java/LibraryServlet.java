package org.lib.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet("/LibraryServlet")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String library;
		library = request.getParameter("library");
		PrintWriter writer = response.getWriter();
		writer.println("A library has been chose:  " + library);

		//library condition
		
		RequestDispatcher dispacher = request.getRequestDispatcher("Filter.jsp");
		dispacher.forward(request, response);
		return;
	}

}
