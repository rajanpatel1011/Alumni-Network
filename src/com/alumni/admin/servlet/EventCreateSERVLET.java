package com.alumni.admin.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.alumni.admin.beans.AdminLoginBEAN;
import com.alumni.admin.beans.EventCreateBEAN;
import com.alumni.admin.bo.EventBO;

/**
 * Servlet implementation class EventCreateSERVLET
 */
@WebServlet("/EventCreateSERVLET")
@MultipartConfig(location="c:/temp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class EventCreateSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	@Override
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
		response.setContentType("text/html;charset=UTF-8");
		final String path=request.getServletContext().getRealPath("/")+"images\\Event\\";
		 final Part filePart = request.getPart("imagefile");
		    Collection<String> headers = filePart.getHeaderNames();
		    for(String c: headers) {
		    	System.out.println(c + "        " + filePart.getHeader(c));
		    }
		    final String fileName = getFileName(filePart);
		    String title=request.getParameter("title"); 	
		    String Date=request.getParameter("OrgDate");
		    String description=request.getParameter("description");
		    System.out.println(title);
		    if(title.equals("") || Date.equals("") || description.equals("") || fileName.equals(""))
		    {
		    	System.out.println("In If loop");
		    	RequestDispatcher dis=request.getRequestDispatcher("admin/createEvents.jsp?flag=1");
		    	dis.forward(request, response);
		    	
		    }
		    else
		    {
		    OutputStream out = null;
		    InputStream filecontent = null;
		    final PrintWriter writer = response.getWriter();
		    Date date1=new Date();
		    SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
		    
			
				
			
		    long Timestamp=date1.getTime();

		    try {
		        out = new FileOutputStream(new File(path + File.separator
		        		+Timestamp + fileName));
		        filecontent = filePart.getInputStream();
		        String Filepath="images/Event/"+Timestamp+fileName;
		    	Date newDate=formetter.parse(Date);
				EventCreateBEAN bean=new EventCreateBEAN();
				bean.setTitle(title);
				bean.setDescription(description);
				bean.setOrgdate(newDate);
				bean.setEvent_pic(Filepath);
				EventBO BO=new EventBO();
				BO.CreateEvent(bean);
				RequestDispatcher dis=request.getRequestDispatcher("admin/createEvents.jsp?falg=2");
				dis.forward(request, response);
				
	
		        
		        
		        int read = 0;
		        final byte[] bytes = new byte[1024];

		        while ((read = filecontent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		      
		    } catch (FileNotFoundException fne) {
		        writer.println("You either did not specify a file to upload or are "
		                + "trying to upload a file to a protected or nonexistent "
		                + "location.");
		        writer.println("<br/> ERROR: " + fne.getMessage());

		    } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        if (out != null) {
		            out.close();
		        }
		        if (filecontent != null) {
		            filecontent.close();
		        }
		        if (writer != null) {
		            writer.close();
		        }
		    }
		    }
	}
		}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
		
		
		
		
	}


