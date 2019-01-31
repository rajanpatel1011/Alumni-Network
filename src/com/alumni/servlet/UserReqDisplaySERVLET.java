package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.alumni.beans.UserRequestBean;
import com.alumni.bo.UserRequestBO;

/**
 * Servlet implementation class UserReqDisplaySERVLET
 */
@WebServlet("/UserReqDisplaySERVLET")
public class UserReqDisplaySERVLET extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		UserRequestBO bo=new UserRequestBO();
	    
		HttpSession session = request.getSession();
		LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
		if(loginBEAN == null){
			System.out.println("HEllo Error...!!!!! :D :D");
			response.sendRedirect("index.jsp?validation=2");
		}else{
		
			try {
				List<UserRequestBean> list = bo.users(loginBEAN.getM_id(),loginBEAN.getB_id(),loginBEAN.getP_id());
				request.setAttribute("list",list);
				RequestDispatcher rs=request.getRequestDispatcher("UserRequest.jsp");
				rs.forward(request, response);
				

		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
