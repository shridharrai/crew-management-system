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
import com.shubham.webapp.dao.roleDAO;
import com.shubham.webapp.dto.rightsDTO;
import com.shubham.webapp.dto.userDTO;
import com.shubham.webapp.utils.Cache;

/**
 * Servlet implementation class AddSellerController
 */
@WebServlet("/addrole")
public class AddRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	String sessuid = (String) session.getAttribute("sessionuserid");
	String sesspwd = (String) session.getAttribute("sessionpwd");
	userDTO userdto;
	try {
			userdto = WebappDAO.login(sessuid, sesspwd);
			request.setAttribute("uid", userdto.getUserid());
			request.setAttribute("role", userdto.getRolename());
			request.setAttribute("userdata", userdto.getRights());
			request.setAttribute("rights",Cache.rightMap.get("rights"));
//			request.setAttribute("rights",Cache.rightMap.get("rights"));
			RequestDispatcher rd = request.getRequestDispatcher("addrole.jsp");
			rd.forward(request, response);
	} catch (ClassNotFoundException | SQLException | NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	String rolename = request.getParameter("rolename");
	String desc = request.getParameter("desc");
	String rightlist[] = request.getParameterValues("right");
//	System.out.println(rolename+desc+rights.toString());
//	if(rightlist!=null) {
//		for(int i=0;i<rightlist.length;i++) {
//			System.out.println(rightlist[i]);
//		}
//	}
	PrintWriter out = response.getWriter();
	try {
		if(roleDAO.addnewrole(rolename,desc,rightlist) == true) {
////			if(WebappDAO.startupfinish()==true) {
			String sessuid = (String) session.getAttribute("sessionuserid");
			String sesspwd = (String) session.getAttribute("sessionpwd");
			userDTO userdto = WebappDAO.login(sessuid, sesspwd);
			request.setAttribute("uid", userdto.getUserid());
			request.setAttribute("role", userdto.getRolename());
			request.setAttribute("userdata", userdto.getRights());
			RequestDispatcher rd = request.getRequestDispatcher("addrole.jsp");
			rd.forward(request, response);
//			}
		}
		else {
//		request.setAttribute("notregister", "Unable to register");
			out.println("Unable to add role");
		}
	} catch (ClassNotFoundException e) {
//		 TODO Auto-generated catch block
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
