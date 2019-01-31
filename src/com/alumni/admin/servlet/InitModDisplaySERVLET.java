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
import com.alumni.admin.beans.InitModBEAN;
import com.alumni.admin.bo.InitModBO;

/**
 * Servlet implementation class InitModDisplaySERVLET
 */
@WebServlet("/InitModDisplaySERVLET")
public class InitModDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitModDisplaySERVLET() {
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
		InitModBO bo = new InitModBO();
		try {
			List <InitModBEAN> list = bo.getIntUserList();
			if(list == null)
				response.getWriter().write("null");
			else 
			{
				int n = 1;
				response.getWriter().write("<table width='100%' style='margin-left:0px;'><tr><th>No.</th><th>First Name</th><th>Last Name</th><th>Branch</th><th>Year</th><th>Become moderator</th></tr><tr><td colspan='6'><hr/></td></tr>");
				for(InitModBEAN bean : list) {
					int mid = bean.getM_Id();
					String fname = bean.getF_name();
					String lname = bean.getL_name();
					String beanch = bean.getBranch_name();
					String year = bean.getYear();
					
					response.getWriter().write("<tr><td>"+n+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+beanch+"</td><td>"+year+"</td><td><a href='../BecomemInitModSERVLET?flag="+mid+"'><button type='button'>Become Moderator</button></a></td></tr>"); 
					n++;
				}
				response.getWriter().write("</table>");
			}
		} catch (SQLException e) {
			response.getWriter().write("null");
		}
		}
	}

}
