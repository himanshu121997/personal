package com.school.model;

public class student {

	private String id;
	private String sName;

	public student(String id, String sName) {
		super();
		this.id = id;
		this.sName = sName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
