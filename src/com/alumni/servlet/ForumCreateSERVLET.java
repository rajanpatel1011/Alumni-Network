package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/ForumCreateSERVLET")
public class ForumCreateSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForumCreateSERVLET() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		ForumBean fb = null;
		PrintWriter out = response.getWriter();
		String f1 = request.getParameter("f1");
		String f2 = request.getParameter("f2");
		String f3 = request.getParameter("f3");
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");

		try {

			if (f1 != "" && f2 != "" && f3 != "0") {
				int f33 = Integer.parseInt(f3);
				out.print(f1 + ": Subject\n");
				out.print(f2 + ":Description \n");
				out.print(f3);

				fb = new ForumBean();

				fb.setP_sub(f1);
				fb.setDesription(f2);
				fb.setPerm_id(f33);
				fb.setCreator_id(lb.getM_id()); // ************* NEEEEEEEEEEEEEEEEEEED to be placed.

				ForumBO fbo = new ForumBO();
				fbo.createForum(fb);
			} else {
				response.sendRedirect("forum.jsp");
			}

		} catch (Exception e) {
			System.out.print(e);
		} finally {

			RequestDispatcher rd = request.getRequestDispatcher("ForumSERVLET");
			rd.forward(request, response);

		}

	}

}
