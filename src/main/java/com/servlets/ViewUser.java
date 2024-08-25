package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserBean;
import com.dao.UserDao;

@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View User</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navemployee.html").include(request, response);
		out.println("<div class='container'>");

		out.print("<h1>View Users</h1>");

		List<UserBean> list = UserDao.getAllRecords();
		out.println("<table class='table table-bordered table-striped'>");
		out.print(
				"<tr><th>UserId</th><th>Name</th><th>Email</th><th>Gender</th><th>Occupation</th><th>Address</th><th>Location</th><th>Contact</th><th>Edit</th><th>Delete</th>");
		for (UserBean bean : list) {
			out.print("<tr><td>" + bean.getUid() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmail()
					+ "</td><td>" + bean.getGender() + "</td><td>" + bean.getOccupation() + "</td><td>" + bean.getAddress()
					+ "</td><td>" + bean.getLocation() + "</td><td>" + bean.getContact() + "</td><td><a href='EditUserForm?uid=" + bean.getUid()
					+ "'>Edit</a></td><td><a href='DeleteUser?uid=" + bean.getUid()
					+ "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
