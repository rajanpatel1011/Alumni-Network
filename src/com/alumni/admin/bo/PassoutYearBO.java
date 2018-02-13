package com.alumni.admin.bo;

import java.sql.SQLException;

import com.alumni.admin.dao.PassoutYearDAO;

public class PassoutYearBO {

	public int addYear(String year) throws SQLException {
		// TODO Auto-generated method stub
		PassoutYearDAO dao =  new PassoutYearDAO();
		int i = dao.addYear(year);
		return i;
	}

	 public int checkAddYear(String year)throws SQLException{
		 PassoutYearDAO dao = new PassoutYearDAO();
		 return dao.checkAddYear(year);
	 }
	 public void deleteYear(int year)throws SQLException{
		 PassoutYearDAO dao = new PassoutYearDAO();
		 dao.deleteYear(year);
	 }
}
