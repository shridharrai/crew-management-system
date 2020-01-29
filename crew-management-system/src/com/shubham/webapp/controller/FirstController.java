package com.shubham.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.webapp.dao.WebappDAO;

/**
 * Servlet implementation class FirstController
 */
@WebServlet("/firsttime")
public class FirstController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		String status = request.getParameter("first");
//		System.out.println(status);
		String userid = request.getParameter("userid");
		System.out.println(userid);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		ServletContext sc = request.getServletContext();
		String flag;
		try {			
//			if(status.equals("Y")) {
//			if(WebappDAO.start(status) == true) {
						if(WebappDAO.firstlogin(userid, pwd) == true) {
							flag = (String)sc.getAttribute("flag");
							if(WebappDAO.showstatus()==true){
								response.sendRedirect("firstpwdchange.jsp");
							}
							else if(WebappDAO.showstatus()!=true) {
								response.sendRedirect("login.jsp");
							}
							else{
								out.println("Flag is not set");
							}
						}
						else {
							out.println("Userid or password incorrect");
						}
//			}
//			}
//			else {
//				out.println("Unable to set up the application");
//			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}}
