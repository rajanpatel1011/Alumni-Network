package com.alumni.beans;

public class PassoutYrDrpBEAN {
	
	public int getPassOutYearId() {
		return PassOutYearId;
	}

	public void setPassOutYearId(int passOutYearId) {
		PassOutYearId = passOutYearId;
	}

	public String getPassOutYear() {
		// System.out.println("In Passout Year BEAN GET YEAR ");
		return PassOutYear;
	}

	public void setPassOutYear(String passOutYear) {
		PassOutYear = passOutYear;
	}

	private String PassOutYear;
	private int PassOutYearId;

}
