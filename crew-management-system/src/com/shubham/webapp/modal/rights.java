//package com.shubham.webapp.modal;
//
//public class rights {
//	private int rightid;
//	private String rightname;
//	private String description;
//	private String link;
//	
//	rights(){}
//
//	public rights(int rightid, String rightname, String description, String link) {
//		super();
//		this.rightid = rightid;
//		this.rightname = rightname;
//		this.description = description;
//		this.link = link;
//	}
//
//	public int getRightid() {
//		return rightid;
//	}
//
//	public void setRightid(int rightid) {
//		this.rightid = rightid;
//	}
//
//	public String getRightname() {
//		return rightname;
//	}
//
//	public void setRightname(String rightname) {
//		this.rightname = rightname;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getLink() {
//		return link;
//	}
//
//	public void setLink(String link) {
//		this.link = link;
//	}
//
//	@Override
//	public String toString() {
//		return "rights [rightid=" + rightid + ", rightname=" + rightname + ", description=" + description + ", link="
//				+ link + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((description == null) ? 0 : description.hashCode());
//		result = prime * result + ((link == null) ? 0 : link.hashCode());
//		result = prime * result + rightid;
//		result = prime * result + ((rightname == null) ? 0 : rightname.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		rights other = (rights) obj;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (link == null) {
//			if (other.link != null)
//				return false;
//		} else if (!link.equals(other.link))
//			return false;
//		if (rightid != other.rightid)
//			return false;
//		if (rightname == null) {
//			if (other.rightname != null)
//				return false;
//		} else if (!rightname.equals(other.rightname))
//			return false;
//		return true;
//	}
//	
//	
//}
