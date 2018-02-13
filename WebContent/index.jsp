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
final String path = getServletContext().getRealPath("/") + "images\\Album\\";
if(session.getAttribute("loginBEAN") != null){
	LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
	if(loginBEAN.getUserName() != null){
		if(loginBEAN.getRole() == 0){
			response.sendRedirect("Login");
		}else if(loginBEAN.getRole() == 1){
			response.sendRedirect("Login");
		}
	}
}
%>

<html>
<head>

<noscript>
    Javascript is disabled.
<meta http-equiv="refresh" content="5" />
    <meta HTTP-EQUIV="REFRESH" content="0; url=indexJS.jsp"> 
    
</noscript>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- To create a Responsive Web Design -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
<script>
	$(document).ready(function() {
	/*	$( "#veryCode" ).submit(function( event ) {
			event.preventDefault();
			var code = $("#code").val();
			var emailId = $("#emailId").val();
			// SignupSERVLET
			$('#msg').html("<center><p style='color:#FFF'>Processing Please Wait... </p><img src='images/loading.gif' width='80%' height='90px'/></center>");
			$.post('EmailVerificationCodeSERVLET',{inputCode:code,inputEmail:emailId},function(responseText) { 
				if(responseText != "null")
					$('#msg').html(responseText);
				else
					$('#msg').append("Internal Server Error.Click <a href='index.jsp'>here</a> to try again.");
			});
		});*/
	});
</script>
<link href="css/mobiscroll.custom-2.6.2.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">
	<div class="title">
		C.G.Patel Institute Of Technology
	</div>
	<div class="nav">
		<ul>
			<li id="home"><a href="index.jsp" >HOME</a></li>
			
			<li id="signup">
				<a href="#" id="sup">SIGN UP</a>
				<div class="signup-form" id="signup-form">
					<jsp:include page="signup.jsp" />
				</div>
			</li>
			<li id="login">
				<a href="#" id="lgn">LOGIN</a>
				<div class="login-form" id="login-form">
					<jsp:include page="login.jsp" />
				</div>
			</li>		
			
			<li id="contect"><a href="#">CONTACT</a></li>
		</ul>
	</div>
</div>	


<div class="content">
	<div class="photoslide">
		<jsp:include page="photoslide.html" />
	</div>
</div>


<div class="footer">

</div>
<script src="js/mobiscroll.custom-2.6.2.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
    var now = new Date();
   	//alert(now.getFullYear()-20);
    $('#inputDob').mobiscroll().date({
        theme: 'wp',
        accent: 'orange',
        display: 'bubble',
        animate: 'pop',
        mode: 'mixed',
        //dateOrder: 'ddmmmyyyy',
        
        //dateFormat: 'dd-mm-yy',
        dateFormat: 'yyyy-mm-dd hh:mm:ss',
        startYear: now.getFullYear()-50,
        endYear: now.getFullYear() - 14,
        minWidth: 100
    });
});
</script>
</body>
</html>