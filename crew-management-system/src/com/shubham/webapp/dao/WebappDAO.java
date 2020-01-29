package com.shubham.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.shubham.webapp.dto.cityDTO;
import com.shubham.webapp.dto.rightsDTO;
import com.shubham.webapp.dto.userDTO;

public interface WebappDAO {
	public static boolean showstatus() throws ClassNotFoundException, SQLException {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	con = CommonDAO.getConnection();
	pstmt = con.prepareStatement("select status from app_startup where user_time=\"First Time\" and status =?");
	pstmt.setString(1, "Y");
	rs = pstmt.executeQuery();
	if(rs.next()) {
		System.out.println("Status Y is checked");
		return true;
	}
	System.out.println(rs);
	rs.close();
	pstmt.close();
	con.close();
	return false;
	}
	
	public static boolean startupfinish() throws ClassNotFoundException, SQLException {
		try {
		Connection con = null;
		PreparedStatement pstmt,pstmtrole,pstmtroleadd,pstmtright,pstmtright1,pstmtright2,pstmtright3,pstmtright4,pstmtright5,pstmtmap1,
		pstmtmap2,pstmtmap3,pstmtmap4,pstmtmap5,pstmtmap6,pstmtmap7,pstmtmap8,pstmtmap9,pstmtmap10,pstmtmap11,pstmtmap12,pstmtmap13,pstmtmap14 = null;
//		ResultSet rs = null;
		con = CommonDAO.getConnection();
		pstmtrole = con.prepareStatement("create table role_mst(roleid integer AUTO_INCREMENT,rolename varchar(50) UNIQUE NOT NULL,"
				+ "description varchar(100) not null,status char(1) default 'Y', primary key(roleid))");
		pstmtrole.executeUpdate();
		System.out.println("created role_mst table");
		pstmtroleadd = con.prepareStatement("insert into role_mst(rolename,description) values(\"admin\",\"Admin has all the rights\")");
		pstmtroleadd.executeUpdate();
		pstmtright = con.prepareStatement("create table right_mst(rightid integer AUTO_INCREMENT,rightname varchar(50) UNIQUE NOT NULL,"
				+ "description varchar(100) not null,link varchar(50) unique not null, primary key(rightid))");
		pstmtright.executeUpdate();
		System.out.println("created right_mst table");
		pstmtright1 = con.prepareStatement("insert into right_mst(rightname,description,link) values(\"Add New Supervisor\",\"Add seller\",\"addseller\")");
		pstmtright1.executeUpdate();
		pstmtright2 = con.prepareStatement("insert into right_mst(rightname,description,link) values(\"Add New Roles\",\"Add roles\",\"addrole\")");
		pstmtright2.executeUpdate();
		pstmtright3 = con.prepareStatement("insert into right_mst(rightname,description,link) values(\"Add New Tasks\",\"Add task\",\"task\")");
		pstmtright3.executeUpdate();
		pstmtright4 = con.prepareStatement("insert into right_mst(rightname,description,link) values(\"Show Existing Role\",\"Show roles\",\"showrole\")");
		pstmtright4.executeUpdate();
		pstmtright5 = con.prepareStatement("insert into right_mst(rightname,description,link) values(\"Show Existing Tasks\",\"Show tasks\",\"showtask\")");
		pstmtright5.executeUpdate();
		pstmtmap1 = con.prepareStatement("CREATE TABLE USER_ROLE_MAPPING (MAPID integer AUTO_INCREMENT, USERID INTEGER REFERENCES user_mst(uid) "
				+ "ON DELETE CASCADE,ROLEID INTEGER REFERENCES role_mst(roleid) ON DELETE CASCADE ,STATUS CHAR(1) DEFAULT 'Y',primary key(MAPID) )");
		pstmtmap1.executeUpdate();
		System.out.println("created user_role_mapping table");
		pstmtmap2 = con.prepareStatement("INSERT INTO USER_ROLE_MAPPING (USERID,ROLEID) VALUES(1,1)");
		pstmtmap2.executeUpdate();
		pstmtmap3 = con.prepareStatement("CREATE TABLE ROLE_RIGHT_MAPPING (MAPID integer AUTO_INCREMENT, ROLEID INTEGER REFERENCES ROLE_MST(ROLEID) "
				+ "ON DELETE CASCADE,RIGHTID INTEGER REFERENCES RIGHT_MST(RIGHTID) ON DELETE CASCADE ,STATUS CHAR(1) DEFAULT 'Y',primary key(MAPID))");
		pstmtmap3.executeUpdate();
		System.out.println("created role_right_mapping table");
		pstmtmap4 = con.prepareStatement("INSERT INTO ROLE_RIGHT_MAPPING (ROLEID,RIGHTID) VALUES(1,1)");
		pstmtmap4.executeUpdate();
		pstmtmap5 = con.prepareStatement("INSERT INTO ROLE_RIGHT_MAPPING (ROLEID,RIGHTID) VALUES(1,2)");
		pstmtmap5.executeUpdate();
		pstmtmap6 = con.prepareStatement("INSERT INTO ROLE_RIGHT_MAPPING (ROLEID,RIGHTID) VALUES(1,3)");
		pstmtmap6.executeUpdate();
		pstmtmap7 = con.prepareStatement("INSERT INTO ROLE_RIGHT_MAPPING (ROLEID,RIGHTID) VALUES(1,4)");
		pstmtmap7.executeUpdate();
		pstmtmap8 = con.prepareStatement("INSERT INTO ROLE_RIGHT_MAPPING (ROLEID,RIGHTID) VALUES(1,5)");
		pstmtmap8.executeUpdate();
		pstmtmap9 = con.prepareStatement("create table task_mst(tid integer AUTO_INCREMENT,taskname varchar(50) UNIQUE NOT NULL,description varchar(20),"
				+ "startdate varchar(50) unique not null,starttime varchar(50) not null,source varchar(50) not null,destination varchar(50) not null,"
				+ "status char(1) default 'Y', primary key(tid))");
		pstmtmap9.executeUpdate();
		System.out.println("created task_mst table");
		pstmtmap10 = con.prepareStatement("CREATE TABLE USER_TASK_MAPPING (MAPID integer AUTO_INCREMENT, USERID INTEGER REFERENCES USER_MST(UID) "
				+ "ON DELETE CASCADE,TASKID INTEGER REFERENCES TASK_MST(TID) ON DELETE CASCADE ,STATUS CHAR(1) DEFAULT 'Y',primary key(MAPID))");
		pstmtmap10.executeUpdate();
		System.out.println("created user_task_mapping table");
		pstmtmap11 = con.prepareStatement("create table city(cid integer auto_increment,cval varchar(20),cname varchar(20),"
				+ "status char(1) default 'Y',primary key(cid))");
		pstmtmap11.executeUpdate();
		System.out.println("created city table");
		pstmtmap12 = con.prepareStatement("insert into city(cval,cname) values(\"DEL\",\"DELHI\")");
		pstmtmap12.executeUpdate();
		pstmtmap13 = con.prepareStatement("insert into city(cval,cname) values(\"MUM\",\"MUMBAI\")");
		pstmtmap13.executeUpdate();
		pstmtmap14 = con.prepareStatement("insert into city(cval,cname) values(\"RAJ\",\"RAJASTHAN\")");
		pstmtmap14.executeUpdate();
		pstmt = con.prepareStatement("update app_startup set status=? where user_time=\"First Time\"");
		pstmt.setString(1, "N");
		pstmt.executeUpdate();
//		if(rs.next()) {
			System.out.println("Status N is checked");
//			return true;
//		}
//		System.out.println(rs);
//		rs.close();
		pstmt.close();
		con.close();
		return true;
		}catch(Exception e) {
			System.out.println("Got an exception "+e.getMessage());
		
		return false;
	}
		}

	
	public static userDTO login(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<rightsDTO> rights = null;
		userDTO userDTO = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("SELECT USER_MST.USERID AS USERID, ROLE_MST.ROLENAME AS ROLE,RIGHT_MST.RIGHTNAME,RIGHT_MST.LINK FROM USER_MST, ROLE_MST,RIGHT_MST "
				+ ",USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.USERID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID "
				+ "AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID and USER_MST.USERID=? and PASSWORD=?");
//		pstmt = con.prepareStatement("select userid, password "
//				+ "from user_mst where userid=? and password=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		System.out.println(rs);
		 while(rs.next()){
			  if(userDTO == null){
				userDTO = new userDTO();
				  userDTO.setUserid(rs.getString("USERID"));
				  userDTO.setRolename(rs.getString("ROLE"));
				  rights= new ArrayList<rightsDTO>();
				  userDTO.setRights(rights);
			  }
			  rightsDTO right = new rightsDTO(rs.getString("RIGHTNAME"), rs.getString("link"));
			  rights.add(right);
//			  return true;
		  }
//		if(rs.next()) {
////			msg = "Welcome "+userid;
//			System.out.println("Login successful");
//			return true;
//		}
//		 return false;
		 return userDTO;
	}
	
	public static boolean firstlogin(String userid, String password) throws ClassNotFoundException, SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		ArrayList<rightsDTO> rights = null;
//		userDTO userDTO = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
//		pstmt = con.prepareStatement("SELECT USER_MST.USERID AS USERID, ROLE_MST.ROLENAME AS ROLE,RIGHT_MST.RIGHTNAME,RIGHT_MST.LINK FROM USER_MST, ROLE_MST,RIGHT_MST "
//				+ ",USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.USERID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID "
//				+ "AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID and USER_MST.USERID=? and PASSWORD=?");
		pstmt = con.prepareStatement("select userid, password "
				+ "from user_mst where userid=? and password=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		System.out.println(rs);
//		 while(rs.next()){
//			  if(userDTO == null){
//				userDTO = new userDTO();
//				  userDTO.setUserid(rs.getString("USERID"));
//				  userDTO.setRolename(rs.getString("ROLE"));
//				  rights= new ArrayList<>();
//				  userDTO.setRights(rights);
//			  }
//			  rightsDTO right = new rightsDTO(rs.getString("RIGHTNAME"), rs.getString("link"));
//			  rights.add(right);
//			  return true;
//		  }
		if(rs.next()) {
//			msg = "Welcome "+userid;
			System.out.println("Login successful");
			return true;
		}
		 return false;
//		 return userDTO;
	}
	
	public static boolean register(String userid,String contact,String email,String password) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String msg ="Invalid Userid or Password";
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("insert into user_mst(userid,contact,email,password) values(?,?,?,?)");
		pstmt.setString(1, userid);
		pstmt.setString(2, contact);
		pstmt.setString(3, email);
		pstmt.setString(4, password);
		int recordCount = pstmt.executeUpdate();
		if(recordCount>0) {
//			msg = "Register SuccessFully";
			System.out.println("register successfully");
			return true;

		}
		return false;
	}
	
	public static boolean registercustomer(String userid,String contact,String email,String password) throws ClassNotFoundException, SQLException {
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
		pstmtmap.setString(1, userid);
		pstmtmap.setString(2, "customer");
		int recordcountmap = pstmtmap.executeUpdate();
		if(recordCount>0) {
			if(recordcountmap>0) {
//			msg = "Register SuccessFully";
			System.out.println("register successfully");
			return true;
			}
		}
		return false;
	}
	
	public static boolean firstupdatepwd(String userid,String contact,String email,String pwd) throws ClassNotFoundException, SQLException {
		try {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int p = 0;
		con = CommonDAO.getConnection();
		System.out.println("Before Running update Statement");
		pstmt = con.prepareStatement(" update user_mst set userid=?, contact=?, email=? , password=? where uid=1");
		pstmt.setString(1,userid);
		pstmt.setString(2, contact);
		pstmt.setString(3, email);
		pstmt.setString(4,pwd);
		pstmt.executeUpdate();
//		rs = pstmt.executeQuery();
		System.out.println("After executing update statement");
//		if(rs.next()) {
//			System.out.println("Update successful");
//			return true;
//		}
//		rs.close();
//		System.out.println(p);
//		if(p!=0) {
//			System.out.println(p);
//			return true;
//		}
		pstmt.close();
		con.close();
		return true;
		}catch(Exception e) {
			System.out.println("Got an exception "+e.getMessage());
		
		return false;
	}
	}
	
	public static ArrayList<cityDTO> clist = new ArrayList<>();
	
	public static ArrayList getCity() throws SQLException, ClassNotFoundException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<cityDTO> clist = new ArrayList<>();
		try {
			con = CommonDAO.getConnection();
			pstmt= con.prepareStatement("select cval, cname from city" );
//			pstmt.setInt(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cityDTO city = new cityDTO();
				city.setCval(rs.getString("cval"));
				city.setCname(rs.getString("cname"));
				clist.add(city);
			}
		}
		finally {
			if(rs!=null) {
				rs.close();
				
			}
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return clist;
	}
	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(WebappDAO.start("Y"));
//	}
}