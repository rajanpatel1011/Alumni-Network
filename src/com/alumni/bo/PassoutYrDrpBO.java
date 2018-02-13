package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.PassoutYrDrpBEAN;
import com.alumni.dao.PassoutYrDrpDAO;



public class PassoutYrDrpBO {
	public List<PassoutYrDrpBEAN> p_years() throws ClassNotFoundException, SQLException{
		//System.out.println("In Passout Year BO");
		PassoutYrDrpDAO passoutYrDepDAO = new PassoutYrDrpDAO();
		List<PassoutYrDrpBEAN> passoutYrDrpBEAN = passoutYrDepDAO.p_years();
		return passoutYrDrpBEAN;
	}
}
