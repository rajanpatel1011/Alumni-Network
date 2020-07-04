package com.alumni.admin.beans;

import java.util.Date;

public class InitBEAN {
	private String fname;
	private String lname;
	private String gender;
	private Date dob;
	private String emailId;
	private int passyear;
	private int branch;
	private String enrNo;
	private String UID;
	private String pwd;
	private Boolean Success;

	public Boolean getSuccess() {
		return Success;
	}

	public void setSuccess(Boolean success) {
		Success = success;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPassyear() {
		return passyear;
	}

	public void setPassyear(int passyear) {
		this.passyear = passyear;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public String getEnrNo() {
		return enrNo;
	}

	public void setEnrNo(String enrNo) {
		this.enrNo = enrNo;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
