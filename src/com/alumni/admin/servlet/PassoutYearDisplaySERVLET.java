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
import com.alumni.beans.PassoutYrDrpBEAN;
import com.alumni.bo.PassoutYrDrpBO;

/**
 * Servlet implementation class PassoutYearDisplaySERVLET
 */
@WebServlet("/PassoutYearDisplaySERVLET")
public class PassoutYearDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassoutYearDisplaySERVLET() {
        super();
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
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");
		
		if(bean1 == null){
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		}else{
				PassoutYrDrpBO passyr = new PassoutYrDrpBO();
				try {
					List <PassoutYrDrpBEAN> pyear = passyr.p_years();
					if(pyear == null)
						response.getWriter().write("null");
					else 
					{
						int n = 1;
						response.getWriter().write("<table width='100%'><tr><th>No.</th><th>Passout Year</th><th>Delete</th></tr><tr><td colspan='3'><hr/></td></tr>");
						for(PassoutYrDrpBEAN bean : pyear) {
							String year = bean.getPassOutYear();
							int id = bean.getPassOutYearId();
							response.getWriter().write("<tr><td>"+n+"</td><td>"+year+"</td><td><a href='../DelPassoutYearSERVLET?flag="+id+"'><button type=button id=del >Delete</button></a> </td></tr>"); 
							//System.out.println("<tr><td>"+n+"</td><td>"+year+"</td></tr>");
							n++;
						}
						response.getWriter().write("</table>");
					}
				} catch (ClassNotFoundException e) {
					response.getWriter().write("null");
				} catch (SQLException e) {
					response.getWriter().write("null");
				}
	}
	}

}
