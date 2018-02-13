package com.alumni.beans;

import java.util.Date;

public class PhotoUploadBean {

	int m_id;
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	int A_id;
	String title;
	int Privacy;
	String caption;
	Date Takendate;
	
	String imagepath;
	String perm_name;
	String f_name;
	String L_name;
	int photo_id;
	
	
	public String getPerm_name() {
		return perm_name;
	}
	public void setPerm_name(String perm_name) {
		this.perm_name = perm_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return L_name;
	}
	public void setL_name(String l_name) {
		L_name = l_name;
	}
	public int getM_id() {
		return m_id;
	}
	public int getPrivacy() {
		return Privacy;
	}
	public void setPrivacy(int privacy) {
		Privacy = privacy;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getA_id() {
		return A_id;
	}
	public void setA_id(int a_id) {
		A_id = a_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Date getTakendate() {
		return Takendate;
	}
	public void setTakendate(Date takendate) {
		Takendate = takendate;
	}
	
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
	
	
	
	
	
	
	
}
