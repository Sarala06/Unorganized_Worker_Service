package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suid=request.getParameter("uid");
		int uid=Integer.parseInt(suid);
		UserDao.delete(uid);
		response.sendRedirect("ViewUser");
	}
}
