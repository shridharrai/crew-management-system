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
//public class rightsOperation {
//	
//	public static ArrayList<rights> rightlist = new ArrayList<>();
//	
//	public static void addexistingrights() throws ClassNotFoundException, SQLException, NamingException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("select * from right_mst");
//	    rs = pstmt.executeQuery();
//		int count = 0;
//	      while (rs.next()) {
//	        count++;
//	      }
//	      System.out.println(count); 
//		rights right = new rights();
//	      for(int i=1;i<=count;i++) {
//	      pstmt = con.prepareStatement("select rightid,rightname,description,link from right_mst where rightid=?");
//	      pstmt.setInt(1, i);
//	      rs = pstmt.executeQuery();
////			System.out.println(pstmt);
////			System.out.println(rs);
//			if(rs.next()) {
////				msg = "Welcome "+userid;
//				int rightid = rs.getInt("rightid");
//				String rightname = rs.getString("rightname");
//				String rightdesc = rs.getString("description");
//				String rightlink = rs.getString("link");
////				System.out.println(rightname);
//				right.setRightid(rightid);
//				right.setRightname(rightname);
//				right.setDescription(rightdesc);
//				right.setLink(rightlink);
//				rightlist.add(right);
////				System.out.println("Role select successful");
//				System.out.println(rightlist);
//			}
//	      }
//		rs.close();
//		pstmt.close();
//		con.close();
//	}
//	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
//		addexistingrights();
//	}
//}
