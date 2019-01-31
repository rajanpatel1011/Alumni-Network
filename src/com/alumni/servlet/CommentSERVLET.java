package com.alumni.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.CommentBEAN;
import com.alumni.beans.ForumBean;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.CommentBO;

/**
 * Servlet implementation class CommentSERVLET
 */
@WebServlet("/CommentSERVLET")
public class CommentSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		//String forumId = request.getParameter("forumId");
		//String commentId = request.getParameter("commentId");
		CommentBO bo = new CommentBO();
		try 
		{
			RequestDispatcher rd;
			HttpSession session = request.getSession();
			LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
			if(lb == null){
				System.out.println("HEllo Error...!!!!! :D :D");
				response.sendRedirect("index.jsp?validation=2");
			}else{
					String addcomment = request.getParameter("addcomment");
					String f_Id = request.getParameter("f_Id");
					int cr_id = lb.getM_id();
					String cmtID = request.getParameter("cmt_ID");
					System.out.print("comment id ="+cmtID);
					bo.AddComments(addcomment,f_Id,cr_id);					
					session.setAttribute("cmt_Id", cmtID);
					response.sendRedirect("Login#"+cmtID);
					//rd = request.getRequestDispatcher("index.jsp#"+cmtID);
					
			}
		//	rd.forward(request, response);
			return;
		}
		catch (Exception e)
		{    			
			e.printStackTrace();
		}
		
	}

}
