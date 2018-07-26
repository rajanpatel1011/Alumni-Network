<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<%@page import="com.alumni.admin.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/admin-style.css" rel="stylesheet" />
<link href="css/style-content.css" rel="stylesheet" />
<link href="css/style-dailog.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/scrpt43.js"></script>


<link href="admin/css/admin-style.css" rel="stylesheet" />
<link href="admin/css/style-content.css" rel="stylesheet" />
<link href="admin/css/style-dailog.css" rel="stylesheet" />

<script type="text/javascript" src="admin/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="admin/js/jquery-ui.js"></script>
<script type="text/javascript" src="admin/js/scrpt43.js"></script>



</head>
<body>
	<%
AdminLoginBEAN bean = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");

if(bean == null){
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp?validation=1");
	rd.forward(request, response);
}else{
%>
	<div class="fbody">
		<div class="header">

			<div class="title">C.G.Patel Institute Of Technology</div>
			<div class="btn">
				<% String url = null;
        	url = (String) request.getAttribute("javax.servlet.forward.request_uri"); 
        	if(url == null){
        		url = "aoaoaoaoaoaoaooaooaoa";
        	}
        	System.out.print("Url =>"+url);
        		String strurl = url.substring(0, 7);
        		System.out.print("strurl =>"+strurl);
        		if(strurl.equals("/Alumni")){
        			%>
				<a href="AdminLogoutSERVLET"><input type="button" class="logout"
					value="Logout" /></a>
				<%
        		}else{
        			%>
				<a href="../AdminLogoutSERVLET"><input type="button"
					class="logout" value="Logout" /></a>
				<%
        		}
        	%>
			</div>
			<div class="adminId">Admin</div>
		</div>
		<hr />
		<div class="ap">
			<label>Admin Panel</label>
		</div>
		<%} %>
	
</body>
</html>