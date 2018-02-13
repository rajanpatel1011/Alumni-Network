package com.alumni.beans;

import java.util.Date;

public class UserRequestBean {

	/**
	 * @param args
	 */
	private int tempUID;
	private String enr_no;
	private String f_name;
	private String l_name;
	private String gender;
	private Date dob;
	private String email_id;
	private String p_year;
	private String b_name;
	private int email_verify;
	private int b_id;
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	private int p_id;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	private String password;
	private String u_id;
	public int getTempUID() {
		return tempUID;
	}
	public void setTempUID(int tempUID) {
		this.tempUID = tempUID;
	}
	public String getEnr_no() {
		return enr_no;
	}
	public void setEnr_no(String enr_no) {
		this.enr_no = enr_no;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getP_year() {
		return p_year;
	}
	public void setP_year(String p_year) {
		this.p_year = p_year;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getEmail_verify() {
		return email_verify;
	}
	public void setEmail_verify(int email_verify) {
		this.email_verify = email_verify;
	}
	
	
	
	
	
}