package com.alumni.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.beans.EventCreateBEAN;
import com.alumni.admin.bo.EventBO;

/**
 * Servlet implementation class EventDeleteSERVLET
 */
@WebServlet("/EventDeleteSERVLET")
public class EventDeleteSERVLET extends HttpServlet {
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
			int e_id = Integer.parseInt(request.getParameter("param"));
			EventBO BO = new EventBO();
			EventCreateBEAN bean = new EventCreateBEAN();
			bean.setE_id(e_id);
			BO.DeleteEvent(bean);
			RequestDispatcher dis = request.getRequestDispatcher("EventDisplaySERVLET");
			dis.forward(request, response);

		}
	}

}
