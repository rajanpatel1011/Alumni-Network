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
import com.alumni.bo.CommentBO;

/**
 * Servlet implementation class CommentDeleteSERVLET
 */
@WebServlet("/CommentDeleteSERVLET")
public class CommentDeleteSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int c_Id = Integer.parseInt(request.getParameter("c_id"));
		HttpSession session = request.getSession();		
		String cmtID = request.getParameter("cmt_ID");
		session.setAttribute("cmt_Id", cmtID);
		CommentBO bo = new CommentBO();
		try {
			bo.deleteComment(c_Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			response.sendRedirect("Login#"+cmtID);
		}
		
	}

}
