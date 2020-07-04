package com.alumni.servlet;

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

import com.alumni.beans.EducationBEAN;
import com.alumni.beans.LoginBEAN;
import com.alumni.beans.MemhobbiesBEAN;
import com.alumni.beans.ProfileBEAN;
import com.alumni.bo.ProfileBO;

/**
 * Servlet implementation class EditProfileSERVLET
 */
@WebServlet("/EditProfileSERVLET")

public class EditProfileSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfileSERVLET() {
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

		ProfileBO profile = new ProfileBO();
		ProfileBEAN bean;
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		try {

			bean = profile.fetch(lb.getM_id());
			request.setAttribute("EditProfilebean", bean);

			List<EducationBEAN> dbean = profile.alldegree(lb.getM_id());
			request.setAttribute("degreelist", dbean);

			List<MemhobbiesBEAN> hbean = profile.getAllListOfHobbies();
			request.setAttribute("hobbieslist", hbean);

			RequestDispatcher rq = request.getRequestDispatcher("EditProfile.jsp");
			rq.forward(request, response);

		}

		catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			RequestDispatcher rq = request.getRequestDispatcher("EditProfile.jsp");
			rq.forward(request, response);
		}

	}

}
