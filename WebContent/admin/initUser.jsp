<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$('#ini-usr-btn').addClass('click-btn-css');
</script>
<script>
$(document).ready(function() {	
	$.post('../PassoutYrDrpSERVLET',{},function(responseText) {
		if(responseText != "null")
			$('#inputPassyr').append(responseText);         
	});
	$.post('../BranchDrpSERVLET',{},function(responseText) { 
		if(responseText != "null")
			$('#selectBranch').append(responseText);         
	});			
	
	
	
	$( "#initUser" ).submit(function( event ) {
		event.preventDefault();
		var Fname = $("#fname").val();
		var Lname = $("#lname").val();
		var gender = $("input:radio[name='gender']").val();
		var dob = $("#dob").val();
		var Email = $("#email").val();
		var Passyr = $("#inputPassyr").val();
		var branch = $("#selectBranch").val();
		var Enrno = $("#enrno").val();
		var uid = $("#uid").val();
		var pwd = $("#pwd").val();
		var cpwd = $("#cpwd").val();
		
			
		$.post('../InitUserSERVLET',
				{inputFname:Fname,inputLname:Lname,gender:gender,dob:dob,inputEmail:Email,inputPassyr:Passyr,branch:branch,inputEnrno:Enrno,uid:uid,pwd:pwd,cpwd:cpwd},
			function(responseText) { 
				if(responseText != "null"){
					if(responseText = "pwd"){
						$('#msg').html("Confirm password not matched.");
					}else{
					$('#msg').html(responseText);
					$("#fname").val("");
					$("#lname").val("");
					$("input:radio[name='gender']").val("");
					$("#dob").val("");
					$("#email").val("");
					$("#inputPassyr").val("");
					$("#selectBranch").val("");
					$("#enrno").val("");
					$("#uid").val("");
					$("#pwd").val("");
					$("#cpwd").val("");
					}
				}
				else
					$('#msg').html("Internal Server Error.Click <a href='index.jsp'>here</a> and try again.");
			}
			
		);
	}				
);
});


</script>
<style>
td input{
			width:195px;
}
td{
	text-align:left;
}
</style>
<div class="tab-content">
            <div id="ini-usr">
            	<label class="tab-title">Initial Users</label>
            		<form id="initUser" method="post">
					<table>
							<tr>
								<td colspan="2" style="text-align:center;" id="msg" >
									
								</td>
							</tr>
            				<tr>
            					<td>First Name :</td>
         					    <td><input type="text" name="fname" id="fname" /> </td>
            				</tr> 
            				
            				<tr>
            					<td>Last Name :</td>
         					    <td><input type="text" name="lname" id="lname"/> </td>
            				</tr>

            				<tr>
            					<td>Gender :</td>
         					    <td><input type="radio" style="width:10px;" name="gender" id="Male" value="m" checked>Male<input type="radio" style="width:10px;" name="gender" id="Female" value="f">Female</td>
            				</tr>
            			
            				<tr>
            					<td>DOB :</td>
         					    <td><input type="text" name="dob" id="dob" /> </td>
            				</tr>
            				<tr>
            					<td>Email :</td>
         					    <td><input type="text" name="email" id="email" /> </td>
            				</tr>
            				<tr>
            					<td>Passout Year :</td>
         					    <td><select style="width:195px;height:28px;" id="inputPassyr" class="box" name="inputPassyr">
			<option selected>-select-</option>
			</select> </td>
            				</tr>
            				<tr>
            					<td>Branch :</td>
         					    <td><select style="width:195px;height:28px;" class="box" id="selectBranch" name="branch">
				<option selected>-select-</option>
			</select> </td>
            				</tr>
            				<tr>
            					<td>Enrollment No :</td>
         					    <td><input type="text" name="enrno" id="enrno"/> </td>
            				</tr>
            				<tr>
            					<td>UserID :</td>
         					    <td><input type="text" name="uid" id="uid" /> </td>
            				</tr>
            				
            				<tr>
            					<td>Password :</td>
         					    <td><input type="password" name="pwd" id="pwd"/> </td>
            				</tr>
            				
            				<tr>
            					<td>Confirm Password :</td>
         					    <td><input type="password" name="cpwd" id="cpwd" /> </td>
            				</tr>           				
            				
            				<tr>
            					<td colspan="2"><input type="submit" class="crtbtn" value="Add"/></td>
            				</tr>            				
				</table>
				</form>
			</div>
</div>
</div>
</body>
</html>