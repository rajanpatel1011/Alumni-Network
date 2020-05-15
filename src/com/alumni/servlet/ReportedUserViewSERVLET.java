package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.ReportedUserBEAN;
import com.alumni.bo.ReportedUserBO;

/**
 * Servlet implementation class ReportedUserViewSERVLET
 */
@WebServlet("/ReportedUserViewSERVLET")
public class ReportedUserViewSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportedUserViewSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReportedUserBO rubo = new ReportedUserBO();    			
		try 
		{
			HttpSession session = request.getSession();
			LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
			
			List<ReportedUserBEAN> list = rubo.reportedUserViewBO(lb.getB_id(),lb.getP_id());    			 
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("ReportedUser.jsp");
			rd.forward(request, response);
		
		}
		catch (ClassNotFoundException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ReportedUser.jsp?flag=1");
			rd.forward(request, response);
		}
		catch (SQLException e)
		{    			
			RequestDispatcher rd = request.getRequestDispatcher("ReportedUser.jsp?flag=2");
			rd.forward(request, response);
		}
		
		

		
		
		
	}

}
