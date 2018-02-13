package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.beans.LoginBEAN;
import com.alumni.dao.ConnectionDAO;

public class AdminLoginDAO {

	public AdminLoginBEAN login(String uname, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from adminlogin where aU_name=? and a_pwd=?"); 
			ps.setString(1,uname);
			ps.setString(2,pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AdminLoginBEAN bean = new AdminLoginBEAN();
				bean.setLoggedin(true);
				bean.setUserName(rs.getString(2));
				return bean; 
			} else{
				AdminLoginBEAN bean = new AdminLoginBEAN();
				bean.setLoggedin(false);
				return bean;
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}
		
		
	}

}
