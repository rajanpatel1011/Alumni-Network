package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.alumni.admin.beans.InitBEAN;
import com.alumni.dao.ConnectionDAO;

public class InitUserDAO {

	public InitBEAN adduser(InitBEAN bean) throws SQLException {

		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String st = sdf.format(bean.getDob());
		int id;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into members(u_Id,pwd,f_name,l_name,dob,email_Id,enr_No,gender,b_Id,p_Id) values(?,?,?,?,?,?,?,?,?,?);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bean.getUID());
			ps.setString(2, bean.getPwd());
			ps.setString(3, bean.getFname());
			ps.setString(4, bean.getLname());
			ps.setString(5, st);
			ps.setString(6, bean.getEmailId());
			ps.setString(7, bean.getEnrNo());
			ps.setString(8, bean.getGender());
			ps.setInt(9, bean.getBranch());
			ps.setInt(10, bean.getPassyear());

			if (ps.executeUpdate() == 1) {

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);

				PreparedStatement ps1 = con.prepareStatement("insert into init_users(m_Id) values(?)");
				ps1.setInt(1, id);
				if (ps1.executeUpdate() == 1) {
					bean.setSuccess(true);
				} else {
					bean.setSuccess(false);
				}
				return bean;
			} else {
				bean.setSuccess(false);
				return bean;
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}

	}

}
