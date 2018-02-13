package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.beans.ModeratorRequestBean;
import com.alumni.beans.UserRequestBean;
import com.alumni.bo.ModerratorRequestBO;;

/**
 * Servlet implementation class ModeratorReqDisplaySERVLET
 */
@WebServlet("/ModeratorReqDisplaySERVLET")
public class ModeratorReqDisplaySERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeratorReqDisplaySERVLET() {
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
		ModerratorRequestBO BO=new ModerratorRequestBO();
		try {
			List<ModeratorRequestBean> list=BO.DisplayModRequest();
			request.setAttribute("list",list);
			RequestDispatcher rs=request.getRequestDispatcher("ModeratorRequest.jsp");
			rs.forward(request, response);
			String resultFlag=request.getParameter("resultFlag");
			if(resultFlag!=null && !"".equals(resultFlag))
			{
				PrintWriter out=response.getWriter();
				out.println("You can vote only 1 member!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
