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
import com.alumni.admin.beans.InitModBEAN;
import com.alumni.admin.bo.InitModBO;

/**
 * Servlet implementation class BecomemInitModSERVLET
 */
@WebServlet("/BecomemInitModSERVLET")
public class BecomemInitModSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BecomemInitModSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String flsg=request.getParameter("flag");
		System.out.println("In server"+flsg);
		InitModBEAN bean;
		InitModBO bo = new InitModBO();
		try {
			
			bean = new InitModBEAN();
			//bean.setM_Id(bo.getMemId(Integer.parseInt(flsg)));
			bean.setM_Id(Integer.parseInt(flsg));
			bo.BecomeInitMod(bean);
			response.sendRedirect("admin/initMod.jsp?result=1");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendRedirect("admin/initMod.jsp?result=2");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("admin/initMod.jsp?result=3");
		}
		}
	}

}
