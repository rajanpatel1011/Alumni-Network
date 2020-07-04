package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.PermisionDrpBEAN;

public class PermisionDrpDAO {

	public List<PermisionDrpBEAN> perm() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from permision");
			ResultSet rs = ps.executeQuery();

			List<PermisionDrpBEAN> array;
			PermisionDrpBEAN pdb;
			if (rs.next()) {
				array = new ArrayList<PermisionDrpBEAN>();
				do {
					pdb = new PermisionDrpBEAN();
					pdb.setPerm_Id((rs.getInt(1)));
					pdb.setPerm_Name((rs.getString(2)));
					array.add(pdb);
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
