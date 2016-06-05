package com.xlinyu.entity;

import java.util.Date;

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String email;
	
	private Date hiredate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
}
