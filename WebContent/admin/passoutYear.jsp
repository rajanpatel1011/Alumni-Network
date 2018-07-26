
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$('#pyear-btn').addClass('click-btn-css');
</script>
<script>
$(document).ready(function() {		
	$.post('../PassoutYearDisplaySERVLET',{},function(responseText) { 
		//if(responseText != "null")
			$('#pass-yr2').html(responseText);         
	});	
	
	
	
	$( "#addYear" ).submit(function( event ) {	
		event.preventDefault();
		var year = $("#year").val();
		$("#year").val("");
		//alert(year);
		$.post('../PassoutYearAddSERVLET',{year:year},function(responseText) {
					//alert(responseText);
					$.post('../PassoutYearDisplaySERVLET',{},function(responseText2) { 
							//if(responseText != "null")
							$('#pass-yr2').html(responseText2);         
					});	

					$('#msg').html(responseText);
			});
		
		
	});
});
</script>

<div class="tab-content" style="position: initial;">
	<div id="pyear">
		<label class="tab-title"></label><br />
		<table style="width: 60%">
			<tr>
				<th>
					<button class="pass-yr-btn2">Passout Year</button>
				</th>
			</tr>
			<tr>
				<td>
					<div id="msg"></div> <%String resu=request.getParameter("fl");
							if(!"".equals(resu)||null!=(resu)||!"null".equals(resu)){
						 	 	if(("-1").equals(resu)){
							 		%><%="Year has been deleted successfully!" %>
					<%
					 			}
						 	 	if(("-2").equals(resu)){
							 		%><%="Year can not be delete!!" %>
					<%
						 		}
						}%>
					<div class="pass-yr2" id="pass-yr2"></div>
					<form id="addYear" method="post">
						<table>
							<tr>
								<td colspan='2'><hr /></td>
							</tr>
							<tr>
								<td>Year :</td>
								<td><input type='text' name='year' id="year" /></td>
							</tr>
						</table>
						<input type="submit" class='crtbtn' value="Add" /><br />
						<br />
						<hr />
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>
</body>
</html>