<%@page import="com.alumni.bo.LoginBO"%>
<%@page import="com.alumni.beans.LoginBEAN"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- To create a Responsive Web Design -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Member Profile</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<link rel="stylesheet" href="css/member-style.css" type="text/css">
<!-- script>
	$(document).ready(function() {
			$.post('ForumSERVLET',{},function(responseText) {
				if(responseText != "null")
					$('#tab1').html(responseText);         
			});
			<% /* String profileString = request.getParameter("profile");
			int profile = 0;			if(profileString != null && !"".equals(profileString)) {
				profile = Integer.parseInt(profileString); 
				if(profile == 1){					
				}
			} */
			%>
			$( "#myprofilelbl" ).click(function() {
				$.post('profileSERVLET',{},function(responseText) {
					if(responseText != "null")
						$('#tab2').append(responseText);         
				});
			});
	});
</script -->

<script type="text/javascript" src="js/forum-jquery.js"></script>
<link rel="stylesheet" href="css/MetroJs.css" type="text/css" />
<link rel="stylesheet" href="css/MetroJs.min.css" type="text/css" />
<script type='text/javascript' src='js/MetroJs.js'></script>
<script type='text/javascript' src='js/MetroJs.min.js'></script>
</head>
<body>

<% LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
	if(loginBEAN == null){
		System.out.println("HEllo Error...!!!!! :D :D");
		RequestDispatcher rs=request.getRequestDispatcher("index.jsp?validation=2");
		rs.forward(request, response);
	}
	else{
	
		request.setAttribute("lb",loginBEAN);
		
%>

<div class="header1">
	<img src="images/final-logo.png" class="logo">
	<div class="head-title">
		<label>Alumni Association</label>
	</div>	
	<div class="fixhdr">
    	<a href="LogoutSERVLET"><button>Logout</button></a>
  	</div>
  	<div class="fixhdr">
      <a href="tempFAQ/tempFAQ.html" target="blank"><button>FAQ</button></a>
  	</div>
  	<div class="fixhdr">
    	<a href="profileSERVLET"><button>My Profile</button></a>
  	</div>
  	<div class="fixhdr">Welcome <%= loginBEAN.getF_name() %> </div>
</div>
<div class="header2">
	<div class="profilepic"> 
		<img alt="Profile Pic" src="<%= loginBEAN.getPic() %>"> 
	</div>
  	<div class="username">
    	<h1 style="color:#FFF"><b><%= loginBEAN.getF_name() %></b></h1>
  	</div>	
  	<div style="float:right;margin:0px;margin-top:-5px;">
 		<!-- Apply blue theme as default for all tiles, but use the tiles class to allow the theme to be swapped -->
		
    		<div class="red live-tile flip ha" data-mode="flip" data-delay="4000" style="width:400px;height:90px;margin-right: 0px;" > 
    		  
        		<div class="flip-front ha" style="padding:5px;background-color:#FCFBB5;color:#000;-webkit-transform: rotateX(0deg); -webkit-transition: all 0s ease 0s; transition: all 0s ease 0s;">
            		New User Request Received.<br/>
            		<label style="font-size: 12px;"> Hardik Thakor </label>
            		<br/>
            		
            		<span class="tile-title" style="width:30%">8 second ago</span>
            		<span class="tile-title" style="width:30%;margin-left:65%;text-align:right">1 of 5</span>
            		
        		</div>
        		<div class="flip-back ha" style="padding:5px;background-color:#CFECF9;color:#000;-webkit-transform: rotateX(540deg); -webkit-transition: all 500ms ease 0s; transition: all 500ms ease 0s;">
            		Jay Thakor commented on your post.<br/>
            		<label style="font-size: 12px;">
            		"Its time to bring about A Change"</label>
            		<br/>
            		
            		<span class="tile-title">Just Now</span>
            		<span class="tile-title" style="width:30%;margin-left:65%;text-align:right">2 of 5</span>
        		</div>
    		</div>    
		
  	</div>
  	
  	<% // tabs for member  %>
  	<div class="tab-block">
  		<div class="tab">
  			<label class="active-tab"><a href="ForumSERVLET" id="forum"> Forum </a></label>
  			<label id="myprofilelbl"><a href="profileSERVLET" id="myprofile"> My Profile </a></label>
  			<label><a href="searchmember.jsp" id="searchmem"> Search Member </a></label>
  			<label><a href="GalleryAlbumDisplaySERVLET" id="gallery"> Gallery </a></label>
  			<label><a href="MsgSERVLET" id="privmsg"> Private Message</a></label>
  			<label><a href="DocApp.jsp" id="makeapp"> Make Application </a></label>
  			<style>
  				#reportuser,#mod_req,#user_req{
  					background-color: #606;
  					color: #fff;	
  				}
  			</style>
  			<%
  				if(loginBEAN.getRole() == 1){
  					%>
  						<label><a href="ReportedUserViewSERVLET" id="reportuser" >Reported Users</a></label>
  						<label><a href="ModeratorReqDisplaySERVLET" id="mod_req">Moderation Request</a></label>
  						<label><a href="UserReqDisplaySERVLET" id="user_req" >New User Request</a></label>
  					<%
  				}
  			%>
  			
  		</div>
  	</div>  	
</div>

<% }// All Tab Contents of Member %>
