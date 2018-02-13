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
import com.alumni.beans.RepotUserBEAN;
import com.alumni.bo.StudentBO;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class ReportstudentSERVLET
 */
@WebServlet("/ReportstudentSERVLET")
public class ReportstudentSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportstudentSERVLET() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

	       HttpSession session = request.getSession();
			LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
			RequestDispatcher rd;
			if(lb == null){
				rd = request.getRequestDispatcher("index.jsp?validation=2");
				rd.forward(request,response);
			}else{
				StudentBO bo = new StudentBO();
				RepotUserBEAN reportbean = new RepotUserBEAN();
				String st=request.getParameter("id");
				int id = Integer.parseInt(st);
				String msg= request.getParameter("msg");
			if(StringUtils.isNullOrEmpty(msg)||StringUtils.isEmptyOrWhitespaceOnly(msg)){
				reportbean.setIssuMsg("No message");
			}else{
				reportbean.setIssuMsg(msg);
			}
				reportbean.setReportedId(id);
				reportbean.setReporterId(lb.getM_id());
				
				try {
					int max = bo.checkReportedUser(reportbean);
					if(max!=10){
						
					 	int f = bo.checkReporterUser(reportbean);
					 	 	if(f==0){
					 	 			bo.reportStudent(reportbean);
					 	 			RequestDispatcher r = request.getRequestDispatcher("StudentSERVLET?flag=2");
					 	 			r.forward(request, response);
					 	 	}else{
					 	 		 	RequestDispatcher r = request.getRequestDispatcher("StudentSERVLET?flag=1");
					 	 		 	r.forward(request, response);
					 	 		}
					}else{
					 	 		RequestDispatcher r = request.getRequestDispatcher("StudentSERVLET?flag=4");
				 	 		 	r.forward(request, response);
					 	 	}
				} catch (SQLException e) {
					e.printStackTrace();
					RequestDispatcher r = request.getRequestDispatcher("StudentSERVLET?flag=3");
					r.forward(request, response);
		}
		
	}
	}
}
