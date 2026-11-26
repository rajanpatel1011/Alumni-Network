package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.beans.EmailVerificationCodeBEAN;

public class EmailVerificationCodeDAO {

	public EmailVerificationCodeBEAN checkCode(EmailVerificationCodeBEAN emailVerificationCodeBEAN)
			throws SQLException {
		try (Connection con = ConnectionDAO.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select e.token, e.very_id from tempuserdata t join emailverify e on t.very_codeId = e.very_id where t.email_Id = ? and e.code = ?")) {
			ps.setString(1, emailVerificationCodeBEAN.getEmail());
			ps.setString(2, emailVerificationCodeBEAN.getCode());
			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					return emailVerificationCodeBEAN;
				}
				emailVerificationCodeBEAN.setSuccess(true);
				emailVerificationCodeBEAN.setToken(rs.getString("token"));
				emailVerificationCodeBEAN.setId(rs.getInt("very_id"));
			}
		}
		verifiedCode(emailVerificationCodeBEAN);
		return emailVerificationCodeBEAN;
	}

	private void verifiedCode(EmailVerificationCodeBEAN emailVerificationCodeBEAN) throws SQLException {
		try (Connection con = ConnectionDAO.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"UPDATE tempuserdata set email_verify=?,verify_flag=? where very_codeId = ?")) {
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			ps.setInt(3, emailVerificationCodeBEAN.getId());
			ps.executeUpdate();
		}
	}

}
