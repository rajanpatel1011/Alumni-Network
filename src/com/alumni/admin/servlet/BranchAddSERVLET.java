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
import com.alumni.admin.bo.BranchBO;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class BranchAddSERVLET
 */
@WebServlet("/BranchAddSERVLET")
public class BranchAddSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BranchAddSERVLET() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

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
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

		if (bean == null) {
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		} else {
			String branch = request.getParameter("inputbranch");
			BranchBO bo = new BranchBO();
			if (StringUtils.isEmpty(branch)) {
				response.getWriter().print("empty branch..");
			} else {
				// RequestDispatcher rd = null;
				try {

					int success = bo.addBranch(branch);
					// request.setAttribute("success",success);
					// rd=request.getRequestDispatcher("admin/branch.jsp");
					if (success == 1) {
						response.getWriter().print("Branch Successfully Added...");
					} else {
						response.getWriter().print("Invalid Data Entered...");
					}

				} catch (SQLException e) {
					response.getWriter().print("Internal error..!!");
					e.printStackTrace();
				}
//		rd.forward(request, response);
			}
		}
	}
}
