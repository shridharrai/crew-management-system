package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import com.shubham.webapp.dto.roleDTO;
import com.shubham.webapp.dto.taskDTO;

public interface taskDAO {
	


	public static ArrayList existingtask(String userid) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<taskDTO> tasklist = new ArrayList<>();
//		ArrayList<roleDTO> rolelist = new ArrayList<>();
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select task_mst.taskname,task_mst.description,task_mst.startdate,task_mst.starttime,task_mst.source,task_mst.destination from task_mst,user_mst,user_task_mapping where task_mst.tid=user_task_mapping.taskid and user_mst.userid=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			taskDTO taskdto = new taskDTO();
//			taskdto.setTid(rs.getInt("tid"));
			taskdto.setTname(rs.getString("taskname"));
			taskdto.setDesc(rs.getString("description"));
			taskdto.setDate(rs.getString("startdate"));
			taskdto.setStarttime(rs.getString("starttime"));
			taskdto.setSource(rs.getString("source"));
			taskdto.setDestination(rs.getString("destination"));
			
			tasklist.add(taskdto);
//			System.out.println(rolelist);
		}
		rs.close();
		pstmt.close();
		con.close();
		return tasklist;		
	}
	
	
	public static boolean addnewtask(String taskname,String desc,String sdate,String stime,String source,String destination,String userid) throws ClassNotFoundException, SQLException {
		try {
//		tasklist.add(task);
//		System.out.println("task list "+tasklist);
		Connection con = null;
		PreparedStatement pstmt,pstmtmap = null;
//		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into task_mst(taskname,description,startdate,starttime,source,destination) values(?,?,?,?,?,?)");
		pstmt.setString(1, taskname);
		pstmt.setString(2, desc);
		pstmt.setString(3, sdate);
		pstmt.setString(4, stime);
		pstmt.setString(5, source);
		pstmt.setString(6, destination);
		int recordcount = pstmt.executeUpdate();
		pstmtmap = con.prepareStatement("insert into user_task_mapping (userid,taskid) values ((select uid from user_mst where userid=?),(select tid from task_mst where taskname=?))");
		pstmtmap.setString(1, userid);
		pstmtmap.setString(2, taskname);
		int recordcountmap = pstmtmap.executeUpdate();
		if(recordcount>0) {
			if(recordcountmap>0) {
				return true;
			}
		}
		pstmt.close();
		con.close();
		}catch(Exception e) {
			System.out.println("Got an exception "+e.getMessage());
		}
		return false;
		
		
	}
}
