
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<%@page import="com.alumni.admin.beans.NewsBEAN"%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$('#news-btn').addClass('click-btn-css');
</script>
<div class="tab-content">
	<div class="news" id="news">
		<label class="tab-title">Create NEWS</label><br /> <a
			href="../NewsDisplaySERVLET"><button class="crtbtn" id="crnews">Archive</button></a>
		<div class="create-news">
			<form method="post" method="post" action="../NewsCreateSERVLET">
				<table style="width: 60%; margin-left: 170px;">
					<tr>

						<th colspan="2">
							<%
                            	NewsBEAN bean = (NewsBEAN) request.getAttribute("bean");
                            	if(bean != null){
                            		if(bean.getSuccess()){      
                            			%>
							<div>News Created Successfully.</div>
							<br /> <%
                        			}else{         
                        				%>
							<div>Invalid Data.</div>
							<br /> <%
                        			}
                            	}%>Create News
						</th>
					</tr>
					<tr>
						<td colspan="2"><hr />
							<br /></td>
					</tr>
					<tr>
						<td><label>Title :</label></td>
						<td><input type="text" class="news-title" name="title"
							placeholder="Enter News Title" /></td>
					</tr>
					<tr>
						<td><label>Description :</label></td>
						<td><textarea rows="3" class="news-description"
								name="discription" placeholder="Description"></textarea></td>
					</tr>
					<tr>
						<td>Show/Hide :</td>
						<td style="text-align: left; padding-left: 40px;"><select
							name="status" style="align: left">
								<option selected="selected" value="0">Show</option>
								<option value="1">Hide</option>
						</select></td>

					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							style="margin-left: 0px;" class="crtbtn" id="crtbtnbtn"
							value="Create News" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</div>
</body>

</html>