package com.alumni.admin.beans;

import java.util.Date;

public class EventCreateBEAN {
	int E_id;
	String title;
	String Event_pic;

	public int getE_id() {
		return E_id;
	}

	public void setE_id(int e_id) {
		E_id = e_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEvent_pic() {
		return Event_pic;
	}

	public void setEvent_pic(String event_pic) {
		Event_pic = event_pic;
	}

	public Date getOrgdate() {
		return orgdate;
	}

	public void setOrgdate(Date orgdate) {
		this.orgdate = orgdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	Date orgdate;
	String description;

}
