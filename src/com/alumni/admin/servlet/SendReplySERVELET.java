package com.alumni.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.bo.HelpandSupportBO;

/**
 * Servlet implementation class SendReplySERVELET
 */
@WebServlet("/SendReplySERVELET")
public class SendReplySERVELET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");
		
		if(bean1 == null){
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		}else{
		int e_id=Integer.parseInt(request.getParameter("E_id"));
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		HelpandSupportBO BO=new HelpandSupportBO();
		String flag=BO.Email(email, message);
		if(flag.equals("sent"))
		{
			try {
				BO.deleteHelpandSupport(e_id);
				RequestDispatcher dis=request.getRequestDispatcher("HelpandSupportDisplaySERVELT?flag=1");
				dis.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		}
		
	}

}
