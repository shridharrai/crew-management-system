package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shubham.webapp.dto.roleDTO;

public interface roleDAO {
	
//	public static ArrayList<roleDTO> rolelist = new ArrayList<>();

	public static ArrayList existingrole() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roleDTO> rolelist = new ArrayList<>();
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select roleid,rolename,description from role_mst where status=\"Y\"");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			roleDTO roledto = new roleDTO();
//			roledto.setRoleid(rs.getInt("roleid"));
			roledto.setRolename(rs.getString("rolename"));
			roledto.setDescription(rs.getString("description"));
			rolelist.add(roledto);
//			System.out.println(rolelist);
		}
		rs.close();
		pstmt.close();
		con.close();
		return rolelist;		
	}
	
	
	public static boolean addnewrole(String rolename,String desc,String rightlist[]) throws SQLException, ClassNotFoundException{
//		try {
//		rolelist.add(role);
//		System.out.println("role list "+rolelist);
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
//		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into role_mst(rolename,description) values(?,?)");
//		pstmt.setInt(1, role.getRoleid());
		pstmt.setString(1, rolename);
		pstmt.setString(2, desc);
		int recordcount = pstmt.executeUpdate();
		if(rightlist!=null) {
			for(int i=0;i<rightlist.length;i++) {
//			System.out.println(rightlist[i]);)
				pstmtmap = con.prepareStatement("insert into role_right_mapping(roleid,rightid) values((select roleid from role_mst where rolename=?),(select rightid from right_mst where rightname=?))");
				pstmtmap.setString(1, rolename);
				pstmtmap.setString(2, rightlist[i]);
				int recordcountmap = pstmtmap.executeUpdate();
			}
		}
		
		if(recordcount>0) {
//			if(recordcountmap>0) {
				System.out.println("register successfully");
				return true;
//			}
		}
		pstmt.close();
		con.close();
		return false;
		
//		}catch(Exception e) {
//			System.out.println("Got an exception "+e.getMessage());
//		}
	}

//	public static ArrayList<roleDTO> existingrole() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
