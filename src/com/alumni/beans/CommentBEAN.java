package com.alumni.beans;

import java.util.Date;

public class CommentBEAN {

	private int c_Id;
	private int f_Id;
	private String cmt_Data;
	private int Creator_Id;
	private Date Created_DateTime;
	private int rate;
	private String fname;
	private String lname;
	private boolean liked;

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
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

	public int getC_Id() {
		return c_Id;
	}

	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}

	public int getF_Id() {
		return f_Id;
	}

	public void setF_Id(int f_Id) {
		this.f_Id = f_Id;
	}

	public String getCmt_Data() {
		return cmt_Data;
	}

	public void setCmt_Data(String cmt_Data) {
		this.cmt_Data = cmt_Data;
	}

	public int getCreator_Id() {
		return Creator_Id;
	}

	public void setCreator_Id(int creator_Id) {
		Creator_Id = creator_Id;
	}

	public Date getCreated_DateTime() {
		return Created_DateTime;
	}

	public void setCreated_DateTime(Date date) {
		Created_DateTime = date;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
