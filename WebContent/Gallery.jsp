<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.alumni.beans.GalleryAlbumUploadBEAN"%>

 
<html lang="en">
	<head>
	<style>
#gallery{
background-color: #F25C27;
color: #FFF;
}

#forum, #myprofile ,#searchmem,#privmsg,#makeapp,#reportuser,#mod_req,#user_req{
background-color: #F5F1E5;
color: #000;
}
</style>
	<title></title>
	<meta charset="utf-8">
	
   
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/style32.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/touchTouch.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/tm_docs.css" type="text/css" media="screen">

	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>  
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/touchTouch.jquery.js"></script> 
    <script type="text/javascript" src="js/update-js.js"></script> 
    
    
	<script type="text/javascript">if($(window).width()>1024){document.write("<"+"script src='js/jquery.preloader.js'></"+"script>");}	</script>
	<script>		
		 jQuery(window).load(function() {	
		 $x = $(window).width();		
	if($x > 1024)
	{			
	jQuery("#content .row").preloader();    }			 
	 jQuery('.magnifier').touchTouch();
		 jQuery('.spinner').animate({'opacity':0},1000,'easeOutCubic',function (){jQuery(this).css('display','none')});	
  		  }); 
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
	</script>
</head>
<body style="background-color:#F9F5ED">
<%@ page import="java.io.*" %>
<%@ page import="com.alumni.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.*" %>
 <%@page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@page  import="javax.servlet.http.HttpSession"%>
<%@ page import="com.alumni.beans.GalleryAlbumUploadBEAN"%>
<%@ page import="com.alumni.beans.LoginBEAN"%>
<%@ page import="com.alumni.bo.GalleryAlbumUploadBO"%>




<div class="bg-content" style="width:100%;height:100%;" >       
  <!-- Content -->      
 
      <div id="content" ><div class="ic"></div>
    <div class="container">
        <div class="row">
        	<div style="float:left">

   
		        <h4>Gallery</h4>
		                     <%

String resultFlag=request.getParameter("resultFlag");
if(resultFlag!=null && !"".equals(resultFlag) )
{ %>
	<script>
	$(document).ready(function(e) {
		$('#createalbm').show();
	});
	</script>
	<table style="margin-top:35px;margin-left:40px;"> <tr> 
	<th bgcolor="#FFFF99"> <font color="red">
<% 	if(resultFlag.equals("1"))
	{
		%>
		
		 Please Specify Album Name! 	
		
		<% 
		
		
	}
	if(resultFlag.equals("2"))
	{
		%>
		
		 Please Specify Permisson
		
		
		
		<% 
		
		
	}
	if(resultFlag.equals("3"))
	{
		%>
		
		 Please Select Album Picture
		
		<% 
		
		
	}
	if(resultFlag.equals("4"))
	{
		%>
		
		You can upload Only jpg Image!	
		
		<% 
	}

	if(resultFlag.equals("5"))
	{
		%>
		
		You must Specify Caption
		
		
		<% 
		
		
	}
	if(resultFlag.equals("6"))
	{
		%>

		
		You must Specify Album Date	
		<% 
		
	}
}

%>
</font>  </th></tr></table>

            </div>
           
            
	         <div style="float:right;margin-top:30px">
    		     <input type="button" value="New Album" id="post-btn" >
	         </div>
             
		       
             <div style="margin-top:100px;
             background-color:#FFF; margin-left:30px" id="createalbm">
            <h5 style="color:#606;font-weight:normal;font:Tahoma, Geneva, sans-serif;text-emphasis:accent;"><center>New Post</center></h5 >
            <hr style="border-color:#606">	
           
           <form enctype="multipart/form-data" name="form1" method="post" action="GalleryAlbumUploadSERVLET">
            <h5 style="color:#000;font-weight:normal;display:inline">&nbspAlbum Name&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="album_name"></h5>
    
    <h5 style="color:#000;font-weight:normal;display:inline">&nbspPermission&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
            </h5>
    <select name="select">
             
            <option selected="selected" value="0">-select-</option>
            <option value="1">Public</option>
            <option value="2">Batch</option>
            <option value="3">Year</option>            
            <option value="4">Branch</option>
          </select>
          <br/>
           <h5 style="color:#000;font-weight:normal">&nbspAlbum picture&nbsp;:&nbsp;&nbsp;
           <input type="file" value="Open" name="imageFile" >
          
          <h5 style="color:#000;font-weight:normal;display:inline;">&nbsp;Taken date &nbsp;:</h5>
          <input type="date" id="date" name="date" style="left:10px">
          
           	<br/>
			<h5 style="color:#000;font-weight:normal;display:inline;">&nbspCaption &nbsp;:&nbsp;&nbsp;</h5>
     		<input type="text" name="caption" >
     		
     		<br/>
     		<h5 style="color:#000;font-weight:normal;display:inline;">&nbsp Details &nbsp;:&nbsp;&nbsp;</h5>
     		<textarea rows="4" cols="4" name="details"></textarea>
       
           <br/>
           <input type="Submit" value="Save" name="submit" id="post-save" style="margin-left:"0px"></h5>
             
             <br/>
             <br/>
             </form>
             
         </div>
         <br>
        <div class="clear">
        
        </div>
        <div class="album">
        </div>
        
  <%        
 
	HttpSession session1 = request.getSession();
	LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
	
	int p_id=lb.getP_id();
	int b_id=lb.getB_id();
	GalleryAlbumUploadBO BO=new GalleryAlbumUploadBO();

		List<GalleryAlbumUploadBEAN> list=BO.view(p_id,b_id);
		
 
   
  	

 
  
	    	 if(list==null)
	    	 {
	    		out.println("No Album!"); 
	    		
	    		 
	    	 }
	    	 else
	    	 {
	    	   for(GalleryAlbumUploadBEAN bean : list) {
	    		   out.println("<form name='UserRequest' action='UserRequestServlet' method='post' >");	   
	    		   
	    		  
				%>	    	   
       
        
         <ul class="portfolio clearfix"> 
         <%  if(bean.getM_id()==lb.getM_id())
         {         
         %>   
           <li class="box" align="right">
            <span id="dialogoutput"></span>
           
            <a href="DeleteAlbumSERVLET?value=<%=bean.getA_id()%>" id="dialoglink" >
        
        <i class="icon-remove" >
        </i>
        </a>
        <%
        }
         else
         { %>
        	 <li class="box" align="right" >
 <%       } %>
        
        
    <div class="tm_view tm_view_first">
	<a href="PhotoDisplaySERVLET?param=<%=bean.getA_id()%>">
	<img src=<%=bean.getUpload_pic()%> style="height:192px;width:270px" alt="" />
	<div class="tm_mask tm_mask-1"></div>
	<div class="tm_mask tm_mask-2"></div>
	<div class="tm_content">
	
		<h2> <%=bean.getAlbum_name() %> </h2>
		
		<p>  <%=bean.getPermissionName() %><br/>
		Created by: <%=bean.getF_name()%><br/> 
		<%=bean.getCaption()%> <br/><%=bean.getDate_time()%><br/> </p>
		<p></p> 
		</a>
	</div>
</div>
           
      
           </li> 
           
          
          														
          
	   <%  	  
	   			}
	    	 }
	    	   
		        %>

            </ul> 
            <br>
      </div>
        </div>
  </div>
    </div>

<!-- footer -->
<!-- footer >
      <div class="container clearfix">
    <ul class="list-social pull-right">
          <li><a class="icon-1" href="#"></a></li>
          <li><a class="icon-2" href="#"></a></li>
          <li><a class="icon-3" href="#"></a></li>
          <li><a class="icon-4" href="#"></a></li>
        </ul>
    <div class="privacy pull-left">Jay Jariwala &copy; 2013 </div>
  </div>
    </footer -->
</body>
</html>