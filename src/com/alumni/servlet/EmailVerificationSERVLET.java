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

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.beans.SignupBEAN;
import com.alumni.bo.EmailVerificationBO;
import com.alumni.bo.SignupBO;

/**
 * Servlet implementation class EmailVerificationSERVLET
 */
@WebServlet("/EmailVerificationSERVLET")
public class EmailVerificationSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailVerificationSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
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
		
		EmailVerificationBO emailVerificationBO = new EmailVerificationBO();
		EmailVerificationBEAN emailVerificationBEAN = new EmailVerificationBEAN();
		
		emailVerificationBEAN.setFname(Fname);
		emailVerificationBEAN.setLname(Lname);
		emailVerificationBEAN.setGender(gender);
		emailVerificationBEAN.setDob(d);
		emailVerificationBEAN.setEmail(Email);
		emailVerificationBEAN.setPassyrId(PassyrId);
		emailVerificationBEAN.setBranchId(BranchId);
		emailVerificationBEAN.setEnrno(Enrno);
		
		try {
			emailVerificationBEAN = emailVerificationBO.sendCode(emailVerificationBEAN);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = null;
		if(emailVerificationBEAN.getEmail()!=null){
			System.out.println("here");
			msg="" +
					"Verification Code is send to Your email Id - "+Email+".<br /><br />" +
					//"<form method='post' id='veryCode' >" +
					"Enter Verification Code :     <br />" +
						"<input type='text' name='inputCode' id='code'/>" +
						"<input type='hidden' name='inputEmail' id='emailId' value='"+emailVerificationBEAN.getEmail()+"'/>" +
						"<div id='errMsg'></div>" +
						"<input type='submit' class='btn' id='sub_code' value='Submit'>" +
						
					//"</form>" +
					"";
		}else{
			System.out.println("there");
			msg="" +
					"Check Your email... <br/> Verification Code is send to Your email Id .<br />" +
					"<form method='post' id='veryCode'>" +
					"Email Id :" +
					"<input type='text' name='emailId' id='emailId'/>" +
					"Enter Verification Code :       <br />" +
						"<input type='text' name='code' id='code'/>" +
						"<input type='submit' class='btn' id='signup_btn' value='Submit'>" +
					"</form>" +
					"";
		}
		if(emailVerificationBEAN.isNetwork()){
			if(emailVerificationBEAN.isSuccess()){
				response.getWriter().write(msg);
			}else{ 
				response.getWriter().write("Try again server problem...");
			}
		}else{
			response.getWriter().write("Sorry ... Network Problem.<br/> Click <a href='index.jsp'>here</a> and try again....");
		}
		

	}

}
