package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.dao.EmailVerificationDAO;


public class EmailVerificationBO {

	public static EmailVerificationBEAN sendCode(EmailVerificationBEAN emailVerificationBEAN) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		EmailVerificationDAO emailVerificationDAO = new EmailVerificationDAO();
		EmailVerificationBEAN emailVerification = emailVerificationDAO.sendCode(emailVerificationBEAN);
		
		return emailVerification;
	}
	

}
