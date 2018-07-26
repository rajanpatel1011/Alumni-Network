
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

<head>
<title>Events</title>
</head>
<body>
	<%@page import="java.util.List"%>
	<%@page import="com.alumni.admin.beans.EventDisplayBEAN"%>

	<div class="tab-content" style="position: inherit;">

		<div id="event">

			<label class="tab-title">Events</label><br /> <a
				href="admin/createEvents.jsp"><button class="crtbtn" id="crevnt">Create
					Event</button></a>
			<div class="prv-events">

				<%
String resultFlag=request.getParameter("flag");
if(resultFlag!=null && !"".equals(resultFlag) )
{ 
 	if(resultFlag.equals("1"))
	{
		%>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="Green"> Message
								Sent Successfully!</font></th>
					</tr>
				</table>
				<% 
	}
 	if(resultFlag.equals("2"))
	{
		%>
				<font align="right" color="Green"> Event Will not be shown to
					members </font>
				<% 
	}
}
%>

				<table cellspacing="10px" cellpadding="10px"
					style="padding-bottom: 190px;">
					<tr class="colname">

						<th>ID</th>
						<th>Title</th>
						<th>Organized Date</th>
						<th>Description</th>
						<th>Date</th>
						<th>Show/Hide</th>


					</tr>
					<tr>
						<td colspan="6">
							<hr />
						</td>
					</tr>
					<%

List<EventDisplayBEAN> list=(List<EventDisplayBEAN>)request.getAttribute("List");
if(list==null)
{
	out.println("<tr><td colspan='6'>NO EVENTS</td></tr> ");
}
else
{	int i=1;
	for(EventDisplayBEAN bean: list)
	{ 
	
	
        
	%>
					<form method="Post" action="EventVisibilitySERVLET">
						<tr>
							<td><%=i%></td>
							<td><a href="#"> <%=bean.getTitle()%></a></td>
							<td><%=bean.getOrg_date() %></td>
							<td
								style="max-width: 200px; overflow: auto; white-space: pre-wrap;"><%=bean.getDescription() %>
							</td>
							<td><%=bean.getPosteddate() %></td>
							<input type="hidden" name="hidden"
								value="<%=bean.getEvent_id()%>" />
							<td><select name="option">
									<option value="1">Show</option>
									<option value="2">Hide</option>
							</select></td>

							<td><a
								href="EventDeleteSERVLET?param=<%=bean.getEvent_id()%>"><img
									src="images/delete.png" height="20" width="20"></td>

							<td><input type="submit" id="post-btn" name="Update"
								value="update"></td>
						</tr>
					</form>

					<% 	i++;
		}
}

%>





				</table>
			</div>
		</div>

	</div>
	</div>
</body>
</html>