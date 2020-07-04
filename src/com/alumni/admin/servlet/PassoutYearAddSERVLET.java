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
import com.alumni.admin.bo.PassoutYearBO;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class PassoutYearAddSERVLET
 */
@WebServlet("/PassoutYearAddSERVLET")
public class PassoutYearAddSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PassoutYearAddSERVLET() {
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
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

		if (bean1 == null) {
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		} else {
			String year = request.getParameter("year");
			if (StringUtils.isEmpty(year)) {
				response.getWriter().print("Empty year field..");
			} else {
				PassoutYearBO bo = new PassoutYearBO();
				// RequestDispatcher rd = null;
				try {

					int success = bo.addYear(year);
					// request.setAttribute("success",success);
					// rd=request.getRequestDispatcher("admin/branch.jsp");
					if (success == 1) {
						response.getWriter().print("Year Successfully Added...");
					} else {
						response.getWriter().print("Invalid Data Entered...");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
//		rd.forward(request, response);
			}
		}
	}
}
