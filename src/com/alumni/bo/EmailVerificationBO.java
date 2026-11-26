package com.alumni.bo;

import java.sql.SQLException;

import javax.mail.MessagingException;

import javax.mail.MessagingException;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.dao.EmailVerificationDAO;

public class EmailVerificationBO {

	public static EmailVerificationBEAN sendCode(EmailVerificationBEAN emailVerificationBEAN)
			throws ClassNotFoundException, SQLException, MessagingException {
		EmailVerificationDAO emailVerificationDAO = new EmailVerificationDAO();
		return emailVerificationDAO.sendCode(emailVerificationBEAN);
	}

}
