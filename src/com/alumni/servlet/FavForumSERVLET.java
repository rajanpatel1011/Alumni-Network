package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.bo.ForumBO;

/**
 * Servlet implementation class FavForumSERVLET
 */
@WebServlet("/FavForumSERVLET")
public class FavForumSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavForumSERVLET() {
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

		int f_Id = Integer.parseInt(request.getParameter("f_id"));
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		// String cmtID = request.getParameter("cmt_ID");
		// session.setAttribute("cmt_Id", cmtID);
		ForumBO bo = new ForumBO();
		try {
			bo.FavForum(f_Id, lb.getM_id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect("Login");
		}
	}

}
