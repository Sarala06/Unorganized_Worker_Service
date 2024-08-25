package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee Panel</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navemployee.html").include(request, response);
		out.println("<div class='container'>");
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean status=EmployeeDao.validate(email, password);
		if(status){
			HttpSession session=request.getSession();
			session.setAttribute("employee","true");
			request.getRequestDispatcher("employeehome.html").include(request, response);
		}else{
			out.println("<h1>Employee Login Form</h1>");
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("EmployeeLoginForm.html").include(request, response);
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
