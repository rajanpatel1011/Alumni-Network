package com.alumni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.ForumBean;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.ForumBO;

@WebServlet("/ForumDeleteSERVLET")
public class ForumDeleteSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumDeleteSERVLET() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ForumBean fb;
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		System.out.println("F_id : " + f_id + " Member id :" + lb.getM_id());
		try {
			fb = new ForumBean();

			System.out.println("Get Member ID :" + lb.getM_id() + " Get Creator Id : " + fb.getCreator_id());
			ForumBO fbo = new ForumBO();
			fbo.forumDelete(f_id, lb.getM_id());

		} catch (Exception e) {
			System.out.print(e);
		} finally {

			RequestDispatcher rd = request.getRequestDispatcher("ForumSERVLET");
			rd.forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
