package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.UserRequestBean;
import com.alumni.bo.UserRequestBO;


/**
 * Servlet implementation class UserRequestServlet
 */
@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
			       
	       
		
	String R_value=request.getParameter("r_value");
	String radio =request.getParameter(R_value);
	
	System.out.println("radio = >" + radio);
	if(radio == null){
		RequestDispatcher dis=request.getRequestDispatcher("UserReqDisplaySERVLET?flag=1");
		dis.forward(request,response);
	}else{

		char n1=radio.charAt(0);
		int Tempid=Integer.parseInt(radio.substring(1));
		UserRequestBO BO=new UserRequestBO();
		UserRequestBean bean=BO.usersInfo(Tempid);
		
		if(n1=='Y')
		{	
			int Passlength=5;
			char[] characterSetABC="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
			BO.RandomPassword(characterSetABC,Passlength,bean);
			BO.Email(bean);
			BO.AcceptedUsers(bean);
			BO.DelUsers(bean);		
		}
		else
		{
			BO.RejectedUsers(bean);
			BO.DelUsers(bean);
		}

		RequestDispatcher dis=request.getRequestDispatcher("UserReqDisplaySERVLET");
		dis.forward(request,response);
		}
	}
}
