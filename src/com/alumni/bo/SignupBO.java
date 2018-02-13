package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.beans.SignupBEAN;
import com.alumni.dao.SignupDAO;

public class SignupBO {
	public SignupBEAN signup(SignupBEAN signupBEAN) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		SignupDAO signupDAO = new SignupDAO();
		SignupBEAN signupBEAN1 = signupDAO.signup(signupBEAN);
		return signupBEAN1;
	}
}
