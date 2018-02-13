package com.alumni.beans;

import java.util.List;

public class ReportedUserBEAN {

	// ================================================================
	private int rept_Id; // P_key of the table
	private String wrng_msg;
	private int ban;
	private String reported_fname;
	private String reported_lname;
	private int reported_Id;
	private List<ReporterUserBEAN> ReporterUser;
	// ================================================================
	
	public List<ReporterUserBEAN> getReporterUser() {
		return ReporterUser;
	}
	public void setReporterUser(List<ReporterUserBEAN> reporterUser) {
		ReporterUser = reporterUser;
	}
	public int getReported_Id() {
		return reported_Id;
	}
	public void setReported_Id(int reported_Id) {
		this.reported_Id = reported_Id;
	}
	public String getReported_fname() {
		return reported_fname;
	}
	public void setReported_fname(String reported_fname) {
		this.reported_fname = reported_fname;
	}
	public String getReported_lname() {
		return reported_lname;
	}
	public void setReported_lname(String reported_lname) {
		this.reported_lname = reported_lname;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getRept_Id() {
		return rept_Id;
	}
	public void setRept_Id(int rept_Id) {
		this.rept_Id = rept_Id;
	}
	public String getWrng_msg() {
		return wrng_msg;
	}
	public void setWrng_msg(String wrng_msg) {
		this.wrng_msg = wrng_msg;
	}
		

}
