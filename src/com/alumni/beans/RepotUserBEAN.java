package com.alumni.beans;

public class RepotUserBEAN {
	private int repotdId;

	private String reportedName;
	private int reportedId;

	private int reporterId;
	private String repoterName;

	private String issuMsg;

	public int getRepotdId() {
		return repotdId;
	}

	public void setRepotdId(int repotdId) {
		this.repotdId = repotdId;
	}

	public String getReportedName() {
		return reportedName;
	}

	public void setReportedName(String reportedName) {
		this.reportedName = reportedName;
	}

	public int getReportedId() {
		return reportedId;
	}

	public void setReportedId(int reportedId) {
		this.reportedId = reportedId;
	}

	public int getReporterId() {
		return reporterId;
	}

	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}

	public String getRepoterName() {
		return repoterName;
	}

	public void setRepoterName(String repoterName) {
		this.repoterName = repoterName;
	}

	public String getIssuMsg() {
		return issuMsg;
	}

	public void setIssuMsg(String issuMsg) {
		this.issuMsg = issuMsg;
	}

	public String getWrng() {
		return wrng;
	}

	public void setWrng(String wrng) {
		this.wrng = wrng;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	private String wrng;
	private String ban;
}
