package com.alumni.dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.service.EmailDeliveryService;

@Repository
public class EmailVerificationDAO {
	private final EmailDeliveryService emailDeliveryService;

	public EmailVerificationDAO(EmailDeliveryService emailDeliveryService) {
		this.emailDeliveryService = emailDeliveryService;
	}

	public EmailVerificationBEAN sendCode(EmailVerificationBEAN emailVerificationBEAN)
			throws ClassNotFoundException, SQLException {
		emailVerificationBEAN = setCode(emailVerificationBEAN);
		emailVerificationBEAN = setToken(emailVerificationBEAN);
		emailDeliveryService.sendVerificationCode(emailVerificationBEAN.getEmail(), emailVerificationBEAN.getCode());
		emailVerificationBEAN.setNetwork(true);
		return insertData(emailVerificationBEAN);
	}

	private EmailVerificationBEAN insertData(EmailVerificationBEAN emailVerificationBEAN)
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st = sdf.format(emailVerificationBEAN.getDob());
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps1 = con.prepareStatement("insert into emailverify(token,code) values(?,?)");
			ps1.setString(1, emailVerificationBEAN.getToken());
			ps1.setString(2, emailVerificationBEAN.getCode());
			int p1 = ps1.executeUpdate();

			PreparedStatement ps2 = con
					.prepareStatement("select very_id from emailverify where token = ? and code = ?;");
			ps2.setString(1, emailVerificationBEAN.getToken());
			ps2.setString(2, emailVerificationBEAN.getCode());
			ResultSet rs = ps2.executeQuery();
			int id;
			if (rs.next()) {
				id = rs.getInt(1);
			} else {
				return null;
			}

			PreparedStatement ps = con.prepareStatement(
					"insert into tempuserdata(enr_no,f_name,l_name,gender,dob,email_Id,p_id,b_id,email_verify,very_codeId) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, emailVerificationBEAN.getEnrno());
			ps.setString(2, emailVerificationBEAN.getFname());
			ps.setString(3, emailVerificationBEAN.getLname());
			ps.setString(4, emailVerificationBEAN.getGender());
			ps.setString(5, st);
			ps.setString(6, emailVerificationBEAN.getEmail());
			ps.setInt(7, emailVerificationBEAN.getPassyrId());
			ps.setInt(8, emailVerificationBEAN.getBranchId());
			ps.setInt(9, 0);
			ps.setInt(10, id);
			int p = ps.executeUpdate();

			if (p == 1 && p1 == 1) {
				emailVerificationBEAN.setSuccess(true);
				return emailVerificationBEAN;
			} else {
				emailVerificationBEAN.setSuccess(false);
				return emailVerificationBEAN;
			}
		} finally {
			ConnectionDAO.closeConnection(con);
		}

	}

	private EmailVerificationBEAN setToken(EmailVerificationBEAN emailVerificationBEAN) {
		int length = 5;
		char[] characterSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		Random random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		emailVerificationBEAN.setToken(new String(result));

		return emailVerificationBEAN;
	}

	private EmailVerificationBEAN setCode(EmailVerificationBEAN emailVerificationBEAN) {
		int length = 6;
		char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		Random random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		emailVerificationBEAN.setCode(new String(result));

		return emailVerificationBEAN;
	}

}
