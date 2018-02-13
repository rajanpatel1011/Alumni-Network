package com.alumni.servlet;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.bo.LoginBO;

/**
 * Servlet implementation class LoginSERVLET
 */
@WebServlet("/Login")
public class LoginSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	
		HttpSession session = request.getSession();
		LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
		RequestDispatcher rd = null;
		if(loginBEAN != null){
			int rol=loginBEAN.getRole();
			if(rol == 1) {
				rd = request.getRequestDispatcher("ForumSERVLET");
				//response.sendRedirect("moderator.jsp");
			} else if(rol == 0) {
				//response.sendRedirect("member.jsp?&user="+loginBEAN.getUserName());
				rd = request.getRequestDispatcher("ForumSERVLET");
				//response.sendRedirect("member.jsp");
			}else{
				rd = request.getRequestDispatcher("index.jsp?validation=2");
				//response.sendRedirect("index.jsp?validation=2");
			}
			
		}else{
			rd = request.getRequestDispatcher("index.jsp?validation=2");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

//=======================================================================
		HttpSession session = request.getSession();
//=====================================================================		
		RequestDispatcher rd = null;
		LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");

		int flagChkLogin = 0;
		if(loginBEAN == null){			
				String userId = request.getParameter("uid");
				String password = request.getParameter("pwd");
				
				String check = request.getParameter("check");
				System.out.println("uid :" +userId +"      pwd :"+password + "    check="+check);
				
				if(check == null || "".equals(check)) {
					rd = request.getRequestDispatcher("index.jsp?validation=2");
					rd.forward(request,response);
					return;
				}
				
				LoginBO loginBO = new LoginBO();
				try {
					loginBEAN = loginBO.login(userId,password);
					if(loginBEAN != null){
						int role=loginBEAN.getRole();
						session.setAttribute("loginBEAN",loginBEAN);
						if(role == 1) {
//=====================================================================================================
//=====================================================================================================
							rd = request.getRequestDispatcher("ForumSERVLET");
							//response.sendRedirect("moderator.jsp");
						} else if(role == 0) {
//=====================================================================================================
//=====================================================================================================
							//response.sendRedirect("member.jsp?&user="+userId);
							rd = request.getRequestDispatcher("ForumSERVLET");
							//response.sendRedirect("member.jsp");
						}else{
							//response.sendRedirect("index.jsp?validation=1");
							rd = request.getRequestDispatcher("index.jsp?validation=1");
							flagChkLogin=1;
						}
					}else{
						//response.sendRedirect("index.jsp?validation=1");
						rd = request.getRequestDispatcher("index.jsp?validation=1");
						flagChkLogin=1;
					}

						rd.forward(request, response);
				
				} catch (SQLException e) {
					response.sendRedirect("index.jsp?validation=2 ");
				}finally{
				}
		}
	}

}
