package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.LoginBEAN;
import com.alumni.dao.LoginDAO;

public class LoginBO {

	public LoginBEAN login(String userId, String password) throws SQLException {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new LoginDAO();
		LoginBEAN loginBEAN = loginDAO.login(userId,password);
		return loginBEAN;
	}



}
