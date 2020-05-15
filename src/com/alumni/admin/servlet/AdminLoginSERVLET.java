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
import com.alumni.admin.bo.AdminLoginBO;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.LoginBO;

/**
 * Servlet implementation class AdminLoginSERVLET
 */
@WebServlet("/AdminLoginSERVLET")
public class AdminLoginSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		HttpSession session = request.getSession();
		
		
		RequestDispatcher rd = null;
		AdminLoginBEAN bean = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

		int flagChkLogin = 0;
		if(bean == null){			
				String uname =request.getParameter("uname");
				String pwd =request.getParameter("pwd");
				String urlFlag = request.getParameter("urlFlag");
				
				if(uname == null || "".equals(uname) || pwd == null || "".equals(pwd)){
					rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
					rd.forward(request,response);
					return;
				}
				String check = request.getParameter("check");
				System.out.println("uid :" +uname +"      pwd :"+pwd + "    check="+check);
				
				if(check == null || "".equals(check)) {
					rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
					rd.forward(request,response);
					return;
				}
				
				AdminLoginBO loginBO = new AdminLoginBO();
				try {
					bean = loginBO.login(uname,pwd);
					if(bean != null){					
						session.setAttribute("adminloginBEAN",bean);
						if(bean.isLoggedin()){
							if(urlFlag.equals("one")){
								rd = request.getRequestDispatcher("../NewsDisplaySERVLET");
							}else{
								rd = request.getRequestDispatcher("NewsDisplaySERVLET");
							}
							
						}else{
							System.out.println("bean is not loggedin");
							rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
						}
						//response.sendRedirect("moderator.jsp");
					}else{
						//response.sendRedirect("index.jsp?validation=1");
						response.sendRedirect("admin/index.jsp?validation=2");
						flagChkLogin=1;
					}
					try{
					rd.forward(request, response);
					}catch(Exception e){
						rd = request.getRequestDispatcher("NewsDisplaySERVLET");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					response.sendRedirect("admin/index.jsp?validation=1");
					System.out.println(e);
				}finally{
					
				}
		}
	}
}
