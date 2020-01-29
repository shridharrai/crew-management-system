package com.shubham.webapp.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shubham.webapp.dao.CommonDAO;

/**
 * Application Lifecycle Listener implementation class firsttimelistener
 *
 */
@WebListener
public class firsttimelistener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public firsttimelistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static String flag;
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    
    	
    	try {
			con = CommonDAO.getConnection();
		
    	pstmt = con.prepareStatement("select status from app_startup where user_time=\"First Time\" and status =\"Y\"");
//    	pstmt.setString(1, "Y");
    	rs = pstmt.executeQuery();
    	if(rs.next()) {
    		System.out.println("Status Y is checked");
    		flag=rs.getString("status");
    		System.out.println(flag+rs);
    		sce.getServletContext().setAttribute("flag", flag);
    	}
//    	System.out.println(rs);
    	
    	rs.close();
    	pstmt.close();
    	con.close();
//    	return false;
 
    } catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    }}
