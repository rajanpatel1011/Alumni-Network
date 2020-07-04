package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.ReportedUserBEAN;
import com.alumni.bo.ReportedUserBO;

@WebServlet("/ReportedUserWarnSERVLET")
public class ReportedUserWarnSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReportedUserBEAN rtdub = null;
		PrintWriter out = response.getWriter();
		String warning_msg = request.getParameter("warn");
		String rtd_uid = request.getParameter("user");
		int reported_User_Id = Integer.parseInt(rtd_uid);

		try {

			if (warning_msg != "") {
				rtdub = new ReportedUserBEAN();

				rtdub.setWrng_msg(warning_msg);
				ReportedUserBO rtdubo = new ReportedUserBO();
				rtdubo.reportedUserWarnBO(reported_User_Id);
				out.print("Warning msg=" + warning_msg);
				out.print("User id=" + reported_User_Id);
				RequestDispatcher rd = request.getRequestDispatcher("ReportedUserViewSERVLET");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("ReportedUser.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			System.out.print(e);
		}

	}

}
