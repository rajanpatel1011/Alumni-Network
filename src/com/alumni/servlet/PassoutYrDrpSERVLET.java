package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.PassoutYrDrpBEAN;
import com.alumni.bo.PassoutYrDrpBO;

/**
 * Servlet implementation class PassoutYrDrpSERVLET
 */
@WebServlet("/PassoutYrDrpSERVLET")
public class PassoutYrDrpSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			  
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		PassoutYrDrpBO passyr = new PassoutYrDrpBO();
		try {
			List <PassoutYrDrpBEAN> pyear = passyr.p_years();
			if(pyear == null)
				response.getWriter().write("null");
			else 
			{
				for(PassoutYrDrpBEAN bean : pyear) {
					String year = bean.getPassOutYear();
					int id = bean.getPassOutYearId();
					response.getWriter().write("<option value="+id+">"+ year +"</option>"); 
				}
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
