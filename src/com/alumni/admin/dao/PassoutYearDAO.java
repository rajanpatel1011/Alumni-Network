package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.dao.ConnectionDAO;

public class PassoutYearDAO {

	public int addYear(String year) throws SQLException {

		Connection con = null;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into passout_year(Passout_yr) values(?)");
			ps.setString(1, year);

			if (ps.executeUpdate() == 1) {
				return 1;
			} else {
				return 0;
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}
	}

	public int checkAddYear(String year) throws SQLException {

		Connection con = null;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("SELECT count(Passout_yr) FROM passout_year where Passout_yr=?;");
			ps.setString(1, year);
			ResultSet r = ps.executeQuery();
			if (r.next()) {

				return r.getInt(1);
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return 0;
	}

	public void deleteYear(int year) throws SQLException {

		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM passout_year WHERE p_Id=?;");
			ps.setInt(1, year);
			ps.executeUpdate();

		} finally {
			ConnectionDAO.closeConnection(con);
		}

	}
}
