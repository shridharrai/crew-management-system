package com.shubham.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.webapp.dao.WebappDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		try {
			if(WebappDAO.registercustomer(userid,contact,email,pwd) == true) {
//				if(WebappDAO.startupfinish()==true) {
				response.sendRedirect("login.jsp");
				}
//			}
			else {
//			request.setAttribute("notregister", "Unable to register");
				out.println("Unable to login");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
