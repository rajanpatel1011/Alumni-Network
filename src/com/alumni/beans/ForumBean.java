package com.alumni.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForumBean {

	int f_id;
	String p_sub;
	int perm_id;
	int creator_id; // Thread creator's ID
	Date date_time;
	int reciver_id; // Useless in Forum ; Needed in Private message
	int no_Of_cmt;
	String desription;
	int pinned_flag;
	String f_name;
	String l_name;
	String perm_name;
	int p_id; // Pass out year ID
	int b_id; // Branch ID
	int m_id; // User's ID
	int delete_flag;
	ArrayList<CommentBEAN> commentList;
	private boolean isPinned;

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public ArrayList<CommentBEAN> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<CommentBEAN> commentList) {
		this.commentList = commentList;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

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

	public int getPerm_id() {
		return perm_id;
	}

	public void setPerm_id(int perm_id) {
		this.perm_id = perm_id;
	}

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

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getP_sub() {
		return p_sub;
	}

	public void setP_sub(String p_sub) {
		this.p_sub = p_sub;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public int getReciver_id() {
		return reciver_id;
	}

	public void setReciver_id(int reciver_id) {
		this.reciver_id = reciver_id;
	}

	public int getNo_Of_cmt() {
		return no_Of_cmt;
	}

	public void setNo_Of_cmt(int no_Of_cmt) {
		this.no_Of_cmt = no_Of_cmt;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public int getPinned_flag() {
		return pinned_flag;
	}

	public void setPinned_flag(int pinned_flag) {
		this.pinned_flag = pinned_flag;
	}

}
