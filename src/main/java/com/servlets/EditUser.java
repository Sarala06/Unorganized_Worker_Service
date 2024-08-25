package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserBean;
import com.dao.UserDao;
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String occupation=request.getParameter("occupation");
		String address=request.getParameter("address");
		String location=request.getParameter("location");
		String contact=request.getParameter("contact");
		
		UserBean bean=new UserBean(uid,name, email, gender, occupation,address, location, contact);
		int status=UserDao.update(bean);
		response.sendRedirect("ViewUser");
		
		out.close();
	}

}
