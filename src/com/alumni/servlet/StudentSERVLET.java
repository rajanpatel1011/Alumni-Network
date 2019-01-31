package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.ProfileBEAN;
import com.alumni.bo.ProfileBO;

/**
 * Servlet implementation class StudentSERVLET
 */
@WebServlet("/StudentSERVLET")
public class StudentSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSERVLET() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		 ProfileBO profile=new ProfileBO();        
       ProfileBEAN bean;
       HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		RequestDispatcher rd;
		if(lb == null){
			rd = request.getRequestDispatcher("index.jsp?validation=2");
			rd.forward(request,response);
		}else{
			
//----------- visting id--- 		
		String st=request.getParameter("id");
		int id = Integer.parseInt(st);
//----------------------------------------------
		if(lb.getM_id()==id){
			RequestDispatcher rq = request.getRequestDispatcher("profileSERVLET");
			rq.forward(request, response);
		}else{
			try {
				bean = profile.fetch(id);
				request.setAttribute("Profilebean", bean);			
				request.setAttribute("id",id);
				RequestDispatcher rq=request.getRequestDispatcher("student.jsp?id="+st);
	        	rq.forward(request,response);
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		}
}
}