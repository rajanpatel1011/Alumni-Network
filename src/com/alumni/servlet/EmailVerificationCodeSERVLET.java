package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.beans.EmailVerificationCodeBEAN;
import com.alumni.bo.EmailVerificationBO;
import com.alumni.bo.EmailVerificationCodeBO;

/**
 * Servlet implementation class EmailVerificationCodeSERVLET
 */
@WebServlet("/EmailVerificationCodeSERVLET")
public class EmailVerificationCodeSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailVerificationCodeSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		String code = request.getParameter("inputCode");
		String email = request.getParameter("inputEmail");
		
		System.out.print("code = "+code+"\nEMail = "+email);
		
		EmailVerificationCodeBO emailVerificationCodeBO = new EmailVerificationCodeBO();
		EmailVerificationCodeBEAN emailVerificationCodeBEAN = new EmailVerificationCodeBEAN();
		
		emailVerificationCodeBEAN.setCode(code);
		emailVerificationCodeBEAN.setEmail(email);
		
		try {
			emailVerificationCodeBEAN = emailVerificationCodeBO.checkCode(emailVerificationCodeBEAN);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String token = emailVerificationCodeBEAN.getToken();
		
		if(token != null){
			response.getWriter().write("0");
		}else{
			response.getWriter().write("1");
		}
		/*String token = "XQH9L";
		response.getWriter().write("Your Reqest is submitted. You will be notify by your register email Id.");*/
	}

}
