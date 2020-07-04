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

/**
 * Servlet implementation class DelBranchSERVLET
 */
@WebServlet("/DelBranchSERVLET")
public class DelBranchSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelBranchSERVLET() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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
			BranchBO bo = new BranchBO();
			String flag = request.getParameter("flag");
			int flag1 = Integer.parseInt(flag);
			if (flag == null) {
			} else {
				try {
					bo.delectBranch(flag1);
					response.sendRedirect("admin/branch.jsp?result=1");
				} catch (SQLException e) {
					response.sendRedirect("admin/branch.jsp?result=2");
					e.printStackTrace();
				}
			}
		}
	}

}
