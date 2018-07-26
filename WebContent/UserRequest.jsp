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
<style>
#user_req {
	background-color: #F25C27;
	color: #FFF;
}

#forum, #myprofile, #searchmem, #gallery, #privmsg, #makeapp,
	#reportuser, #mod_req {
	background-color: #F5F1E5;
	color: #000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Table.css" type="text/css"
	media="screen">
<style>
.content {
	margin-top: 240px;
	position: absolute;
	background-color: #F5F1E5;
}

.main {
	background-color: #F5F1E5;
}
</style>


</head>
<body>
	<jsp:include page="header.jsp" />
	<style type="text/css">
#user_req {
	background-color: #F25C27;
	color: #FFF;
}
</style>
	<div class="content">
		<body bgcolor="#F9F5ED" style="color: #000">
			<center>

				<div class="CSSTableGenerator" style="margin-bottom: 40px">

					<%@ page import="java.io.*"%>
					<%@ page import="com.alumni.beans.UserRequestBean"%>
					<%@ page import="com.alumni.dao.UsersRequestDAO"%>
					<%@ page import="com.alumni.bo.UserRequestBO"%>
					<%@ page import="java.util.ArrayList"%>
					<%@ page import="java.util.List"%>

					<%
	try{
		
	
		%>

					<%
			String flag = request.getParameter("flag");
		       if(flag != null && !"".equals(flag)){
		       if(flag.equals("1")){
		    	   %>

					<table>
						<tr>
							<th bgcolor="#FFFF99"><font color="red">Please Accept
									or Reject User. </font></th>
						</tr>
					</table>
					<%
		    	//   out.println("<font style='margin-top:250px'></font>");
		       }
		       }
			
			%>
					<table border="0" style="color: #000" cellpadding="10"
						cellspacing="5">



						<tr>
							<th>No</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>Gender</th>
							<th>Date Of Birth</th>
							<th>Email Id</th>
							<th>Branch</th>
							<th>Passout Year</th>
							<th>Enrollment No</th>
							<th>Status</th>
						</tr>
						<tr>
						</tr>

						<%  
	       int n=1;
	       List<UserRequestBean>  list=(List<UserRequestBean>)request.getAttribute("list");
	       
	       if(list == null)	    	  
	 			out.println("<tr><td bgcolor='#FFFF99' colspan='10'><font color='red' style='margin-top:250px'><h2>No Users</h2></font></td></tr>");
	       else 
	       {
	    	 
	    	   for(UserRequestBean bean : list) {
	    		   out.println("<form name='UserRequest' action='UserRequestServlet' method='post' >");	  	    
	        %>

						<tr>

							<td>
								<%out.println(n);%>
							</td>
							<td>
								<%out.println(bean.getF_name()); %>
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
								<%out.println(bean.getEmail_id()); %>
							</td>
							<td>
								<%out.println(bean.getB_name()); %>
							</td>
							<td>
								<%out.println(bean.getP_year()); %>
							</td>
							<td>
								<%out.println(bean.getEnr_no()); %>
							</td>
							<td><input type="radio" id="y" name="<%=n%>"
								value="Y<%=bean.getTempUID() %>" /> Accept &nbsp;&nbsp; <input
								type="radio" id="n" name="<%=n%>"
								value="N<%=bean.getTempUID()%>" /> Reject
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
								type="submit" value="Submit" name="Update<%=n%>" id="updatebtn" />
								<input type="hidden" value="<%=n%>" name="r_value"> <% n++; %>
							</td>

						</tr>
						</form>
						<% } 
	
	       }

	
	%>


					</table>
				</div>

				<% }
	       
catch(Exception e)
	{
		System.out.println(e);
	}

	%>

			</center>

			<jsp:include page="footer.jsp" />
	</div>
</body>
</html>