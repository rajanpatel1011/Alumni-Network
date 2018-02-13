package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.sendRequestToBecomeModbeans;
import com.alumni.bo.SendRequestTobecomeModBO;
import com.sun.mail.iap.Response;

/**
 * Servlet implementation class SendRequestToBecomeMod
 */
@WebServlet("/SendRequestToBecomeMod")
public class SendRequestToBecomeMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 
		SendRequestTobecomeModBO bo = new SendRequestTobecomeModBO();
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		sendRequestToBecomeModbeans bean=new sendRequestToBecomeModbeans();
		bean.setM_id(lb.getM_id());
	
		
		try {
			sendRequestToBecomeModbeans check=bo.check(bean);
			if(check.getCheck()==0)
			{
			bo.sendRequestToBecomeMod(bean);
			RequestDispatcher rd=request.getRequestDispatcher("profileSERVLET?flag=2");//req sent
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("profileSERVLET?flag=1"); // req exist
				rd.forward(request, response);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
