package com.alumni.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

/**
 * Servlet implementation class NewsCreateSERVLET
 */
@WebServlet("/NewsCreateSERVLET")
public class NewsCreateSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCreateSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");
		
		if(bean1 == null){
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		}else{
		String title = request.getParameter("title");
		String discription = request.getParameter("discription");
		int hideStatus = Integer.parseInt(request.getParameter("status"));
		
		NewsBEAN bean = new NewsBEAN();
		bean.setTitle(title);
		bean.setDescription(discription);
		bean.setHideStatus(hideStatus);
		
		NewsBO bo = new NewsBO();
		
		try {
			bean = bo.createNews(bean);
			request.setAttribute("bean",bean);
			rd=request.getRequestDispatcher("admin/createNews.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
	}
		
	}

}
