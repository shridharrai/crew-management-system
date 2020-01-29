package com.shubham.webapp.dto;

import java.util.ArrayList;

public class userDTO {

	private String userid;
	private String rolename;
	private ArrayList<rightsDTO> rights = new ArrayList<>();
	
	public userDTO(){	}

	public userDTO(String userid, String rolename, ArrayList<rightsDTO> rights) {
		super();
		this.userid = userid;
		this.rolename = rolename;
		this.rights = rights;
	}

	public String getUserid() {
		return userid.toUpperCase();
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRolename() {
		return rolename.toUpperCase();
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public ArrayList<rightsDTO> getRights() {
		return rights;
	}

	public void setRights(ArrayList<rightsDTO> rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "userDTO [userid=" + userid + ", rolename=" + rolename + ", rights=" + rights + "]";
	}
	
	
}
