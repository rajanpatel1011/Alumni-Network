package com.alumni.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.PhotoUploadBean;
import com.alumni.bo.DeletePicBO;

/**
 * Servlet implementation class DeletePicServlet
 */
@WebServlet("/DeletePicServlet")
public class DeletePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ph_value = Integer.parseInt(request.getParameter("value"));

		int a_id = Integer.parseInt(request.getParameter("a_id"));
		System.out.println("value of album" + a_id);
		DeletePicBO bo = new DeletePicBO();
		PhotoUploadBean bean = new PhotoUploadBean();
		bean.setPhoto_id(ph_value);
		try {
			String s = bo.SelectPhoto(bean);
			File file = new File(getServletContext().getRealPath("/") + s);
			file.delete();
			bo.deletePhoto(bean);
			RequestDispatcher dis = request.getRequestDispatcher("PhotoDisplaySERVLET?param=" + a_id);
			dis.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
