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
@WebServlet("/EditUserForm")
public class EditUserForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String suid=request.getParameter("uid");
		int uid=Integer.parseInt(suid);
		UserBean bean=UserDao.getRecordByUid(uid);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Form</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navemployee.html").include(request, response);
		out.println("<div class='container'>");
		
		out.print("<h1>Edit User Form</h1>");
		out.print("<form action='EditUser' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='uid' value='"+bean.getUid()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+bean.getName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+bean.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+bean.getGender()+"'/></td></tr>");
		out.print("<tr><td>Occupation:</td><td><input type='text' name='occupation' value='"+bean.getOccupation()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;'>"+bean.getAddress()+"</textarea></td></tr>");
		out.print("<tr><td>Location:</td><td><input type='text' name='location' value='"+bean.getLocation()+"'/></td></tr>");
		out.print("<tr><td>Contact:</td><td><input type='text' name='contact' value='"+bean.getContact()+"'/></td></tr>");
		out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update User'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
				
		out.close();
	}

}
