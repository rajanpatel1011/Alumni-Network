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
import com.alumni.beans.MsgBEAN;
import com.alumni.bo.MsgBO;

@WebServlet("/MsgSERVLET")
public class MsgSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MsgSERVLET() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
    	doPost(request, response);
    }@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		MsgBO mbo = new MsgBO();    			
		try 
		{
			HttpSession session = request.getSession();
			LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
			
			
			List<MsgBEAN> list = mbo.msg(lb.getM_id());
			//List<MsgBEAN> list = mbo.msg(1);
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
			rd.forward(request, response);
		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{    			
			e.printStackTrace();
		}
	}

}
