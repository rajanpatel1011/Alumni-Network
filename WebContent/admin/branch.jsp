<%@page import="com.mysql.jdbc.StringUtils"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$('#branch-btn').addClass('click-btn-css');
</script>
<script>
$(document).ready(function() {	
	$.post('../BranchDisplaySERVLET',{},function(responseText) { 
		if(responseText != "null")
			$('#branchlist').html(responseText);         
	});	

	$( "#addBranch" ).submit(function( event ) {	
		event.preventDefault();
		var branch = $("#inputbranch").val();
		$("#inputbranch").val("");
		
		//alert(branch);
		$.post('../BranchAddSERVLET',{inputbranch:branch},function(responseText) {
					//alert(responseText);
					
					$.post('../BranchDisplaySERVLET',{},function(responseText2) { 
						if(responseText2 != "null")
							$('#branchlist').html(responseText2);         
					});
					$('#msg').html(responseText);
			});
		
		
	});

});
	
	
	



</script>

<div class="tab-content" style="position:initial">
	<div id="branch">
		<label class="tab-title"></label><br />    
			<table style="width:60%">
				<tr>
					<th>
						<button class="batch-btn2">Branch</button>
					</th>
				</tr>
				<tr>
					<td>
					
						<div id="msg"></div>
						<%String resu=request.getParameter("result");
						if(!StringUtils.isEmptyOrWhitespaceOnly(resu)||!StringUtils.isNullOrEmpty(resu)){
							
						 	if(resu.equals("1")){
							 	%><%="Branch has been deleted successfully!" %><%
						 	}
						 	if(resu.equals("2")){
							 	%><%="Branch can not be delete!!" %><%
						 	}
						}%>
						<div class="batch2" id="branchlist">
						</div>
						<form id="addBranch" method="post">
						<table>
						
						<tr><td colspan='2'><hr/></td></tr><tr><td>Branch : </td><td><input type='text' name='branch' id='inputbranch' /></td></tr></table><input type='submit' class='crtbtn' value='Add'/><br/><br/><hr/>
						</form>
					</td>
				</tr>
			</table>        			
	</div>
</div>
</div>
</body>
</html>