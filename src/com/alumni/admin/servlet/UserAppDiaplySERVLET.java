package com.alumni.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.admin.beans.UserAppBEAN;
import com.alumni.admin.bo.UserAppBO;

/**
 * Servlet implementation class UserAppDiaplySERVLET
 */
@WebServlet("/UserAppDiaplySERVLET")
public class UserAppDiaplySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAppDiaplySERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		UserAppBO bo = new UserAppBO();
		
		try {
			List<UserAppBEAN> bean = bo.displayApp();
			if(bean==null){
			response.getWriter().write("null");	
			}else{
				int n = 1;
				response.getWriter().write("<table class='ma'  border='0'  cellpadding='10' cellspacing='10'><tr><th>No.</th><th>User Name</th><th>Enroll No.</th><th>Subject</th><th>Message</th><th>Status</th><th>Submit</th></tr>");
			for(UserAppBEAN b:bean){
				String a = b.getSenderName();
				String c = b.getEnrollNo();
				String d = b.getSubject();
				String e = b.getData();
				Date f = b.getDate();
				int g = b.getStatus();
				int h = b.getDoc_Id();
				response.getWriter().write("<tr><td>"+n+"</td><td>"+a+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td><select name=status>");
				if(g==1) {
							response.getWriter().write("<option  selected>Pending</option><option >Ready</option>");
						 }else{ 
						 	response.getWriter().write("<option  seleted>Ready</option><option >Pending</option>");
							} 
						response.getWriter().write("</select></td><td><a href='../UpdateUserAppSERVLET?result="+h+"'><button type=button>Submit</button></a></td></tr>");
						n++;
			}
			
			response.getWriter().write("</table>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
