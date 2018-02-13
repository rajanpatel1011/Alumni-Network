package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.RepotUserBEAN;
import com.alumni.dao.StudentDAO;

public class StudentBO {

	public void reportStudent(RepotUserBEAN bean)throws SQLException{
		StudentDAO dao = new StudentDAO();
		dao.reportStudent(bean);
	}
	public int checkReporterUser(RepotUserBEAN bean)throws SQLException{
		StudentDAO dao = new StudentDAO();
		return dao.checkReporterUser(bean);
	}
	public int checkReportedUser(RepotUserBEAN bean)throws SQLException{
		StudentDAO dao = new StudentDAO();
		return dao.checkReportedUser(bean);
	}
}
