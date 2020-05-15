package com.alumni.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.admin.beans.UserAppBEAN;
import com.alumni.admin.bo.UserAppBO;

/**
 * Servlet implementation class UpdateUserAppSERVLET
 */
@WebServlet("/UpdateUserAppSERVLET")
public class UpdateUserAppSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserAppSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		UserAppBO bo = new UserAppBO();
		String  f = request.getParameter("result");
		int g = Integer.parseInt(f);
		try {
			
			int st=bo.getStatus(g);
			int me = bo.getmem(g);
			
			String email=bo.getemail(me);
			if(st==1){
				bo.EmailOFF(email);
			}else{
				bo.EmailON(email);
			}
			
			UserAppBEAN bean = new UserAppBEAN();
			bean.setDoc_Id(g);
			bean.setStatus(st);
			bo.updateAppStatus(bean);
			response.sendRedirect("admin/userApp.jsp?flag=3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 response.sendRedirect("admin/userApp.jsp?flag=4");
		}
	}

}
