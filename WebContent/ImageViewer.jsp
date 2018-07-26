<%@page import="com.alumni.beans.PhotoUploadBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Photos</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/responsive.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/style32.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/touchTouch.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/tm_docs.css" type="text/css"
	media="screen">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/touchTouch.jquery.js"></script>
<script type="text/javascript" src="js/update-js.js"></script>

<script>
   
    $(document).ready(function() {

    
    	
    	$('#post-sava').submit(function(){
    	 	
				if($('#album_name').val()){
					
					alert("Enter Album Name..");
				}								
    		return false;
    	});

    });

    </script>


<script type="text/javascript">if($(window).width()>1024){document.write("<"+"script src='js/jquery.preloader.js'></"+"script>");}	</script>
<script>		
		 jQuery(window).load(function() {	
		 	$x = $(window).width();		
			if($x > 1024)
			{			
				jQuery("#content .row").preloader();
			}			 
	 		jQuery('.abc').touchTouch();
		 jQuery('.spinner').animate({'opacity':0},1000,'easeOutCubic',function (){jQuery(this).css('display','none')});	
  		  }); 
		 
	
					
	</script>

<!--[if lt IE 8]>
  		<div style='text-align:center'><a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/img/upgrade.jpg"border="0"alt=""/></a></div>  
 	<![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!--<![endif]-->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/docs.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400' rel='stylesheet' type='text/css'>
  <![endif]-->
</head>
<body style="background-color: #F9F5ED">

	<%@ page import="java.io.*"%>
	<%@ page import="com.alumni.*"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.List"%>


	<div class="bg-content"
		style="width: 100%;; height: 100%; background-color: #F9F5ED"">
		<!-- Content -->
		<div id="content">
			<div class="ic"></div>
			<div class="container">
				<div class="row">
					<div style="display: inline">

						<div id="back" style="float: left; margin-top: 100px">
							<a href="Gallery.jsp"> <img src="img/back1.png" height="50"
								width="50">
							</a>
						</div>
						<div style="float: right; margin-top: 115px">

							<input type="button" value="Upload New" id="post-btn">
						</div>
						<h4 style="margin-left: 100px; margin-top: 100px">Photos</h4>




					</div>
					<%

String resultFlag=request.getParameter("resultFlag");
if(resultFlag!=null && !"".equals(resultFlag) )
{
	
	if(resultFlag.equals("1"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red"> Please
									Specify Picture Title!
									</center></th>
						</tr>
					</table>



					<% 
		
		
	}
	if(resultFlag.equals("2"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red"> Please
									Select Permisson</font></th>
						</tr>
					</table>



					<% 
		
		
	}
	if(resultFlag.equals("3"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red"> Please
									Specify Caption </font></th>
						</tr>
					</table>



					<% 
		
		
	}
	if(resultFlag.equals("4"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red"> You must
									Specify date</font></th>
						</tr>
					</table>



					<% 
		
		
	}

	if(resultFlag.equals("5"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red">You must
									Specify Time</font></th>
						</tr>
					</table>



					<% 
		
		
	}
	if(resultFlag.equals("6"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red">You must
									specify Image</font></th>
						</tr>
					</table>



					<% 
		
		
	}
	if(resultFlag.equals("7"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red">Upload
									jpg/png/jpeg image only!</font></th>
						</tr>
					</table>

					<% 
		
		
	}
	if(resultFlag.equals("10"))
	{
		%>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red">All The
									Details are compalsory</font></th>
						</tr>
					</table>

					<% 
		
		
	}
	
}

%>
					<%
String A_id=(String)request.getAttribute("a_id");
String delete=(String)request.getAttribute("delete");
%>
					<script type="text/javascript">
$(document).ready(function() {
	$( "#photos" ).submit(function( event ) {
		if(!$("#album_name").val()){
			$("#errMsg").html("<font color='red'> Please Specify Picture Title! </font>");
			return false;
		}
		if(!$("#caption").val()){
			$("#errMsg").html("<font color='red'> Please Specify Caption! </font>");
			return false;
		}
	
		if(!$("#date").val() || $("#date").val()=="dd-mm-yyyy"){
			$("#errMsg").html("<font color='red'> You must Specify date! </font>");
			return false;
		}
		if($("#privacy").val() == "-select-"){
			$("#errMsg").html("<font color='red'> Please select privacy! </font>");
			return false;
		}
		return true;
	});
});
</script>

					<div
						style="margin-top: 100px; background-color: #FFF; margin-left: 30px"
						id="createalbm">
						<h5
							style="color: #606; font-weight: normal; font: Tahoma, Geneva, sans-serif; text-emphasis: accent;">
							<center>New Post</center>
						</h5>
						<hr style="border-color: #606">
						<form enctype="multipart/form-data" id="photos" method="post"
							action="PhotosUplodSERVELET">
							<table>
								<tr>
									<th bgcolor="#FFFF99" id="errMsg" style="margin: 10px"></th>
								</tr>
							</table>
							<h5 style="color: #000; font-weight: normal; display: inline">
								&nbspPicture Title&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="text" name="aalbum_name" id=album_name>
							</h5>
							<h5
								style="color: #000; font-weight: normal; display: inline; margin-left: 70px">Privacy
								&nbsp;:&nbsp;&nbsp;</h5>
							<select id="privacy" name="privacy">
								<option selected="selected" value="0">-select-</option>
								<option value="1">Public</option>
								<option value="2">Batch</option>
								<option value="3">Year</option>
								<option value="4">Branch</option>
							</select> <br />


							<h5
								style="color: #000; font-weight: normal; display: inline; margin-left: 5px">Caption
								&nbsp;:&nbsp;&nbsp;&nbsp;</h5>
							<textarea name="caption" style="margin-left: 20px" id="caption"></textarea>

							<br />

							<h5
								style="color: #000; font-weight: normal; display: inline; margin-left: 5px">Taken
								date &nbsp;:</h5>
							<input type="date" id="date" name="Date"
								style="margin-left: 10px">

							<h5 style="color: #000; font-weight: normal">
								&nbspAlbum picture&nbsp;:&nbsp;&nbsp;&nbsp;<input type="file"
									name="images"> <input type="hidden" value="<%=A_id%>"
									name="Album_id"> <input type="submit" value="save"
									id="post-save" style="margin-left: 15px">
							</h5>
						</form>
						<br /> <br />


					</div>


					<br>
					<div class="clear"></div>
					<div class="album"></div>
					<%     
         
         			
         	List<PhotoUploadBean>  list=(List<PhotoUploadBean>)request.getAttribute("list");
         					
	      
	    	 if(list==null)
	    	 {
	    		out.println("No Photos!"); 
	    		 
	    	 }
	    	 else
	    	 {
	    	   for(PhotoUploadBean bean : list) {
	    		   out.println("<form name='UserRequest' action='UserRequestServlet' method='post' >");	   
				%>
					<ul class="portfolio clearfix">
						<% if(delete.equals(""+bean.getM_id()))
        {
        %>
						<li class="box" align="right"><a
							href="DeletePicServlet?value=<%=bean.getPhoto_id()%>&a_id=<%=A_id%>">



								<i class="icon-remove"> </i>
						</a> <%    }
        else
        {
        %>
						<li class="box" align="right">
							<% 	}
    	%>
							<div class="tm_view tm_view_first">
								<a href="<%=bean.getImagepath()%>" class="abc"> <img
									src="<%=bean.getImagepath()%>"
									style="height: 192px; width: 270px" alt="" />
									<div class="tm_mask tm_mask-1"></div>
									<div class="tm_mask tm_mask-2"></div>
									<div class="tm_content">
										<p>
											<%=bean.getPerm_name() %><br />
											<br /> Uploaded By:
											<%=bean.getF_name()%>
											<br />
											<br /> Title:
											<%=bean.getTitle() %><br />
											<br />
											<%=bean.getCaption() %><br /> <br />
											<%=bean.getTakendate() %>


										</p>
									</div>
							</div> </a>
						</li>


						<%   
         }
         }
	    	   %>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<!-- footer>
      <div class="container clearfix">
    <ul class="list-social pull-right">
          <li><a class="icon-1" href="#"></a></li>
          <li><a class="icon-2" href="#"></a></li>
          <li><a class="icon-3" href="#"></a></li>
          <li><a class="icon-4" href="#"></a></li>
        </ul>
    <div class="privacy pull-left">Jay Jariwala&copy; 2013 </div>
  </div>
    </footer -->
</body>
</html>