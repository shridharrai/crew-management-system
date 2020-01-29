package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shubham.webapp.dto.rightsDTO;
import com.shubham.webapp.dto.roleDTO;

public interface rightsDAO {

	public static ArrayList existingright() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<rightsDTO> rightlist = new ArrayList<>();
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select rightname,link from right_mst");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			rightsDTO rightdto = new rightsDTO();
//			rightdto.setRightname(rs.getInt("rightid"));
			rightdto.setRightname(rs.getString("rightname"));
//			rightdto.setDescription(rs.getString("description"));
			rightdto.setScreenname(rs.getString("link"));
			rightlist.add(rightdto);
			System.out.println(rightlist);
		}
		rs.close();
		pstmt.close();
		con.close();
		return rightlist;		
	}
}
