package com.alumni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.ModeratorRequestBean;
import com.alumni.bo.ModerratorRequestBO;

/**
 * Servlet implementation class ModeratorRequestSERVLET
 */
@WebServlet("/ModeratorRequestSERVLET")
public class ModeratorRequestSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
   	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ABt=request.getParameter("Y");
		int  R_Id=Integer.parseInt(request.getParameter("R_Id"));
		String no=request.getParameter("abc");
		
		String [] checkbox=request.getParameterValues(no);
		String checkbox1=request.getParameter(no);
		
		System.out.println("value of checkbox" +checkbox1);
		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		
	int m_id=lb.getM_id();
	int i=0;
	int j=0;
	
	
	
	if(ABt.equals("Accept"))
		{
			if(checkbox1!=null)
			{
			
			
			for(String s: checkbox)
			{
				System.out.println(s);
				if(s.equals("CB"))
					{	
					j++;
					out.println("Redirect"+i); 
					}
				if(s.equals("CA"))
				{
					j++;
					out.println("Redirect"+i);
					i++;
					i++;
				}
				
					
				if(s.equals("UA"))
				{
					i++;
					i++;
					j++;
					j++;
				ModerratorRequestBO BO=new ModerratorRequestBO();
					ModeratorRequestBean selectUserBean=BO.SelcetUser(R_Id);
				ModeratorRequestBean bean=BO.selectedAsMod(m_id);
					ModeratorRequestBean checkbean=BO.checkvote2(bean,selectUserBean);
					if(checkbean.getCheckSelction()==1) 
					{
							j++;
							response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=1");
						 	
					}
					else
					{
						i++;
						j++;	
						j++;
				ModeratorRequestBean bean1=BO.selectedAsMod(m_id);
				ModeratorRequestBean selectUserBean1=BO.SelcetUser(R_Id);
				BO.mod1vote(bean1, selectUserBean1);
					int Flag=BO.AcceptByTwo(selectUserBean1);
				if(Flag==1)
				{
						BO.UserGrantedAsMod(selectUserBean1);
					BO.RejectedModRequest(selectUserBean1);
					
					}
				response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=4");
					
					}  
				
				}
			
				 if(s.equals("UB"))
				 {
					 
				i++;
				j++;
				j++;
				ModerratorRequestBO BO=new ModerratorRequestBO();
				ModeratorRequestBean selectUserBean=BO.SelcetUser(R_Id);
				ModeratorRequestBean bean=BO.selectedAsMod(m_id);
				ModeratorRequestBean checkbean=BO.checkvote(bean,selectUserBean);
				System.out.println(i);
				 if(checkbean.getCheckSelction()==1)
					{
					 	if(i!=4)
					 	{
					 		response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=1");
					 	}
					 	
						 	
				    }
					else
					{
						j++;
						
						ModeratorRequestBean bean1=BO.selectedAsMod(m_id);
						ModeratorRequestBean selectUserBean1=BO.SelcetUser(R_Id);
						BO.mod2vote(bean1, selectUserBean1);
						int Flag=BO.AcceptByTwo(selectUserBean1);
						
						if(Flag==1)
						{
							BO.UserGrantedAsMod(selectUserBean1);
							BO.RejectedModRequest(selectUserBean1);
							
							
						}
						response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=5");
				
					}

					}  
				
						
				}
				
			
			
				if(j==1)
				{
					RequestDispatcher dis=request.getRequestDispatcher("ModeratorReqDisplaySERVLET");
					dis.forward(request, response);
					
					
				}

			}
			else
			{
				response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=2");
			}
				
				
			}
			
		
		 

		
		
		

	
	
		if(ABt.equals("Reject"))
		{
			
			ModerratorRequestBO BO=new ModerratorRequestBO();
			ModeratorRequestBean bean= BO.SelcetUser(R_Id);
			BO.RejectedModRequest(bean);
			response.sendRedirect("ModeratorReqDisplaySERVLET?resultFlag=3");
			
		}
		
		
		
		
	
	
	}

}
