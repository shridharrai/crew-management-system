//package com.shubham.webapp.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.shubham.webapp.utils.Cache;
//
///**
// * Servlet implementation class CityController
// */
//@WebServlet("/city")
//public class CityController extends HttpServlet {
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("city",Cache.cityMap.get("city"));
//		RequestDispatcher rd = request.getRequestDispatcher("task.jsp");
//		rd.forward(request, response);
//	}
//
//}
