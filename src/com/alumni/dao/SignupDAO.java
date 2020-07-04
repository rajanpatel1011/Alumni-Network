package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.alumni.beans.SignupBEAN;

public class SignupDAO {

	public SignupBEAN signup(SignupBEAN signupBEAN) throws ClassNotFoundException, SQLException {

		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String st = sdf.format(signupBEAN.getDob());
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into tempuserdata(enr_no,f_name,l_name,gender,dob,email_Id,p_id,b_id,email_verify) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, signupBEAN.getEnrno());
			ps.setString(2, signupBEAN.getFname());
			ps.setString(3, signupBEAN.getLname());
			ps.setString(4, signupBEAN.getGender());
			ps.setString(5, st);
			ps.setString(6, signupBEAN.getEmail());
			ps.setInt(7, signupBEAN.getPassyrId());
			ps.setInt(8, signupBEAN.getBranchId());
			ps.setInt(9, 0);

			if (ps.executeUpdate() == 1) {
				signupBEAN.setSuccess(true);
				return signupBEAN;
			} else {
				signupBEAN.setSuccess(false);
				return signupBEAN;
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}

	}

}
