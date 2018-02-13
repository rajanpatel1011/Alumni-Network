 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="css/login.css" type="text/css">
<script type="text/javascript" src="js/login.js"></script>

</head>
<body>
<form action="Login" class="loginForm" method="post">
	<table width="100%">
		<tr>
				<td>
					<label class="label-name">Username :</label>
				</td>
				<td>
					<input type="text" id="inputUname" name="uid" placeholder="Username">
					<div id="emptyUname" class="bubble">
                         <span   style="color:#FFF;">
                           *This field is required.
                          </span> 
                    </div>
				</td>
		</tr>
		<tr>
				<td>
					<label class="label-name">Password :</label>
				</td>
				<td>
				
					<input type="password" id="inputPWD" name="pwd" placeholder="Password">
					
					<input type="hidden" name="check" value="1">
					 <div id="emptyPwd" class="bubble">
						<span  style="color:#FFF">*This field is required.</span>
					</div>
					<!-- div class="val-require">*This field is required.</div> -->
				</td>
		</tr>
		<tr>
				<td colspan="2">
					
					 <%
						String validationString = request.getParameter("validation");
						if(validationString != null && !"".equals(validationString)) {
							int validation = Integer.parseInt(validationString);
							if(validation == 1) {
								%>
								<div id="invalidUserPwd" class="bubble">
									<span  style="color:#FFF">*Invalid Username or Password.</span>
					 			</div>
								<%
							}else if(validation == 2) {
								%>
								<div id="internalError" class="bubble">
						<span  style="color:#FFF">*Internal server Error.Please Try Again.</span>
								<%
							}
							
						}
					%>
					<br/>
					<!-- center><a href="#" style="color:blue">Forgot Password?</a></center><br/ -->
					
					<center><input type="submit" id="signin" class="btn" value="Login"></center>
				</td>
		</tr>
	</table>
</form>
</body>
</html>