<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.alumni.admin.beans.*"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	AdminLoginBEAN bean1 = (AdminLoginBEAN) session.getAttribute("adminloginBEAN");
	
	if(bean1 != null){
		RequestDispatcher rd = request.getRequestDispatcher("../NewsDisplaySERVLET");
		rd.forward(request, response);
	}else{
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Animated Form Switching with jQuery</title>

<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="admin/css/style1.css" />
<script src="admin/js/cufon-yui.js" type="text/javascript"></script>
<script src="admin/js/ChunkFive_400.font.js" type="text/javascript"></script>


<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>

<style>
.button {
	cursor: pointer;
	float: right;
	background-color: #D9D9D9;
	height: 40px;
	width: 148px;
	border: 1px solid #ccc;
	font-size: 14px;
	font-weight: bold;
	padding: 8px 0 9px;
	text-align: center;
	margin: 15px 20px 10px 10px;
	text-shadow: 0px 1px 0px #fff;
	border-radius: 4px;
	-webkit-box-shadow: 0px 0px 2px #fff inset;
	box-shadow: 0px 0px 2px #fff inset;
}
</style>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script>
        	$(document).ready(function(e) {
        		$('#pempty').hide();
        		$('#uempty').hide();
        		
        	});
        	</script>
</head>
<body>
	<div class="wrapper">
		<div class="content" style="margin-top: 100px">
			<div id="form_wrapper" class="form_wrapper">
				<% String url = null;
        	url = (String) request.getAttribute("javax.servlet.forward.request_uri"); 
        	if(url == null){
        		url = "aoaoaoaoaoaoaooaooaoa";
        	}
        	System.out.print("Url =>"+url);
        		String strurl = url.substring(0, 7);
        		System.out.print("strurl =>"+strurl);
        		if(strurl.equals("/Alumni")){
        			if(strurl.length() > 13){
        			if(strurl.subSequence(0, 13).equals("/Alumni/admin")){
        			%>
				<form class="login active" id="adminLogin"
					action="../AdminLoginSERVLET" method="post">

					<input type="hidden" value="three" name="urlFlag" />
					<%}
        			}else{
        				%>
					<form class="login active" id="adminLogin"
						action="AdminLoginSERVLET" method="post">

						<input type="hidden" value="one" name="urlFlag" />
						<%
        			}
        		}else{
        			%>
						<form class="login active" id="adminLogin"
							action="../AdminLoginSERVLET" method="post">
							<input type="hidden" value="two" name="urlFlag" />
							<%
        		}
        	%>


							<h3>Admin Panel</h3>
							<div>
								<label>Username:</label> <input type="text" name="uname" /> <span
									id="uempty" style="margin-left: 30px; color: red">Username
									cannot be empty ...</span>
							</div>
							<div>
								<label>Password: <a href="forgot_password.html"
									rel="forgot_password" class="forgot linkform">Forgot your
										password?</a></label> <input type="password" name="pwd" /> <input
									type="hidden" name="check" value="1"> <span id="pempty"
									style="margin-left: 30px; color: red">Password cannot be
									empty ...</span>

								<%
								String validationString = request.getParameter("validation");
								if(validationString != null && !"".equals(validationString)) {
									int validation = Integer.parseInt(validationString);
										if(validation == 1) {
							%>
								<label>You are not Login ...</label>
								<%
									}else if(validation == 2) {
										%>
								<label>Incorrect Username Password ...</label>
								<%
									}
								}
							%>

							</div>
							<div class="bottom">
								<!-- div class="remember"><input type="checkbox" /><span>Keep me logged in</span></div -->
								<!-- input type="submit" value="Login" / -->
								<button class="button" id="adminlogin" type="submit">Login</button>
								<div class="clear"></div>
							</div>
						</form>
						<form class="forgot_password">
							<h3>Forgot Password</h3>
							<div>
								<label>Username or Email:</label> <input type="text" /> <span
									class="error">This is an error</span>
							</div>
							<div class="bottom">
								<input type="submit" value="Send Password"></input> <a
									href="index.html" rel="login" class="linkform">Suddenly
									remebered? Log in here</a>
								<div class="clear"></div>
							</div>
						</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>


	<!-- The JavaScript -->
	<script type="text/javascript" src="admin/js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
			$(function() {
					//the form wrapper (includes all forms)
				var $form_wrapper	= $('#form_wrapper'),
					//the current form is the one with class active
					$currentForm	= $form_wrapper.children('form.active'),
					//the change form links
					$linkform		= $form_wrapper.find('.linkform');
						
				//get width and height of each form and store them for later						
				$form_wrapper.children('form').each(function(i){
					var $theForm	= $(this);
					//solve the inline display none problem when using fadeIn fadeOut
					if(!$theForm.hasClass('active'))
						$theForm.hide();
					$theForm.data({
						width	: $theForm.width(),
						height	: $theForm.height()
					});
				});
				
				//set width and height of wrapper (same of current form)
				setWrapperWidth();
				
				/*
				clicking a link (change form event) in the form
				makes the current form hide.
				The wrapper animates its width and height to the 
				width and height of the new current form.
				After the animation, the new form is shown
				*/
				$linkform.bind('click',function(e){
					var $link	= $(this);
					var target	= $link.attr('rel');
					$currentForm.fadeOut(400,function(){
						//remove class active from current form
						$currentForm.removeClass('active');
						//new current form
						$currentForm= $form_wrapper.children('form.'+target);
						//animate the wrapper
						$form_wrapper.stop()
									 .animate({
										width	: $currentForm.data('width') + 'px',
										height	: $currentForm.data('height') + 'px'
									 },500,function(){
										//new form gets class active
										$currentForm.addClass('active');
										//show the new form
										$currentForm.fadeIn(400);
									 });
					});
					e.preventDefault();
				});
				
				function setWrapperWidth(){
					$form_wrapper.css({
						width	: $currentForm.data('width') + 'px',
						height	: $currentForm.data('height') + 'px'
					});
				}
				
				/*
				for the demo we disabled the submit buttons
				if you submit the form, you need to check the 
				which form was submited, and give the class active 
				to the form you want to show
				*/
				$form_wrapper.find('input[type="submit"]')
							 .click(function(e){
								e.preventDefault();
							 });	
			});
        </script>
</body>
</html>

<%}%>