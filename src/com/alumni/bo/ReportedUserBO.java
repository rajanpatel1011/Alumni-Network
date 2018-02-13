package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.ReportedUserBEAN;
import com.alumni.dao.ReportedUserDAO;

public class ReportedUserBO {
	
	public List<ReportedUserBEAN> reportedUserViewBO(int batch_id,int passout_id) throws ClassNotFoundException, SQLException
	// View of  Reported users 
	{
		
		ReportedUserDAO rudao = new ReportedUserDAO();
		List<ReportedUserBEAN> rub = rudao.reportedUserView(batch_id, passout_id);
		return rub;		
	}
	
	public void reportedUserWarnBO(int reported_User_Id) throws ClassNotFoundException, SQLException
	{
		ReportedUserDAO rudao = new ReportedUserDAO();
		rudao.reportedUserWarn(reported_User_Id);
	}

}
