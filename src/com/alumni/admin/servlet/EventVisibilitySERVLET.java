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
import com.alumni.admin.bo.EventBO;

/**
 * Servlet implementation class EventVisibilitySERVLET
 */
@WebServlet("/EventVisibilitySERVLET")
public class EventVisibilitySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

		if (bean1 == null) {
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		} else {
			int e_id = Integer.parseInt(request.getParameter("hidden"));
			int visibility = Integer.parseInt(request.getParameter("option"));

			if (visibility == 1) {
				EventBO BO = new EventBO();
				try {
					BO.eventvisibilltyON(e_id);
					RequestDispatcher dis = request.getRequestDispatcher("EventDisplaySERVLET?flag=1");
					dis.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e);
				}

			}
			if (visibility == 2) {
				EventBO BO = new EventBO();
				try {
					BO.eventvisibilltyOFF(e_id);
					RequestDispatcher dis = request.getRequestDispatcher("EventDisplaySERVLET?flag=2");
					dis.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
