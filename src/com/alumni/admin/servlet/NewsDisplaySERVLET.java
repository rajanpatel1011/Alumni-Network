package com.alumni.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.beans.NewsBEAN;
import com.alumni.admin.bo.NewsBO;
import com.alumni.beans.LoginBEAN;
import com.alumni.beans.UserRequestBean;

/**
 * Servlet implementation class NewsDisplay
 */
@WebServlet("/NewsDisplaySERVLET")
public class NewsDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsDisplaySERVLET() {
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
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

		if (bean == null) {
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		} else {
			doPost(request, response);
		}

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
			NewsBO bo = new NewsBO();

			RequestDispatcher rs = null;
			List<NewsBEAN> list;

			AdminLoginBEAN bean = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

			if (bean == null) {
				rs = request.getRequestDispatcher("admin/index.jsp?validation=1");
				rs.forward(request, response);
			} else {
				try {
					list = bo.news();
					request.setAttribute("list", list);
					rs = request.getRequestDispatcher("admin/news.jsp");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs.forward(request, response);
			}
		}
	}

}
