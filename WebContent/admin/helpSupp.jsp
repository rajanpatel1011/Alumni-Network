
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>



<jsp:include page="header.jsp" />

<jsp:include page="sidebar.jsp" />
<head>
<script>
$('#help-spt-btn').addClass('click-btn-css');

$(document).ready(function(e) {
	$('#send-reply').hide();
    $('#Reply').click(function(){
		$('#send-reply').toggle(80);
	}	
	);
});

</script>
</head>

<%@page import="com.alumni.admin.servlet.HelpandSupportDisplaySERVELT"%>
<%@page import="com.alumni.admin.beans.HelpandSupportBEAN"%>
<%@page import="java.util.List"%>
<body>
	<div class="tab-content"
		style="position: inherit; padding-bottom: 300px;">
		<div id="help-spt">
			<label class="tab-title">Help/Support</label><br />
			<table cellpadding="5" cellspacing="10" width="50%" height="100px"
				style="margin-left: 200px;">
				<tr>
					<th>No</th>
					<th>Email_Id</th>
					<th>Message</th>

				</tr>
				<tr>
					<td colspan="7"><hr /></td>
				</tr>

				<%
				
				String resultFlag=request.getParameter("flag");
				if(resultFlag!=null && !"".equals(resultFlag) )
				{ 
				 	if(resultFlag.equals("1"))
					{
						%>
				<font align="center" color="Green"> Message sent
					successfully!</font>
				<%
					} 
				}
				List<HelpandSupportBEAN> list=(List<HelpandSupportBEAN>)request.getAttribute("list");
				int i=1;
				if(list==null)
				{ 
					%>
				<table>
					<tr>
						<th>No Messages</th>
					</tr>
				</table>
				<%
				}
				else
				{ 
				
				for(HelpandSupportBEAN bean: list)
				{
					
				
				
				%>


				<form action="SendReplySERVELET" method="post">
					<tr>
						<td><%=i%></td>
						<td><%=bean.getEmail_id()%></td>
						<input type="hidden" name="email" value="<%=bean.getEmail_id()%>" />
						<input type="hidden" name="E_id" value="<%=bean.getH_id()%>" />
						<td
							style="max-width: 200px; overflow: auto; white-space: pre-wrap;"><%=bean.getMessage()%></td>
						<td><a
							href="DeteteHelpandSupportSERVELET?param=<%=bean.getH_id()%>"><img
								src="images/delete.png"></a></td>
						<td>&nbsp; &nbsp;</td>
						<td><input type="button" name="Reply" value="Reply"
							id="Reply"></td>


						<td>
							<div class="send-reply">
								<textarea name="message"></textarea>
								<input type="submit" name="Reply" id="Send">

							</div>
						</td>

					</tr>
				</form>
				<%
				 i++;
				 }
				}
				
				%>

			</table>
		</div>
	</div>
	</div>
</body>
</html>