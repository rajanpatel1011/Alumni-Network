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

import com.alumni.beans.ForumBean;
import com.alumni.bo.ForumBO;
import com.alumni.beans.LoginBEAN;

/**
 * Servlet implementation class ForumSERVLET
 */
@WebServlet("/ForumSERVLET")
public class ForumSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		if(lb == null){
			System.out.println("HEllo Error...!!!!! :D :D");
			//response.sendRedirect("index.jsp?validation=2");
			rd = request.getRequestDispatcher("index.jsp?validation=2");
			rd.forward(request, response);
		}else{
			doPost(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

			ForumBO fbo = new ForumBO();    			
			try 
			{
				RequestDispatcher rd;
				HttpSession session = request.getSession();
				LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
				if(lb == null){
					System.out.println("HEllo Error...!!!!! :D :D");
					//response.sendRedirect("index.jsp?validation=2");
					rd = request.getRequestDispatcher("index.jsp?validation=2");
				}else{
						List<ForumBean> list = fbo.forum(lb.getB_id(),lb.getP_id(),lb.getM_id());    			 
						//		List<ForumBean> list = fbo.forum();
						request.setAttribute("list", list);
						rd = request.getRequestDispatcher("forum.jsp");
				}
				rd.forward(request, response);
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (Exception e)
			{    			
				e.printStackTrace();
			}
	}

}
