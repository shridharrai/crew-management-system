package com.shubham.webapp.dto;

public class taskDTO {

	private String tname;
	private String desc;
	private String date;
	private String starttime;
	private String source;
	private String destination;
	
	public taskDTO(){}

	public taskDTO( String tname, String desc, String date, String starttime, String source,
			String destination) {
		super();
		this.tname = tname;
		this.desc = desc;
		this.date = date;
		this.starttime = starttime;
		this.source = source;
		this.destination = destination;
	}



	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "tasks [tname=" + tname + ", desc=" + desc + ", date=" + date + ", starttime=" + starttime + ", source="
				+ source + ", destination=" + destination + "]";
	}



	
	
	
}
