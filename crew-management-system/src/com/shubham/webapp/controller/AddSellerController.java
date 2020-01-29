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

import com.shubham.webapp.dao.WebappDAO;
import com.shubham.webapp.dao.addsellerDAO;
import com.shubham.webapp.dto.userDTO;
import com.shubham.webapp.utils.Cache;

/**
 * Servlet implementation class AddSellerController
 */
@WebServlet("/addseller")
public class AddSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	String sessuid = (String) session.getAttribute("sessionuserid");
	String sesspwd = (String) session.getAttribute("sessionpwd");
	try {
		userDTO userdto = WebappDAO.login(sessuid, sesspwd);
		request.setAttribute("uid", userdto.getUserid());
		request.setAttribute("role", userdto.getRolename());
		request.setAttribute("userdata", userdto.getRights());
		request.setAttribute("roles",Cache.roleMap.get("roles"));
//		request.setAttribute("rights",Cache.rightMap.get("rights"));
		RequestDispatcher rd = request.getRequestDispatcher("addseller.jsp");
		rd.forward(request, response);
	} catch (ClassNotFoundException | SQLException | NamingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}	
		
}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);

	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String contact = request.getParameter("contact");
	String email = request.getParameter("email");
	String role = request.getParameter("selectrole");
	PrintWriter out = response.getWriter();
	try {
		if(addsellerDAO.registerseller(userid,contact,email,pwd,role) == true) {
//			if(WebappDAO.startupfinish()==true) {
			String sessuid = (String) session.getAttribute("sessionuserid");
			String sesspwd = (String) session.getAttribute("sessionpwd");
			userDTO userdto = WebappDAO.login(sessuid, sesspwd);
			request.setAttribute("uid", userdto.getUserid());
			request.setAttribute("role", userdto.getRolename());
			request.setAttribute("userdata", userdto.getRights());
			RequestDispatcher rd = request.getRequestDispatcher("addseller.jsp");
			rd.forward(request, response);
			}
//		}
		else {
//		request.setAttribute("notregister", "Unable to register");
			out.println("Unable to register seller");
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
