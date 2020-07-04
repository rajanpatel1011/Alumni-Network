package com.alumni.beans;

import java.util.Date;
import java.util.List;

public class ProfileBEAN {
	EducationBEAN education;
	OtherEducationBean othereducation;
	List<MemhobbiesBEAN> Memhobbieshobbies;
	List<JobBean> job;

	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	private int firstLogin;
	private int memberId;
	private String userId;
	private String password;
	private String cpassword;

	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateAndBirth;
	private String gender;
	private String mobileNumber;
	private String emailId;
	private String enrollmentNumber;
	private String otherHobbies;
	private String addressLineOne;
	private String addressLineSecond;

	private int branchId;
	private int degreeId;
	private int passoutyearId;

	/*
	 * private String otherEdBranch; private String otherEdCource; private String
	 * otherEdPassOutYear; private String otherEdCollegeNameOrInst;
	 */

	private int accountType;
	private String displayPicLink;
	private int moderatorOne;
	private int moderatorTwo;

	private String totalExprianceMonth;
	private String totalExprianceYear;
	private String keySkills;

	public EducationBEAN getEducation() {
		return education;
	}

	public void setEducation(EducationBEAN education) {
		this.education = education;
	}

	public OtherEducationBean getOthereducation() {
		return othereducation;
	}

	public void setOthereducation(OtherEducationBean othereducation) {
		this.othereducation = othereducation;
	}

	public List<JobBean> getJob() {
		return job;
	}

	public void setJob(List<JobBean> job) {
		this.job = job;
	}

	public List<MemhobbiesBEAN> getMemhobbieshobbies() {
		return Memhobbieshobbies;
	}

	public void setMemhobbieshobbies(List<MemhobbiesBEAN> memhobbieshobbies) {
		Memhobbieshobbies = memhobbieshobbies;
	}

	public int getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public String getOtherHobbies() {
		return otherHobbies;
	}

	public void setOtherHobbies(String otherHobbies) {
		this.otherHobbies = otherHobbies;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateAndBirth() {
		return dateAndBirth;
	}

	public void setDateAndBirth(Date dateAndBirth) {
		this.dateAndBirth = dateAndBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineSecond() {
		return addressLineSecond;
	}

	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	/*
	 * 
	 * public String getOtherEdBranch() { return otherEdBranch; } public void
	 * setOtherEdBranch(String otherEdBranch) { this.otherEdBranch = otherEdBranch;
	 * } public String getOtherEdCource() { return otherEdCource; } public void
	 * setOtherEdCource(String otherEdCource) { this.otherEdCource = otherEdCource;
	 * } public String getOtherEdPassOutYear() { return otherEdPassOutYear; } public
	 * void setOtherEdPassOutYear(String otherEdPassOutYear) {
	 * this.otherEdPassOutYear = otherEdPassOutYear; } public String
	 * getOtherEdCollegeNameOrInst() { return otherEdCollegeNameOrInst; } public
	 * void setOtherEdCollegeNameOrInst(String otherEdCollegeNameOrInst) {
	 * this.otherEdCollegeNameOrInst = otherEdCollegeNameOrInst; }
	 */
	public String getTotalExprianceMonth() {
		return totalExprianceMonth;
	}

	public void setTotalExprianceMonth(String totalExprianceMonth) {
		this.totalExprianceMonth = totalExprianceMonth;
	}

	public String getTotalExprianceYear() {
		return totalExprianceYear;
	}

	public void setTotalExprianceYear(String totalExprianceYear) {
		this.totalExprianceYear = totalExprianceYear;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public int getPassoutyearId() {
		return passoutyearId;
	}

	public void setPassoutyearId(int passoutyearId) {
		this.passoutyearId = passoutyearId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getDisplayPicLink() {
		return displayPicLink;
	}

	public void setDisplayPicLink(String displayPicLink) {
		this.displayPicLink = displayPicLink;
	}

	public int getModeratorOne() {
		return moderatorOne;
	}

	public void setModeratorOne(int moderatorOne) {
		this.moderatorOne = moderatorOne;
	}

	public int getModeratorTwo() {
		return moderatorTwo;
	}

	public void setModeratorTwo(int moderatorTwo) {
		this.moderatorTwo = moderatorTwo;
	}

}
