package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.beans.LoginBEAN;

public class LoginDAO {
	public LoginBEAN login(String userId, String password) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select m_Id,u_Id,f_name,l_name,acc_type,b_Id,p_Id,profile_pic from members where u_Id = ? and pwd = ?;");
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				LoginBEAN loginBEAN = new LoginBEAN();
				loginBEAN.setM_id(rs.getInt(1));
				loginBEAN.setUserName(rs.getString(2));
				loginBEAN.setF_name(rs.getString(3));
				loginBEAN.setL_name(rs.getString(4));
				loginBEAN.setRole(rs.getInt(5));
				loginBEAN.setB_id(rs.getInt(6));
				loginBEAN.setP_id(rs.getInt(7));
				loginBEAN.setPic(rs.getString(8));

				return loginBEAN;
			} else {
				return null;
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}
	}

}