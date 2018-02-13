package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.EmailVerificationCodeBEAN;
import com.alumni.dao.EmailVerificationCodeDAO;

public class EmailVerificationCodeBO {

	public EmailVerificationCodeBEAN checkCode(EmailVerificationCodeBEAN emailVerificationCodeBEAN) throws SQLException {
		// TODO Auto-generated method stub
		EmailVerificationCodeDAO emailVerificationCodeDAO = new EmailVerificationCodeDAO();
		EmailVerificationCodeBEAN emailVerificationCodeBEAN1 = emailVerificationCodeDAO.checkCode(emailVerificationCodeBEAN);
		return emailVerificationCodeBEAN1;
	}

}
