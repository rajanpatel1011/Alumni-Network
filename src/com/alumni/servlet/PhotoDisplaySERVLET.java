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

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.PhotoUploadBean;
import com.alumni.bo.PhotoUploadBO;

/**
 * Servlet implementation class PhotoDisplaySERVLET
 */
@WebServlet("/PhotoDisplaySERVLET")
public class PhotoDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PhotoDisplaySERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		doPost(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		
		int p_id=lb.getP_id();
		int b_id=lb.getB_id();
		String a_id=request.getParameter("param");
		int a_id1=Integer.parseInt(a_id);
		
	
		
		
	
		PhotoUploadBO BO=new PhotoUploadBO();
		try {
			request.setAttribute("a_id",a_id);
			List<PhotoUploadBean> list=BO.view(p_id, b_id,a_id1);
			request.setAttribute("list", list);
			request.setAttribute("delete",""+lb.getM_id());
			RequestDispatcher rs=request.getRequestDispatcher("ImageViewer.jsp");
			rs.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rs=request.getRequestDispatcher("ImageViewer.jsp?Flag=10");
			rs.forward(request, response);
			
		}
	
	
	}

}
