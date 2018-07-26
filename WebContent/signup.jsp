<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/signup.css" type="text/css">
<script type="text/javascript" src="js/signup.js"></script>

<script>

function code2(){
	//	event.preventDefault();
		//alert("hi");
		var code = $("#code").val();
		var emailId = $("#emailId").val();

		alert(code+"--"+emailId);
		
		$.post('EmailVerificationCodeSERVLET',{inputCode:code,inputEmail:emailId},function(responseText) {
			if(responseText != "null"){
				$('#msg').html(responseText);
			}
			else
				$('#msg').append("Internal Server Error.Click <a href='index.jsp'>here</a> to try again.");
		}); 
	}


	$(document).ready(function() {
			$(".loading-gif").hide();
			$("#veryCode").hide();
			
			$.post('PassoutYrDrpSERVLET',{},function(responseText) {
				if(responseText != "null")
					$('#inputPassyr').append(responseText);         
			});
			$.post('BranchDrpSERVLET',{},function(responseText) { 
				if(responseText != "null")
					$('#selectBranch').append(responseText);         
			});			
			
			$( "#signupForm" ).submit(function( event ) {
						event.preventDefault();
						var Fname = $("#inputFname").val();
						var Lname = $("#inputLname").val();
						var gender = $("input:radio[name='gender']").val();
						var dob = $("#inputDob").val();
						var Email = $("#inputEmail").val();
						var Passyr = $("#inputPassyr").val();
						var branch = $("#selectBranch").val();
						var Enrno = $("#inputEnrno").val();
						// SignupSERVLET
						$('#msg').html("<center><p style='color:#FFF'>Processing Please Wait... </p><img src='images/loading.gif' width='80%' height='90px'/></center>");
						$.post('EmailVerificationSERVLET',
								{inputFname:Fname,inputLname:Lname,gender:gender,dob:dob,inputEmail:Email,inputPassyr:Passyr,branch:branch,inputEnrno:Enrno},
							function(responseText) { 
								if(responseText != "null"){
									$('#msg').hide();
									$("#veryCode").show();
									$('#veryCode').html(responseText);
									
								}
								else
									$('#msg').append("Internal Server Error.Click <a href='index.jsp'>here</a> and try again.");
							}
							
						);
					}				
			);
			
			$( "#veryCode" ).submit(function( event ) {
				event.preventDefault();
				var code = $("#code").val();
				var emailId = $("#emailId").val();
				// SignupSERVLET
				$('#msg').html("<center><p style='color:#FFF'>Processing Please Wait... </p><img src='images/loading.gif' width='80%' height='90px'/></center>");
				$.post('EmailVerificationCodeSERVLET',{inputCode:code,inputEmail:emailId},function(responseText) { 
					if(responseText != "null"){
						
						if(responseText == "0"){
							$('#msg').show();
							$("#veryCode").hide();
							$('#msg').html("Your Reqest is submitted. You will be notify by your register email Id.");
						}else if(responseText == "1"){
							$('#msg').hide();
							$("#veryCode").show();
							$('#errMsg').html("<br/>Sorry,You have enterd wrong verification Code...");
						}
					}
					else
						$('#msg').append("Internal Server Error.Click <a href='index.jsp'>here</a> to try again.");
				});
			});
	});	
	
	  
</script>

<script type="text/javascript" src="js/datetimepicker.js"> </script>

</head>
<body>
	<div id="msg" class="msg"></div>
	<form method='post' id='veryCode' class="msg">
		<div id="errMsg"></div>
	</form>
	<form method="post" id="signupForm">
		<table>
			<tr>
				<td><label class="label-name">First Name :</label></td>
				<td><input type="text" id="inputFname" name="inputFname"
					placeholder="First Name">
					<div class="bubble" id="emptyFname">
						<span style="color: #FFF">*This field is required.</span>
					</div>
					<div id="CapsFname" class="bubble">
						<span style="color: #FFF">*First Letter Must be in Capital.</span>
					</div>
					<div id="NaNFname" class="bubble">
						<span style="color: #FFF">*Numbers Not Allowed.</span>
					</div></td>
			</tr>
			<tr>
				<td><label class="label-name">Last Name :</label></td>
				<td><input type="text" id="inputLname" name="inputLname"
					placeholder="Last Name">
					<div id="emptyLname" class="bubble">
						<span style="color: #FFF">*This field is required.</span>
					</div>
					<div class="bubble" id="NaNLname">
						<span style="color: #FFF">*Nubers Not Allowed.</span>
					</div></td>
			</tr>
			<tr>
				<td><label class="label-name">Gender :</label></td>
				<td><label class="radio"
					style="display: inline-block; color: #FFF"><input
						type="radio" name="gender" id="Male" value="m" checked>Male</label>
					<label class="radio" style="display: inline-block; color: #FFF"><input
						type="radio" name="gender" id="Female" value="f">Female</label></td>
			</tr>
			<tr>
				<td><label class="label-name">DOB :</label></td>
				<td>
					<!-- a href="javascript:NewCal('inputDob','ddmmmyyyy',true,24)" style="padding-left: 0px;"><input  name="dob" id="inputDob"  type='text'  placeholder="Date Of Birth"  onfocus='blur()' /></a -->
					<input type="text" name="dob" id="inputDob"
					placeholder="Date Of Birth" />
					<div id="emptyDob" class="bubble">
						<span style="color: #FFF">*This field is required.</span>
					</div>
				</td>
			</tr>
			<tr>
				<td><label class="label-name">Email ID :</label></td>
				<td><input type="text" id="inputEmail" name="inputEmail"
					placeholder="Email Id">
					<div id="emptyEmail" class="bubble">
						<span style="color: #FFF">*This field is required.</span>
					</div>
					<div id="InvalidEmail" class="bubble">
						<span style="color: #FFF">*Email Id Is not Valid.</span>
					</div></td>
			</tr>
			<tr>
				<td><label class="label-name">Passout Year :</label></td>
				<td><select style="width: 195px; height: 28px;"
					id="inputPassyr" class="box" name="inputPassyr">
						<option selected>-select-</option>
				</select>
					<div class="bubble" id="emptyPassyr">
						<span style="color: #FFF">*This field is required.</span>
					</div></td>
			</tr>
			<tr>
				<td><label class="label-name">Branch :</label></td>
				<td><select style="width: 195px; height: 28px;" class="box"
					id="selectBranch" name="branch">
						<option selected>-select-</option>
				</select>
					<div class="bubble" id="emptyBrach">
						<span style="color: #FFF">*Select Branch.</span>
					</div></td>
			</tr>
			<tr>
				<td><label class="label-name">Enrollment Id :</label></td>
				<td><input type="text" id="inputEnrno" name="inputEnrno"
					placeholder="Enrollment Id">
					<div id="emptyEnrno" class="bubble">
						<span style="color: #FFF">*This field is required.</span>
					</div></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<input type="submit" class="btn" id="signup_btn" value="Sign Up">
					</center>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>