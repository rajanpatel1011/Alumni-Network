package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.JobBean;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.ProfileBO;

/**
 * Servlet implementation class AddJobInProfile
 */
@WebServlet("/AddJobInProfile")
public class AddJobInProfileSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddJobInProfileSERVLET() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
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
		// int count=0;
		// response.setContentType("text/plain");
		// count ++;
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");

		int b = 0;
		ProfileBO bo = new ProfileBO();
		JobBean bean = new JobBean();
		bean.setM_Id(lb.getM_id());
		try {
			b = bo.addJob(bean);
			// request.setAttribute("add",b);
			response.sendRedirect("EditProfileSERVLET?add=" + b + "#1");

		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("EditProfileSERVLET?add=notadd#1");

		}

	}
}
