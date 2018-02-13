package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.PermisionDrpBEAN;
import com.alumni.dao.PermisionDrpDAO;

public class PermisionDrpBO {

	public List<PermisionDrpBEAN> perm() throws ClassNotFoundException, SQLException{
		
		PermisionDrpDAO pDrpDAO = new PermisionDrpDAO();
		List<PermisionDrpBEAN> pdb = pDrpDAO.perm();
		return pdb;
	}
	
}
