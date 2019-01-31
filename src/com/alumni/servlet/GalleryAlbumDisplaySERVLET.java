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
import com.alumni.beans.GalleryAlbumUploadBEAN;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.GalleryAlbumUploadBO;


/**
 * Servlet implementation class GalleryAlbumDisplaySERVLET
 */
@WebServlet("/GalleryAlbumDisplaySERVLET")
public class GalleryAlbumDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		
		int p_id=lb.getP_id();
		int b_id=lb.getB_id();
		
	
		GalleryAlbumUploadBO BO=new GalleryAlbumUploadBO();
		try {
			List<GalleryAlbumUploadBEAN> list=BO.view(p_id,b_id);
			request.setAttribute("list", list);
			session.setAttribute("listA",list);
			session.setAttribute("abc",""+lb.getM_id());
		
			RequestDispatcher rs=request.getRequestDispatcher("GalleryDisplay.jsp");
			rs.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

}
