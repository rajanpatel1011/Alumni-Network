package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alumni.beans.BranchDrpBEAN;
import com.alumni.bo.BranchDrpBO;

/**
 * Servlet implementation class BranchDrpSERVLET
 */
@WebServlet("/BranchDrpSERVLET")
public class BranchDrpSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		BranchDrpBO branch = new BranchDrpBO();
		try {
			List<BranchDrpBEAN> branchlist = branch.branch();
			if (branchlist == null)
				response.getWriter().write("null");
			else {
				for (BranchDrpBEAN bean : branchlist) {
					String brancharray = bean.getBranch();
					int id = bean.getBranchId();
					response.getWriter().write("<option value=" + id + ">" + brancharray + "</option>");
				}
			}
		} catch (ClassNotFoundException e) {
			response.getWriter().write("null");
		} catch (SQLException e) {
			response.getWriter().write("null");
		}

	}
}