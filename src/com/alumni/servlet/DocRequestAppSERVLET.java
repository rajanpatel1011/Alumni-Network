package com.alumni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.DocRequestAppBean;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.DocRequestAppBO;

/**
 * Servlet implementation class DocRequestAppSERVLET
 */
@WebServlet("/DocRequestAppSERVLET")
public class DocRequestAppSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		if (lb == null) {
			System.out.println("HEllo Error...!!!!! :D :D");
			// response.sendRedirect("index.jsp?validation=2");
			rd = request.getRequestDispatcher("index.jsp?validation=2");
			rd.forward(request, response);
		} else {
			int m_id = lb.getM_id();
			String email = "jay.jariwala@ymail.com";

			DocRequestAppBean Bean = new DocRequestAppBean();
			Bean.setSubject(request.getParameter("subject"));
			Bean.setData(request.getParameter("description"));
			Bean.setPanding(1);

			if (Bean.getSubject().equals("")) {
				RequestDispatcher dis = request.getRequestDispatcher("DocApp.jsp?flag=3");
				dis.forward(request, response);

			}

			else {

				DocRequestAppBO Bo = new DocRequestAppBO();
				int flag = Bo.DocRequest(Bean, m_id, email);
				if (flag == 1) {
					RequestDispatcher dis = request.getRequestDispatcher("DocApp.jsp?flag=1");
					dis.forward(request, response);

				} else {
					RequestDispatcher dis = request.getRequestDispatcher("DocApp.jsp?flag=2");
					dis.forward(request, response);
				}
			}
		}
	}

}
