package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class addsellerDAO {

	
	public static boolean registerseller(String userid,String contact,String email,String password,String role) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into user_mst(userid,contact,email,password) values(?,?,?,?)");
		pstmt.setString(1, userid);
		pstmt.setString(2, contact);
		pstmt.setString(3, email);
		pstmt.setString(4, password);
		int recordCount = pstmt.executeUpdate();
		pstmtmap = con.prepareStatement("insert into user_role_mapping(userid,roleid) values((select uid from user_mst where userid=?),(select roleid from role_mst where rolename=?))");
		pstmtmap.setString(1,userid);
		pstmtmap.setString(2, role);
		int recordCountmap = pstmtmap.executeUpdate();
		if(recordCount>0) {
			if(recordCountmap>0) {
//			msg = "Register SuccessFully";
			System.out.println("register successfully");
			return true;
			}
		}
		return false;
	}

	
	
//	public static boolean showrole() throws ClassNotFoundException, SQLException, NamingException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
////		String msg ="Invalid Userid or Password";
//		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("select roleid,rolename,description from role_mst where status=\"Y\"");
////		pstmt.setString(1, rolename);
//		rs = pstmt.executeQuery();
//		System.out.println(pstmt);
//		System.out.println(rs);
//		if(rs.next()) {
////			msg = "Welcome "+userid;
//			String rolename = rs.getString("rolename");
//			System.out.println(rolename);
//			System.out.println("Role select successful");
//			return true;
//		}
//		return false;
//	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
//		System.out.println(showrole());
//	}
}
