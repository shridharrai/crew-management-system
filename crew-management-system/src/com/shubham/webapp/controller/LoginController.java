package com.shubham.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;

import com.mysql.cj.Session;
import com.shubham.webapp.dao.WebappDAO;
import com.shubham.webapp.dto.userDTO;
import com.shubham.webapp.utils.Cache;

/**
 * Servlet implementation class FirstloginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		try {
			
				userDTO userdto = WebappDAO.login(userid, pwd);
				if(userdto!=null) {
//					if(WebappDAO.startupfinish()==true) {
//			if(WebappDAO.login(userid, pwd) == true) {
////				if(WebappDAO.startupfinish()==true) {
//				response.sendRedirect("dashboard.jsp");
						session.setAttribute("sessionuserid", userid);
						session.setAttribute("sessionpwd", pwd);
						request.setAttribute("uid", userdto.getUserid());
						request.setAttribute("role", userdto.getRolename());
						request.setAttribute("userdata", userdto.getRights());
//						request.setAttribute("roles",Cache.roleMap.get("roles"));
						RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
						rd.forward(request, response);
//						RequestDispatcher rd1 = request.getRequestDispatcher("showrole.jsp");
//						rd1.forward(request, response);
//				}
			}
			else {
////			request.setAttribute("notregister", "Unable to register");
				out.println("Unable to login");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
