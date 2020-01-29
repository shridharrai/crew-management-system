//package com.shubham.webapp.modal;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.naming.NamingException;
//
//import com.shubham.webapp.dao.CommonDAO;
//
//
//public class roleOperation {
//	
//	public static ArrayList<role> rolelist = new ArrayList<>();
//	
//	public static void addexistingrole() throws ClassNotFoundException, SQLException, NamingException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		PreparedStatement pstmtcount = null;
//		ResultSet rs,rscount = null;
//		String rolename = null;
//		int roleid = 0;
////		int rolecount = 0;
//		String roledesc = null;
//		role role = new role();
////		String msg ="Invalid Userid or Password";
//		con = CommonDAO.getConnection();
//		pstmtcount = con.prepareStatement("select * from role_mst");
////		rscount = pstmtcount.executeQuery("select * from role_mst");
//	    rscount = pstmtcount.executeQuery();
//		int count = 0;
//	      while (rscount.next()) {
//	        count++;
//	      }
//	      System.out.println(count); 
//	    
////	      for(int i=1;i<=count;count++) {
//		pstmt = con.prepareStatement("select roleid,rolename,description from role_mst where status=\"Y\" and roleid=?");
//		pstmt.setInt(1, 2);
////		pstmt.setString(1, roleid);
//		rs = pstmt.executeQuery();
//		System.out.println(pstmt);
//		System.out.println(rs);
//		if(rs.next()) {
////			msg = "Welcome "+userid;
//			roleid = rs.getInt("roleid");
//			rolename = rs.getString("rolename");
//			roledesc = rs.getString("description");
//			System.out.println(rolename);
//			role.setRoleid(roleid);
//			role.setRolename(rolename);
//			role.setDescription(roledesc);
//			rolelist.add(role);
//			System.out.println("Role select successful");
//			System.out.println(role);
//		}
//		else {
//		System.out.println("Unable to add existing roles");
//		}
////	      }
//	  
//	}
//	
//	
//	public void addnewrole(role role) throws ClassNotFoundException, SQLException {
//		try {
//		rolelist.add(role);
//		System.out.println("role list "+rolelist);
//		Connection con = null;
//		PreparedStatement pstmt = null;
////		ResultSet rs = null;
//		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("insert into role_mst(roleid,rolename,description) values(?,?,?)");
//		pstmt.setInt(1, role.getRoleid());
//		pstmt.setString(2, role.getRolename());
//		pstmt.setString(3, role.getDescription());
//		pstmt.executeUpdate();
//		pstmt.close();
//		con.close();
//		}catch(Exception e) {
//			System.out.println("Got an exception "+e.getMessage());
//		}
//	}
//	
//	public int searchrole(String rolename) {
//		role role = new role();
//		role.setRolename(rolename);
//		System.out.println(role);
//		int index = rolelist.indexOf(role);
//		System.out.println(index);
//		return index;
//	}
//	
////	public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
////		addexistingrole();
////	}
//}
