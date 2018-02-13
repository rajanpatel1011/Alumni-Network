/* Demo checking by Suraj  */
package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.SignupBEAN;
import com.alumni.bo.SignupBO;

//signup servlet by Rahul ,,,,
/**
 * Servlet implementation class SignupSERVLET
 */
@WebServlet("/SignupSERVLET")
public class SignupSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Fname = request.getParameter("inputFname");
		String Lname = request.getParameter("inputLname");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String Email = request.getParameter("inputEmail");
		String Passyr = request.getParameter("inputPassyr");
		String branch = request.getParameter("branch");
		String Enrno = request.getParameter("inputEnrno");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date d = null;
		
		try {
			d = sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int PassyrId = Integer.parseInt(Passyr);
		int BranchId = Integer.parseInt(branch);
		
		SignupBO signupBO = new SignupBO();
		SignupBEAN signupBEAN = new SignupBEAN();
		
		signupBEAN.setFname(Fname);
		signupBEAN.setLname(Lname);
		signupBEAN.setGender(gender);
		signupBEAN.setDob(d);
		signupBEAN.setEmail(Email);
		signupBEAN.setPassyrId(PassyrId);
		signupBEAN.setBranchId(BranchId);
		signupBEAN.setEnrno(Enrno);
		
		try {			
			signupBEAN = signupBO.signup(signupBEAN);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(signupBEAN.isSuccess()){
			response.getWriter().write("Dear user your request is sent successfully to your respective moderator.You have shortly notify by mail.");
		}else{ 
			response.getWriter().write("Try again server problem...");
		}
		
	}

}
