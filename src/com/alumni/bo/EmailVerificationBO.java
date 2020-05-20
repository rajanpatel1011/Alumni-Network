package com.alumni.bo;

import java.sql.SQLException;

import javax.mail.MessagingException;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.dao.EmailVerificationDAO;


public class EmailVerificationBO {

	public static EmailVerificationBEAN sendCode(EmailVerificationBEAN emailVerificationBEAN) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		EmailVerificationDAO emailVerificationDAO = new EmailVerificationDAO();
		EmailVerificationBEAN emailVerification = null;
		try {
			emailVerification = emailVerificationDAO.sendCode(emailVerificationBEAN);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emailVerification;
	}
	

}
