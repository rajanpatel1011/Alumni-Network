package com.alumni.servlet;

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

import com.alumni.beans.LoginBEAN;
import com.alumni.beans.PhotoUploadBean;
import com.alumni.bo.PhotoUploadBO;

/**
 * Servlet implementation class PhotosUplodSERVELET
 */
@WebServlet("/PhotosUplodSERVELET")
@MultipartConfig(location="http://alumninetwork.datadoctorr.com/alumni/tmp/", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class PhotosUplodSERVELET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       		
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

	    // Create path components to save the file
		final String path = getServletContext().getRealPath("/") + "images\\Album\\";
//		final String path = "http://alumninetwork.datadoctorr.com/alumni/imageUpload/";

	    int Album_id=Integer.parseInt(request.getParameter("Album_id"));
	    HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
	    
	    int m_id=lb.getM_id();
	    String Pic_title=request.getParameter("aalbum_name");

	    if(Pic_title.equals(""))
	    {
	    	response.sendRedirect("PhotoDisplaySERVLET?resultFlag=1");
	    }
	    else
	    {
	    	int pic_privacy=Integer.parseInt(request.getParameter("privacy"));
	    	if(pic_privacy==0)
	    	{
	    		response.sendRedirect("PhotoDisplaySERVLET?resultFlag=2");
	    	}
	    	else
	    	{
	    	String caption=request.getParameter("caption");
	    		if(caption.equals(""))
	    		{
	    		response.sendRedirect("PhotoDisplaySERVLET?resultFlag=3");
	    		}
	    		else
	    		{
	    	String taken_date=request.getParameter("Date");
	    	if(taken_date.equals(""))
	    	{
	    		response.sendRedirect("PhotoDisplaySERVLET?resultFlag=4");
	    	}
	    	else
	    	{
	    		
	    	
	    	
	    	final Part filePart = request.getPart("images");
	    	Collection<String> headers = filePart.getHeaderNames();
	    	for(String c: headers) {
	    	System.out.println(c + "        " + filePart.getHeader(c));
	    	}
	    	final String fileName = getFileName(filePart);
	    	
	    	if(fileName ==null)
	    	{
	    		
	    		response.sendRedirect("PhotoDisplaySERVLET?resultFlag=6");
	    	}
	    	else
	    	{
	    	String format=fileName.substring(fileName.length()-3);
	    	String format2=fileName.substring(fileName.length()-4);
    		if(!format.equals("jpg")||format.equals("png")||format2.equals("jpeg"))
    		{
    			response.sendRedirect("PhotoDisplaySERVLET?resultFlag=7");
    		}
    		
	    	else
	    	{
	    	System.out.println(request.getParameter("title"));
	    
	    	OutputStream out = null;
	    	InputStream filecontent = null;
	    	final PrintWriter writer = response.getWriter();
	    	Date date1=new Date();
	    	long Timestamp=date1.getTime();

	    	try {
	    		out = new FileOutputStream(new File(path + File.separator
	    				+m_id+Album_id+Timestamp+fileName));
	    		filecontent = filePart.getInputStream();

	    		int read = 0;
	    		final byte[] bytes = new byte[1024];

	    		while ((read = filecontent.read(bytes)) != -1) {
	    			out.write(bytes, 0, read);
	    		}
	    		
	    		String imagepath="http://alumninetwork.datadoctorr.com/alumni/imageUpload/"+m_id+Album_id+Timestamp+fileName;
	    		SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
	    		Date newdate=formetter.parse(taken_date);
	    		PhotoUploadBean bean=new PhotoUploadBean();
	    		bean.setA_id(Album_id);
	    		bean.setCaption(caption);
	    		bean.setImagepath(imagepath);
	    		bean.setM_id(m_id);
	    		bean.setPrivacy(pic_privacy);
	    		bean.setTakendate(newdate);
	    		bean.setTitle(Pic_title);
	    		System.out.println("in servlet");
	    		PhotoUploadBO BO=new PhotoUploadBO();
	    		BO.PhotoUpload(bean);
	    		
	    		RequestDispatcher dis=request.getRequestDispatcher("PhotoDisplaySERVLET?param="+Album_id);
	    		dis.forward(request, response);
	    				
			
	    		
	    		
	    		
	    		
	    	} catch (Exception fne) {
	    		writer.println("You either did not specify a file to upload or are "
	    				+ "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

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
}
	    	}
	}
}

	
	private String getFileName(Part filePart) {
		// TODO Auto-generated method stub
		 final String partHeader = filePart.getHeader("content-disposition");
		    for (String content : filePart.getHeader("content-disposition").split(";")) {
		        if (content.trim().startsWith("filename")) {
		            return content.substring(
		                    content.indexOf('=') + 1).trim().replace("\"", "");
		        }
		    }
		return null;
	}

}
