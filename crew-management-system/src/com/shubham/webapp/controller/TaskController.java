package com.shubham.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.webapp.dao.WebappDAO;
import com.shubham.webapp.dao.taskDAO;
import com.shubham.webapp.dto.userDTO;
import com.shubham.webapp.utils.Cache;

/**
 * Servlet implementation class TaskController
 */
@WebServlet("/task")
public class TaskController extends HttpServlet {
	
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
			request.setAttribute("city",Cache.cityMap.get("city"));
//			request.setAttribute("rights",Cache.rightMap.get("rights"));
			RequestDispatcher rd = request.getRequestDispatcher("task.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String taskname = request.getParameter("taskname");
		String desc = request.getParameter("desc");
		String date = request.getParameter("startdate");
		String time = request.getParameter("starttime");
		String source = request.getParameter("source");
		String dest = request.getParameter("dest");
//		String userid = (String)request.getAttribute("uid");
//		LocalDate sdate = LocalDate.parse(date);
//		LocalTime starttime = LocalTime.parse(time);
//		System.out.println("task userid "+userid);
	
		try {
			String userid = (String) session.getAttribute("sessuid");
			System.out.println(userid);
			if(taskDAO.addnewtask(taskname, desc, date, time, source, dest,userid)==true) {
				String sessuid = (String) session.getAttribute("sessionuserid");
				String sesspwd = (String) session.getAttribute("sessionpwd");
				userDTO userdto = WebappDAO.login(sessuid, sesspwd);
				request.setAttribute("uid", userdto.getUserid());
				request.setAttribute("role", userdto.getRolename());
				request.setAttribute("userdata", userdto.getRights());
				RequestDispatcher rd = request.getRequestDispatcher("task.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("Unable to add task");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		tasklist list = new tasklist(taskname, desc, sdate, starttime, source, dest);
 catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
