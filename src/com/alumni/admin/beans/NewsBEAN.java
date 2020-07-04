package com.alumni.admin.beans;

import java.util.Date;

public class NewsBEAN {
	private String title;
	private String description;
	private int hideStatus;
	private Date date_time;
	private Boolean Success;

	public Boolean getSuccess() {
		return Success;
	}

	public void setSuccess(Boolean success) {
		Success = success;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHideStatus() {
		return hideStatus;
	}

	public void setHideStatus(int hideStatus) {
		this.hideStatus = hideStatus;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

}
