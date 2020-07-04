package com.alumni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.alumni.beans.RepotUserBEAN;

public class StudentDAO {
	public void reportStudent(RepotUserBEAN bean) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO repoted_users(Repoted_UId,Repoter_UId,issu_msg)VALUES (?,?,?);");
			ps.setInt(1, bean.getReportedId());
			ps.setInt(2, bean.getReporterId());
			ps.setString(3, bean.getIssuMsg());
			ps.executeUpdate();
		}

		finally {
			ConnectionDAO.closeConnection(con);

		}
	}

	public int checkReporterUser(RepotUserBEAN bean) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("SELECT count(Repoter_UId) FROM repoted_users where Repoted_UId=?;");
			ps.setInt(1, bean.getReportedId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return (Integer) null;
			}
		}

		finally {
			ConnectionDAO.closeConnection(con);

		}
	}

	public int checkReportedUser(RepotUserBEAN bean) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("SELECT count(Repoted_UId) FROM repoted_users where Repoted_UId=?;");
			ps.setInt(1, bean.getReportedId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return (Integer) null;
			}
		}

		finally {
			ConnectionDAO.closeConnection(con);

		}
	}

}
