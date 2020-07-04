package com.alumni.admin.bo;

import java.sql.SQLException;

import com.alumni.admin.dao.BranchDAO;

public class BranchBO {

	public int addBranch(String branch) throws SQLException {
		BranchDAO dao = new BranchDAO();
		int i = dao.addBranch(branch);
		return i;
	}

	public int checkAddedBranch(String branch) throws SQLException {
		BranchDAO dao = new BranchDAO();
		return dao.checkAddedBranch(branch);
	}

	public void delectBranch(int branch) throws SQLException {
		BranchDAO dao = new BranchDAO();
		dao.deleteBranch(branch);
	}
}
