import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("xml servlet called");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		
		ServletContext context = request.getServletContext();
		
		if(userName != "" && userName != null){
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		
		writer.println("Request parameter has username as  " + userName);
		writer.println("Session parameter has username as  " + (String)(session.getAttribute("savedUserName")));
		writer.println("Context parameter has username as  " + (String)(context.getAttribute("savedUserName")));
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("xml servlet called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		//String location = request.getParameter("location");
		String[] location= request.getParameterValues("location");
		
		out.println("Hello from post! " + userName + " your full name is: "+fullName +" your job is: " + prof);
		out.println("You are " + location.length + " places");
		for(String s: location){
			out.println(s);
		}
	}
}
