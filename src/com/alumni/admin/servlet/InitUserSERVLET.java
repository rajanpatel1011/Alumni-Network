package com.alumni.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.beans.InitBEAN;
import com.alumni.admin.bo.InitUserBO;

/**
 * Servlet implementation class InitUserSERVLET
 */
@WebServlet("/InitUserSERVLET")
public class InitUserSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitUserSERVLET() {
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
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");
		
		if(bean1 == null){
			rd = request.getRequestDispatcher("admin/index.jsp?validation=1");
			rd.forward(request, response);
		}else{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender"); 
		String dob = request.getParameter("dob");
		String emailId = request.getParameter("email");
		String passyear = request.getParameter("inputPassyr");
		String branch = request.getParameter("branch");
		String enrNo = request.getParameter("enrno");
		String UID = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		PrintWriter out = response.getWriter();
		InitBEAN bean = new  InitBEAN();
		InitUserBO bo = new InitUserBO();
		if(pwd.equals(cpwd)){
			bean.setPwd(pwd);
			bean.setFname(fname);
			bean.setLname(lname);
			bean.setGender(gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date d = null;	
			try {
				d = sdf.parse(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}		
			bean.setDob(d);
			bean.setEmailId(emailId);
			bean.setPassyear(Integer.parseInt(passyear));
			bean.setBranch(Integer.parseInt(branch));
			bean.setEnrNo(enrNo);
			bean.setUID(UID);
			
			try {
				bean = bo.adduser(bean);
				if(bean.getSuccess()){
					out.print("User Successfully Register...");
				}else{
					out.print("Incorrect Data Enterd.");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.print("pwd");
		}
		
	}
	}

}
