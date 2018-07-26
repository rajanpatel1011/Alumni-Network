<%@page import="java.util.Random"%>
<%@page import="com.alumni.beans.LoginBEAN"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<%
int l=0;
if(session.getAttribute("loginBEAN") != null){
	LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
	if(loginBEAN.getUserName() != null){
		if(loginBEAN.getRole() == 0){
			response.sendRedirect("LoginSERVLET");
		}else if(loginBEAN.getRole() == 1){
			response.sendRedirect("LoginSERVLET");
		}
	}
}
%>

<html>
<head>
<meta http-equiv="refresh" content="5" />
<script type="text/javascript">
window.location="index.jsp";
</script>
<link rel="stylesheet" href="css/slide-style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/kwicks-slider.css" type="text/css"
	media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- To create a Responsive Web Design -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Alumni Network</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<%
String validationString = request.getParameter("validation");
if(validationString != null && !"".equals(validationString)) {
	int validation = Integer.parseInt(validationString);
	if(validation == 1 || validation == 2 ) {
		out.println("<script>$(document).ready(function() { $('#login-form').slideToggle(300);});	</script>");
	}
}
%>
</head>
<body bgcolor="#251D1B">
	<div class="header">
		<div class="title">College Of XYZ</div>


		<div class="nav">
			<ul>
				<li id="home"><a href="index.jsp">HOME</a></li>
				<li id="contect"><a href="#">CONTECT</a></li>
			</ul>
		</div>
	</div>


	<div class="content" style="overflow: auto; padding-top: 100px;">
		<jsp:include
			page="How to enable JavaScript in your browser and why.htm" />
	</div>


	<div class="footer"></div>
</body>
</html>