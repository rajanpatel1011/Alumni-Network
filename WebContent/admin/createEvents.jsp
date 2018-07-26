
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$('#event-btn').addClass('click-btn-css');



	
</script>





<body>

	<div class="tab-content">

		<div id="event">
			<label class="tab-title">Events</label><br /> <a
				href="../EventDisplaySERVLET"><button class="crtbtn" id="crevnt">Archive
					Event</button></a>

			<div class="create-event">

				<%
String resultFlag=request.getParameter("flag");
if(resultFlag!=null && !"".equals(resultFlag) )
{ 
 	if(resultFlag.equals("1"))
	{
		%>
				<font align="right" color="Red"> All the Details are
					Compulsory!</font>
				<% 
	}
 	if(resultFlag.equals("2"))
	{
		%>
				<font align="right" color="Red"> Event Posted Successfully!</font>
				<% 
	}
}
%>
				<form method="post" enctype="multipart/form-data"
					action="../EventCreateSERVLET">
					<table>
						<tr>
							<th colspan="2">Create Event</th>
						</tr>
						<tr>
							<td colspan="2"><hr />
								<br /></td>
						</tr>
						<tr>
							<td><label>Title</label></td>
							<td><input type="text" class="news-title" name="title"
								placeholder="Enter News Title" /></td>
						</tr>
						<tr>
							<td><label>Event Poster :</label></td>
							<td><input type="file" name="imagefile" class="upload"
								id="event-pic" /></td>
						</tr>
						<tr>
							<td><label>Organized Date :</label></td>
							<td><input type="date" name="OrgDate" class="org-dt"
								placeholder="Organized Date" /></td>
						</tr>
						<tr>
							<td><label>Description</label></td>
							<td><textarea rows="3" name="description"
									class="news-description" placeholder="Description"></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="Button"
								style="margin-left: 0px;" class="crtbtn" id="crtbtnbtn"
								value="Create News" /> <input type="submit" class="crtbtn"
								id="pubnewsbtn" value="Publish" /></td>
						</tr>
					</table>
				</form>
			</div>

		</div>

	</div>
	</div>
</body>
</html>