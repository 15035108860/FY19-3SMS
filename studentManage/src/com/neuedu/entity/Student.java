package com.neuedu.entity;

import java.io.Serializable;

public class Student implements Serializable{

	private Integer sid;
	private String sName;
	private Integer sAge;
	private String sSex;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer sid, String sName, Integer sAge, String sSex) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sAge = sAge;
		this.sSex = sSex;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsAge() {
		return sAge;
	}
	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}
	public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sAge=" + sAge + ", sSex=" + sSex + "]";
	}
	
	
	
	
}
