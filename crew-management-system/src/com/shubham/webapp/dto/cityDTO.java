package com.shubham.webapp.dto;

public class cityDTO {
//	private int cid;
	private String cval;
	private String cname;

	public cityDTO(){	}
	
	public cityDTO(String cval, String cname) {
		super();
//		this.cid = cid;
		this.cval = cval;
		this.cname = cname;
	}

	public String getCval() {
		return cval;
	}

	public void setCval(String cval) {
		this.cval = cval;
	}
	

//	public int getCid() {
//		return cid;
//	}

//	public void setCid(int cid) {
//		this.cid = cid;
//	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "cityDTO [cval=" + cval + ", cname=" + cname + "]";
	}
	
	
}
