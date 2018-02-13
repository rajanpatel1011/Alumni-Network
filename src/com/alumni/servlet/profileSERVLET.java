package com.alumni.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.ProfileBEAN;
import com.alumni.beans.sendRequestToBecomeModbeans;
import com.alumni.bo.ProfileBO;
import com.alumni.bo.SendRequestTobecomeModBO;




@WebServlet("/profileSERVLET")
public class profileSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public profileSERVLET() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		 ProfileBO profile=new ProfileBO();        
       ProfileBEAN bean;
       
       HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");

		RequestDispatcher rd;
		if(lb == null){
			System.out.println("HEllo Error...!!!!! :D :D");
			//response.sendRedirect("index.jsp?validation=2");
			rd = request.getRequestDispatcher("index.jsp?validation=2");
			rd.forward(request,response);
		}else{
			try {
				sendRequestToBecomeModbeans sendbean = new sendRequestToBecomeModbeans();
				sendbean.setBid(lb.getB_id());
				sendbean.setPid(lb.getP_id());
				sendbean.setM_id(lb.getM_id());
				
				SendRequestTobecomeModBO bo = new SendRequestTobecomeModBO();
				
				sendRequestToBecomeModbeans sendbean2=bo.mod(sendbean);
				sendRequestToBecomeModbeans sendbean1=bo.canBeMod(sendbean);
				
				request.setAttribute("flag",""+sendbean1.getEnable());
				request.setAttribute("acctype",""+ sendbean2.getAcctype());
				
				bean = profile.fetch(lb.getM_id());
				request.setAttribute("Profilebean", bean);			
				RequestDispatcher rq=request.getRequestDispatcher("Profile.jsp");
	        	rq.forward(request,response);
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
//>>>>>>> .r76
		//--------------empty field-----------------
		//	RequestDispatcher ff=request.getRequestDispatcher("profile.jsp");
		//	ff.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		RequestDispatcher rd;
		HttpSession session1 = request.getSession();
		LoginBEAN lb1 = (LoginBEAN) session1.getAttribute("loginBEAN");
		if(lb1 == null){
			System.out.println("HEllo Error...!!!!! :D :D");
			//response.sendRedirect("index.jsp?validation=2");
			rd = request.getRequestDispatcher("index.jsp?validation=2");
			rd.forward(request,response);
		}else{
				ProfileBO profile=new ProfileBO();        
				ProfileBEAN bean;     
				try {
					sendRequestToBecomeModbeans sendbean = new sendRequestToBecomeModbeans();
					sendbean.setBid(lb1.getB_id());
					sendbean.setPid(lb1.getP_id());
					sendbean.setM_id(lb1.getM_id());
					
					SendRequestTobecomeModBO bo = new SendRequestTobecomeModBO();
					
					sendRequestToBecomeModbeans sendbean2=bo.mod(sendbean);
					sendRequestToBecomeModbeans sendbean1=bo.canBeMod(sendbean);
					
					request.setAttribute("flag",""+sendbean1.getEnable());
					request.setAttribute("acctype",""+ sendbean2.getAcctype());
					
					bean = profile.fetch(lb1.getM_id());
					 request.setAttribute("Profilebean", bean);			
			        RequestDispatcher rq=request.getRequestDispatcher("Profile.jsp");
			        rq.forward(request,response);
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
//>>>>>>> .r76
		//--------------empty field-----------------
		//	RequestDispatcher ff=request.getRequestDispatcher("profile.jsp");
		//	ff.forward(request, response);
		}
				
	}
	}


