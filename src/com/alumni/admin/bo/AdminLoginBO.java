package com.alumni.admin.bo;

import java.sql.SQLException;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.dao.AdminLoginDAO;

public class AdminLoginBO {

	public AdminLoginBEAN login(String uname, String pwd) throws SQLException {
		AdminLoginDAO dao = new AdminLoginDAO();
		AdminLoginBEAN bean = dao.login(uname, pwd);
		return bean;
	}

}
