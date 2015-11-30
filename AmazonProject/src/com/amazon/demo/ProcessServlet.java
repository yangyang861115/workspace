package com.amazon.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  file1, file2, language;
		
		file1 = request.getParameter("content1");
		file2 = request.getParameter("content2");
		language = request.getParameter("content3");
		/**test java**/
		String ans = file1 + file2 + language;
		//System.out.println(ans);
		/***********/
		
		//add name value pair to request
		request.setAttribute("re", ans);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Filter.jsp");
		dispatcher.forward(request,response);
		
		return;
		
		
	}

}
