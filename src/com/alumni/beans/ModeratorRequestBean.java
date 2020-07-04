package com.alumni.beans;

import java.util.Date;

public class ModeratorRequestBean {

	private int R_Id;
	private String f_name;
	private String l_name;
	private String gender;
	private Date dob;
	private String email_Id;
	private int p_Id;
	private int b_Id;
	private String b_name;
	private int m_id;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getCheckSelction() {
		return checkSelction;
	}

	public void setCheckSelction(int checkSelction) {
		this.checkSelction = checkSelction;
	}

	private int checkSelction;

	public String getMod1_name() {
		return Mod1_name;
	}

	public void setMod1_name(String mod1_name) {
		Mod1_name = mod1_name;
	}

	public String getMod2_name() {
		return Mod2_name;
	}

	public void setMod2_name(String mod2_name) {
		Mod2_name = mod2_name;
	}

	private String p_name;
	private String Mod1_name;
	private String Mod2_name;

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	String enr_No;

	int mod_Id1;

	public int getR_Id() {
		return R_Id;
	}

	public void setR_Id(int r_Id) {
		R_Id = r_Id;
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

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public int getP_Id() {
		return p_Id;
	}

	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}

	public int getB_Id() {
		return b_Id;
	}

	public void setB_Id(int b_Id) {
		this.b_Id = b_Id;
	}

	public String getEnr_No() {
		return enr_No;
	}

	public void setEnr_No(String enr_No) {
		this.enr_No = enr_No;
	}

	public int getMod_Id1() {
		return mod_Id1;
	}

	public void setMod_Id1(int mod_Id1) {
		this.mod_Id1 = mod_Id1;
	}

	public int getMod_Id2() {
		return mod_Id2;
	}

	public void setMod_Id2(int mod_Id2) {
		this.mod_Id2 = mod_Id2;
	}

	int mod_Id2;

}
