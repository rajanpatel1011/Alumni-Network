package com.alumni.admin.beans;

import java.util.Date;

public class UserAppBEAN {

	private int doc_Id;
	private String senderName;
	private String EnrollNo;
	private String data;
	private String Subject;
	private Date date;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDoc_Id() {
		return doc_Id;
	}

	public void setDoc_Id(int doc_Id) {
		this.doc_Id = doc_Id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getEnrollNo() {
		return EnrollNo;
	}

	public void setEnrollNo(String enrollNo) {
		EnrollNo = enrollNo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
