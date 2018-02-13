package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.beans.EmailVerificationCodeBEAN;

public class EmailVerificationCodeDAO {

	public EmailVerificationCodeBEAN checkCode(EmailVerificationCodeBEAN emailVerificationCodeBEAN) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.print("\nEmail IN DAO ="+emailVerificationCodeBEAN.getEmail()+"\nCodeINDAO ="+emailVerificationCodeBEAN.getCode());
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from tempuserdata t,emailverify e where email_Id = ? and code = ? and t.very_codeId=e.very_id;"); 
			ps.setString(1,emailVerificationCodeBEAN.getEmail());
			ps.setString(2,emailVerificationCodeBEAN.getCode());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emailVerificationCodeBEAN.setSuccess(true);
				emailVerificationCodeBEAN.setToken(rs.getString("token"));
				emailVerificationCodeBEAN.setId(rs.getInt("very_id"));
				return emailVerificationCodeBEAN; 
			} else
				return null; 
			
		} finally {
			try{
				verifiedCode(emailVerificationCodeBEAN);
				ConnectionDAO.closeConnection(con);
				return emailVerificationCodeBEAN;
			}catch(Exception  e){
				
			}
		}
	}

	private void verifiedCode(EmailVerificationCodeBEAN emailVerificationCodeBEAN) {
		// TODO Auto-generated method stub
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement  ps=con.prepareStatement("UPDATE tempuserdata set email_verify=?,verify_flag=? where very_codeId = ?");
			ps.setInt(1,1);
			ps.setInt(2,1);
			ps.setInt(3,emailVerificationCodeBEAN.getId());
			
			ps.executeUpdate();
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	

}
