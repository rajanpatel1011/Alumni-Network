package com.alumni.beans;

import java.util.Date;

public class MsgBEAN {
	
	
	int f_Id;
	int reciver_Id;
	String disription;
	Date date_time; 
	String f_name;
	String l_name;
	int creator_id;
	
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
	public int getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	public int getF_Id() {
		return f_Id;
	}
	public void setF_Id(int f_Id) {
		this.f_Id = f_Id;
	}
	public int getReciver_Id() {
		return reciver_Id;
	}
	public void setReciver_Id(int reciver_Id) {
		this.reciver_Id = reciver_Id;
	}
	public String getDisription() {
		return disription;
	}
	public void setDisription(String disription) {
		this.disription = disription;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

}
