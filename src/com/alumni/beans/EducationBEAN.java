package com.alumni.beans;


public class EducationBEAN {
	
	private int educationId;
	private String Degree;
	private int DegreeId;
	private String Branch;
	private int BranchId;
	private String courceName;
	private int tempm_id;
	private String PassOutYear;
	private String CollegeName;
	private String highestdegree;
	
	
	public int getTempm_id() {
		return tempm_id;
	}

	public void setTempm_id(int tempm_id) {
		this.tempm_id = tempm_id;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getHighestdegree() {
		return highestdegree;
	}

	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}

	public String getDegree() {
		return Degree;
	}
	
	public int getDegreeId() {
		return DegreeId;
	}

	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}

	public void setDegreeId(int degreeId) {
		DegreeId = degreeId;
	}

	public int getBranchId() {
		return BranchId;
	}

	public void setBranchId(int branchId) {
		BranchId = branchId;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getPassOutYear() {
		return PassOutYear;
	}
	public void setPassOutYear(String passOutYear) {
		PassOutYear = passOutYear;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	
	
	
}