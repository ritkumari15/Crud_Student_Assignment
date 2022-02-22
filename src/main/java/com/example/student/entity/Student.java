package com.example.student.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="STUDENT_NO")
	private String STUDENT_NO;
	
	@Column(name="STUDENT_NAME")
	private String STUDENT_NAME;
	
	@Column(name="STUDENT_DOB")
	private Date STUDENT_DOB;
	
	@Column(name="STUDENT_DOJ")
	private Date STUDENT_DOJ;

	public String getSTUDENT_NO() {
		return STUDENT_NO;
	}

	public void setSTUDENT_NO(String sTUDENT_NO) {
		STUDENT_NO = sTUDENT_NO;
	}

	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}

	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}

	public Date getSTUDENT_DOB() {
		return STUDENT_DOB;
	}

	public void setSTUDENT_DOB(Date sTUDENT_DOB) {
		STUDENT_DOB = sTUDENT_DOB;
	}

	public Date getSTUDENT_DOJ() {
		return STUDENT_DOJ;
	}

	public void setSTUDENT_DOJ(Date sTUDENT_DOJ) {
		STUDENT_DOJ = sTUDENT_DOJ;
	}
	
	

}
