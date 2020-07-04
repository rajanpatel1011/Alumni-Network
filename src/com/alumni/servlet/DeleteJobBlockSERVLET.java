package com.alumni.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.JobBean;
import com.alumni.bo.ProfileBO;

/**
 * Servlet implementation class DeleteJobBlockSERVLET
 */
@WebServlet("/DeleteJobBlockSERVLET")
public class DeleteJobBlockSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteJobBlockSERVLET() {
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

		try {
			JobBean bean = new JobBean();
			ProfileBO bo = new ProfileBO();
			int proffesionaId = Integer.parseInt(request.getParameter("del"));
			bean.setProId(proffesionaId);
			proffesionaId--;
			int af = bo.delJob(bean);
			if (af != 0) {
				response.sendRedirect("EditProfileSERVLET?add=" + proffesionaId + "#1");
			} else {
				response.sendRedirect("EditProfileSERVLET?add=cantdel#1");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("EditProfileSERVLET?add=notdel#1");
		}

	}

}
