package com.school.model;

import java.util.List;

public class school {
	private int schoolId;
	private String schoolName;
	private String schoolAddress;
	private List<student> student;

	public school(int schoolId, String schoolName, String schoolAddress, List<student> student) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.student = student;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public List<student> getStudent() {
		return student;
	}

	public void setStudent(List<student> student) {
		this.student = student;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

}
