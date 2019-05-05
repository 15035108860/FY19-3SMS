package com.neuedu.entity;

import java.io.Serializable;

public class Course implements Serializable{

	private Integer cId;
	private String CName;
	public Course() {
		super();
		
	}
	public Course(Integer cId, String cName) {
		super();
		this.cId = cId;
		CName = cName;
	}
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", CName=" + CName + "]";
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	
	
}
