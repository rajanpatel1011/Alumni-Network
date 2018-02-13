package com.alumni.beans;

public class JobBean {
	
	private String jobType;
	private String startedMonth;
	private String StartedYear;
	private String endedMonth;
	private String endedYear;
	private String industryName;
	private String funcationArea;
	private int m_Id;
	private int proId;
	
	public int getM_Id() {
		return m_Id;
	}
	public void setM_Id(int m_Id) {
		this.m_Id = m_Id;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getStartedMonth() {
		return startedMonth;
	}
	public void setStartedMonth(String startedMonth) {
		this.startedMonth = startedMonth;
	}
	public String getStartedYear() {
		return StartedYear;
	}
	public void setStartedYear(String startedYear) {
		StartedYear = startedYear;
	}
	public String getEndedMonth() {
		return endedMonth;
	}
	public void setEndedMonth(String endedMonth) {
		this.endedMonth = endedMonth;
	}
	public String getEndedYear() {
		return endedYear;
	}
	public void setEndedYear(String endedYear) {
		this.endedYear = endedYear;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getFuncationArea() {
		return funcationArea;
	}
	public void setFuncationArea(String funcationArea) {
		this.funcationArea = funcationArea;
	}
	
}
