package com.shubham.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.webapp.dao.WebappDAO;

/**
 * Servlet implementation class FirstloginController
 */
@WebServlet("/firstpwdchnge")
public class FirstpwdchangeController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
//		Object flagN = "N";
		ServletContext sc = request.getServletContext();
		
		PrintWriter out = response.getWriter();
		try {
			if(WebappDAO.firstupdatepwd(userid,contact,email, pwd) == true) {
				if(WebappDAO.startupfinish()==true) {
//					sc.setAttribute("flag",flagN);
				response.sendRedirect("logout.jsp");
				}
				else {
					System.out.println("Unable to set flag N");
					out.println("Unable to set flag N");
				}
			}
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

	private Object Object(String flagN) {
		// TODO Auto-generated method stub
		return null;
	}

}
