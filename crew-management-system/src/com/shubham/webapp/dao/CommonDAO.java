package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public interface CommonDAO {

	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root","shubham");
		if(con!=null) {
			System.out.println("Connnection Created.");
//			con.close();
		}
		else {
			System.out.println("Not Created.");
		}
		return con;
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		CommonDAO.getConnection();
//	}
}
