package com.alumni.bo;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.dao.EmailVerificationDAO;

@Service
public class EmailVerificationBO {
	private final EmailVerificationDAO emailVerificationDAO;

	public EmailVerificationBO(EmailVerificationDAO emailVerificationDAO) {
		this.emailVerificationDAO = emailVerificationDAO;
	}

	public EmailVerificationBEAN sendCode(EmailVerificationBEAN emailVerificationBEAN)
			throws ClassNotFoundException, SQLException {
		return emailVerificationDAO.sendCode(emailVerificationBEAN);
	}

}
