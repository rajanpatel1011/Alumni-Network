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
import com.alumni.beans.BranchDrpBEAN;
import com.alumni.bo.BranchDrpBO;

/**
 * Servlet implementation class BranchDisplaySERVLET
 */
@WebServlet("/BranchDisplaySERVLET")
public class BranchDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchDisplaySERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		BranchDrpBO branch = new BranchDrpBO();
		try {
			List <BranchDrpBEAN> branchlist = branch.branch();
			if(branchlist == null)
				response.getWriter().write("null");
			else 
			{			
				int n = 1;
				response.getWriter().write("<table width='100%'><tr><th>No.</th><th>Branch</th><th>Delete</th></tr>");
				for(BranchDrpBEAN bean : branchlist) {
					String brancharray = bean.getBranch();
					int id = bean.getBranchId();				
					response.getWriter().write("<tr><td>"+n+"</td><td>"+brancharray+"</td><td><a href='../DelBranchSERVLET?flag="+id+"'><button type=button id=del >Delete</button></a> </td></tr>"); 
					n++;
				}
				response.getWriter().write("</table>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.getWriter().write("null");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().write("null");
		}
		}
	}

}
