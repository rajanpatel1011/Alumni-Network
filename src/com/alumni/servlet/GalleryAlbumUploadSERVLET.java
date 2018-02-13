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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.alumni.beans.GalleryAlbumUploadBEAN;
import com.alumni.beans.LoginBEAN;

import java.util.Date;
import com.alumni.bo.GalleryAlbumUploadBO;

/**
 * Servlet implementation class UploadServ
 */
@WebServlet("/GalleryAlbumUploadSERVLET")
//5KB file Size. 1kb buffer size; max. 25 kb request size. (5 files of 5 kb).
@MultipartConfig(fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class GalleryAlbumUploadSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
		
		 int permission=Integer.parseInt(request.getParameter("select"));
		 String Album_name=request.getParameter("album_name");
		 String caption=request.getParameter("caption");
		 String  date=request.getParameter("date");
		 String details=request.getParameter("details");
		 int m_id=lb.getM_id();
		
		
		if(!Album_name.equals(""))
		{
			if(permission!=0)
			{
				
				
				// Create path components to save the file
				
				//final String path = getServletContext().getRealPath("/") +"images\\Album\\";
				
				final String path = "http://alumninetwork.datadoctorr.com/alumni/imageUpload/";
				System.out.print(path);
				//		request.getParameter("destination");
				final Part filePart = request.getPart("imageFile");
	    
	    
				Collection<String> headers = filePart.getHeaderNames();
				for(String c: headers) {
				System.out.println(c + " " + filePart.getHeader(c));
			}
				final String fileName =getFileName(filePart);
	  
	   
				 if(fileName.equals(""))
				    {
				    	response.sendRedirect("Gallery.jsp?resultFlag=3");
				    }
	    
	    else
	    {
	    
	    			String format=fileName.substring(fileName.length()-3);
	    			String format1=fileName.substring(fileName.length()-4);
	    			if(format.equals("jpg")||format.equals("png")||format1.equals("jpeg"))
	    			{
	    				
	    				if(caption.equals(""))
	    				{
	    					response.sendRedirect("Gallery.jsp?resultFlag=5");
	    				}
	    				
	    				else
	    				{
	    					if(date.equals(""))
	    					{
	    						response.sendRedirect("Gallery.jsp?resultFlag=6");
	    					}
	    		    
	    				   
	    				    else
	    				    {
	    				    
	    			
	    				OutputStream out = null;
	    				InputStream filecontent = null;
	    				final PrintWriter writer = response.getWriter();

	    				try {
	    					
	    					Date date1=new Date();
	    					long Timestamp=date1.getTime();
	    					System.out.println(Timestamp);
	    					out = new FileOutputStream(new File(path + File.separator
	    							+m_id+Timestamp+fileName));
	    					filecontent = filePart.getInputStream();
	    					int read = 0;
	    					final byte[] bytes = new byte[1024];
	    					while ((read = filecontent.read(bytes)) != -1) {
	    						out.write(bytes, 0, read);
	    					}
	    					String imagepath="http://alumninetwork.datadoctorr.com/alumni/imageUpload/"+m_id+Timestamp+fileName;
	    					
	    					GalleryAlbumUploadBEAN bean=new GalleryAlbumUploadBEAN();
	    					bean.setAlbum_name(Album_name);
	    					bean.setCaption(caption);
	    					SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
	    					Date newdate=formetter.parse(date);
	    					bean.setDate_time(newdate);
	    					bean.setM_id(m_id);
	    					bean.setPermission(permission);
	    					bean.setUpload_pic(imagepath);
	    					bean.setDetails(details);
	    					GalleryAlbumUploadBO album=new GalleryAlbumUploadBO();
	    					album.uploadAlbum(bean);
	    					RequestDispatcher dis=request.getRequestDispatcher("Gallery.jsp");
	    					dis.forward(request, response);
	    					
	    				} 
	    
	    		catch (Exception fne)
	    			{
	        		writer.println("You either did not specify a file to upload or are "
	        		+ "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        		writer.println("<br/> ERROR: " + fne.getMessage());
	    			} 
	    		finally
	    		{
	    			if (out != null)
	    			{
	    				out.close();
	    			}
	    		if (filecontent != null)
	    			{
	    			filecontent.close();
	    			}
	    		if (writer != null) 
	    			{
	    			writer.close();
	    			}
	    		
	    		}
	    		
	    				}
	    			}
    				
	    			}
	    	else
	    
	    	{
	    		response.sendRedirect("Gallery.jsp?resultFlag=4");
	    	}
	    
	    
	    }
	
	}
						
		else
			{
				response.sendRedirect("Gallery.jsp?resultFlag=2");
			}
		
			

			}
	
		
		
		else
		{
			response.sendRedirect("Gallery.jsp?resultFlag=1");	
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
