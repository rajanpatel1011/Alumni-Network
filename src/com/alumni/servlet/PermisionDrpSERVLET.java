package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.bo.PermisionDrpBO;
import com.alumni.beans.PermisionDrpBEAN;

@WebServlet("/PermisionDrpSERVLET")
public class PermisionDrpSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PermisionDrpBO pdbo = new PermisionDrpBO();
		try { // EDITINGggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
			//List<Per> pb = pdbo.perm();
			List<PermisionDrpBEAN> pb = pdbo.perm();
			if(pb == null){
				System.out.println("nse");
				response.getWriter().write("null");
			}
			else 
			{
				for(PermisionDrpBEAN bean : pb)
				{
					String permision = bean.getPerm_Name().toUpperCase();
					int id = bean.getPerm_Id();
					//System.out.println("<option value="+id+">"+ permision +"</option>");
					response.getWriter().write("<option value="+id+">"+ permision +"</option>"); 
				}
			}
		} catch (ClassNotFoundException e) {
		
			response.getWriter().write("null");
		} catch (SQLException e) {
		
			response.getWriter().write("null");
		}
	


		
	}

}
