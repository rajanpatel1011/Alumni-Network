package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.PassoutYrDrpBEAN;

public class PassoutYrDrpDAO {

	public List<PassoutYrDrpBEAN> p_years() throws ClassNotFoundException, SQLException {

		// System.out.println("In Passout Year DAO");
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from passout_year");
			ResultSet rs = ps.executeQuery();

			List<PassoutYrDrpBEAN> array;
			PassoutYrDrpBEAN pyr;
			if (rs.next()) {
				array = new ArrayList<PassoutYrDrpBEAN>();
				do {
					pyr = new PassoutYrDrpBEAN();
					pyr.setPassOutYearId(rs.getInt(1));
					pyr.setPassOutYear(rs.getString(2));
					array.add(pyr);
				} while (rs.next());
				return array;
			} else {
				return new ArrayList<>();
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}
	}
}
