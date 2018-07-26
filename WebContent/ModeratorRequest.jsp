<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/Mod.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
<script type="text/javascript" src="jquery.reveal.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Moderation Request</title>
<style>
.content {
	margin-top: 240px;
	position: absolute;
	background-color: #F5F1E5;
}

.main {
	background-color: #F5F1E5;
}

.CSSTableGenerator {
	color: #000;
	margin-bottom: 40px;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp" />
	<style type="text/css">
#mod_req {
	background-color: #F25C27;
	color: #FFF;
}
</style>
	<div class="content">
		<center>
			<div class="CSSTableGenerator">
				<%

String resultFlag=request.getParameter("resultFlag");
 if(resultFlag!=null && !"".equals(resultFlag))
{
if(resultFlag.equals("1"))
{%>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="red"> You can vote
								1 time only!</font></th>
					</tr>
				</table>

				<% }
	
 if(resultFlag.equals("2"))
 { %>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="red"> Check the
								vote box before you accept</font></th>
					</tr>
				</table>
				<% 
 }
	
if(resultFlag.equals("3"))
{ %>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="#11DA00">Request To
								Become A Moderator Rejected Successfully!</font></th>
					</tr>
				</table>
				<% 
}
if(resultFlag.equals("4"))
{ %>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="#11DA00">You have
								Voted Successfully As Moderator 1!</font></th>
					</tr>
				</table>
				<% 
}
if(resultFlag.equals("5"))
{ %>
				<table>
					<tr>
						<th bgcolor="#FFFF99"><font color="#11DA00">You have
								Voted Successfully As Moderator 2!</font></th>
					</tr>
				</table>
				<% 
}
}
	%>
				<table border="0" cellpadding="10" cellspacing="5">

					<tr>

						<th>No</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Gender</th>
						<th>Date Of Birth</th>
						<th>Email Id</th>
						<th>Pass Out Year</th>
						<th>Enrollment No</th>
						<th colspan="2">Select As A Moderator</th>
						<th></th>
						<th></th>
					</tr>


					<tr>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFF99">Moderator 1</th>
						<th bgcolor="#FFFF99">Moderator 2</th>
						<th bgcolor="#FFFFCC"></th>
						<th bgcolor="#FFFFCC"></th>


					</tr>

					<%@ page import="java.io.*"%>
					<%@ page import="com.alumni.beans.ModeratorRequestBean"%>
					<%@ page import="com.alumni.bo.UserRequestBO"%>
					<%@ page import="java.util.ArrayList"%>
					<%@ page import="java.util.List"%>

					<% 

List<ModeratorRequestBean> list =(List<ModeratorRequestBean>)request.getAttribute("list");

if(list == null)
	  
	out.println("<tr><td colspan='12'><font color='red'>No Users</font></td></tr>");
else
{
	 int n=1;
	for (ModeratorRequestBean bean:list)
	{  
		  out.println("<form action='ModeratorRequestSERVLET' method='post' >");	   
	%>


					<tr>
						<td>
							<%out.println(n);%>
						</td>
						<td>
							<%out.println(bean.getF_name());%>
						</td>
						<td>
							<%out.println(bean.getL_name()); %>
						</td>
						<td>
							<%out.println(bean.getGender()); %>
						</td>
						<td>
							<%out.println(bean.getDob()); %>
						</td>
						<td>
							<%out.println(bean.getEmail_Id()); %>
						</td>
						<td>
							<%out.println(bean.getP_name()); %>
						</td>
						<td>
							<%out.println(bean.getEnr_No()); %>
						</td>




						<%
	if(bean.getMod_Id1()!=0)
	{
		%>
						<td>
							<center>
								<input type='checkbox' name="<%=n%>" value="CA" checked /><%=bean.getMod1_name() %>
							</center>
						</td>


						<% 
	}
	else 
	{
		%>
						<td>
							<center>
								<input type='checkbox' name="<%=n%>" value="UA" />
							</center>
						</td>

						<% 
	}
	if( bean.getMod_Id2()!=0)
	{
		%>
						<td>
							<center>
								<input type='checkbox' name="<%=n%>" value="CB" checked /><%=bean.getMod2_name() %></center>
						</td>
						<% 
	}
	else
	{
		%>
						<td>
							<center>
								<input type='checkbox' name="<%=n%>" value="UB" />
							</center>
						</td>
						<% 
	}

%>


						<input type="hidden" value="<%=n%>" name="abc">
						<input type="hidden" value="<%=bean.getR_Id()%>" name="R_Id">
						<td><input type="submit" value="Accept" id="post-accept"
							name="Y" /></td>
						<td><input type="submit" value="Reject" id="post-reject"
							name="Y" /></td>
					</tr>

					</form>

					<% 
   n++;
	%>
					<%
	}
	%>
				</table>
				<% 
}



%>



			</div>
		</center>



		<jsp:include page="footer.jsp" />
	</div>


</body>
</html>
