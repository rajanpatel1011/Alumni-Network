package com.alumni.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.DeleteAlbumBEAN;
import com.alumni.bo.DeleteAlbumBO;

/**
 * Servlet implementation class DeleteAlbumSERVLET
 */
@WebServlet("/DeleteAlbumSERVLET")
public class DeleteAlbumSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAlbumSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Param=Integer.parseInt(request.getParameter("value"));
		System.out.println("param"+Param);
		DeleteAlbumBEAN bean=new DeleteAlbumBEAN();
		bean.setA_id(Param);
		DeleteAlbumBO BO=new DeleteAlbumBO();
		try {
			List<DeleteAlbumBEAN> list=BO.DeleteAlbum(bean);
			if(list!=null)
			{
				for(DeleteAlbumBEAN bean1 : list) {
					 System.out.println(bean1.getPic_path());
					 File file=new File(getServletContext().getRealPath("/")+bean1.getPic_path());
					 file.delete();
				}
				BO.deletepic(bean);
				String path=BO.selectImagepath(bean);
				File file=new File(getServletContext().getRealPath("/")+path);
				file.delete();
				BO.deletealbum(bean);
				RequestDispatcher dis=request.getRequestDispatcher("Gallery.jsp");
				dis.forward(request,response);
			}
			else
			{
				String path=BO.selectImagepath(bean);
				File file=new File(getServletContext().getRealPath("/")+path);
				file.delete();
				BO.deletealbum(bean);
				RequestDispatcher dis=request.getRequestDispatcher("Gallery.jsp");
				dis.forward(request, response);
			 	 
			 }
		
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
