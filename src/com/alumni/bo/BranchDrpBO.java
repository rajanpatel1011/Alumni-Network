package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.BranchDrpBEAN;
import com.alumni.dao.BranchDrpDAO;

public class BranchDrpBO {
	public List<BranchDrpBEAN> branch() throws ClassNotFoundException, SQLException {
		BranchDrpDAO branchDrpDAO = new BranchDrpDAO();
		List<BranchDrpBEAN> branchDrpBEAN = branchDrpDAO.branch();
		return branchDrpBEAN;
	}
}
