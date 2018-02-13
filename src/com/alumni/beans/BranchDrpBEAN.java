package com.alumni.beans;

public class BranchDrpBEAN {
	public int getBranchId() {
		return BranchId;
	}

	public void setBranchId(int branchId) {
		BranchId = branchId;
	}

	//System.out.println("In Branch Bean");
	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	private String Branch;
	
	private int BranchId;
}
