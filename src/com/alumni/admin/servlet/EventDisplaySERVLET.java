package com.alumni.admin.servlet;

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

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.beans.EventDisplayBEAN;
import com.alumni.admin.bo.EventBO;

/**
 * Servlet implementation class EventDisplaySERVLET
 */
@WebServlet("/EventDisplaySERVLET")
public class EventDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		EventBO BO=new EventBO();
		try {
			List<EventDisplayBEAN> bean=BO.EventDisplay();
			request.setAttribute("List",bean);
			RequestDispatcher dis=request.getRequestDispatcher("admin/events.jsp");
			dis.forward(request, response);
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
		
	}

}
