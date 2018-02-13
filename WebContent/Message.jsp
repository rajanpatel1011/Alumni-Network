<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.alumni.beans.MsgBEAN" %>
<%@page import="com.alumni.bo.MsgBO" %>
<%@page import="java.util.List" %>
<%@page import="java.sql.SQLException" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<html>

<head>
<style>
#privmsg{
background-color: #F25C27;
color: #FFF;
}

#forum, #myprofile ,#searchmem,#gallery,#makeapp,#reportuser,#mod_req,#user_req{
background-color: #F5F1E5;
color: #000;
}
</style>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="css/style.css" rel="stylesheet" type="text/css">


<!-------------------------- starts SCRIPT for message  ----------------------------->


<script type="text/javascript" language="javascript">
	
		function blank(control,msg)
		{
			if(control.value=="")
			{
				alert(msg);
				control.focus();
				return false;
			}
			
			return true;
		}
		
		function fetchUsers(username)
		{
			
			var username = document.attdForm.classSelect.value;
			
			if (username=="")
			  {
			  
			  return;
			  } 
			
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  		xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			    document.getElementById("subjectList").innerHTML=xmlhttp.responseText;
			    }
			  }
			xmlhttp.open("GET","getSubjects.php?classId="+classId,true);
			xmlhttp.send();
			
			
		}
		
		function val(frm)
		{
				with(frm)
				{
					if(blank(f1,"This field is required!")==false)
					{
						return false;
					}
					
					if(fetchUsers(f1)==false)
					{
						return false;
					}
										
					if(blank(f2,"This field is required!")==false)
					{
						return false;
					}
					
			}
	}
</script>
<!-------------------------- ends Script for message ---------------------------->

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<style>
   .content{
   	 margin-top:240px;
   	 position:absolute;
   	 background-color:#F5F1E5;
   }
   .main{
   background-color:#F5F1E5;
   }
</style>
</head>



<body>
<jsp:include page="header.jsp" />
 <div class="content">
 	<div class="main" style="border-top-right-radius: 50px;border-bottom-left-radius: 50px;margin-left: 10px;margin-right: 10px;margin-bottom: 20px;">
	 <form id="form1" name="form1" method="post" action="MsgCreateSERVLET" >  
<script type="text/javascript">

$(document).ready(function() {
	
	$("#newpost-content1").show();
});
</script>
	<div class="newpost-content" id="newpost-content1" >
        
        <div style="float:left;width:80%;" class="newpost-content2">
          <legend style="margin-left:40px;margin-right:0px;width:92%;margin-top:40px;">
          <h4>New Message</h4>
          </legend>
          <h4 style="margin-left:40px;margin-right:10px;display:inline">User :</h4>
          <input type="text" name="f1" class="foruminput" style="margin-left:29px;margin-right:10px;width:70%;" placeholder="Enter name of the user" onChange="fetchUsers()">
          <br />
          <h4 style="margin-left:40px;margin-right:10px;display:inline">Message :</h4>
          <textarea name="f2" class="forumtextarea" rows="2" style="margin-right:21px;width:70%;" placeholder="Enter your message"></textarea>
        </div>


		 <div style="float:left;margin-top:40px;" class="newpost-content3">
		<br />

          <button id="post-btn" type="submit" name="button" id="button" value="Submit" onclick="return val(form1)" >Send</button>
      	</div>
        
        <div style="margin-top:225px;" >
          <button class="newpost-btn" id="newpost-btn1"> New Message </button>
        </div>
	</div>
	 </form>  		
	
<!------------------ Received Messages starts --------------->

	<div class="forum" id="i-fourm">
        <form class="form-search">
          <span style="font-size:16px;font-weight:bold;">Search :</span>
          <input type="text" style="width:70%;font-size:14px;height:25px;margin:20px;margin-left:40px;margin-right:40px;" class="input-medium search-query">
          <button type="submit" class="btn">Search</button>
        </form>
        <div class="all-forum">
          <table width="100%" height="100%" class="table table-hover" style="margin-bottom:-10px;">
            <caption>            </caption>
            
            <thead>
              <tr>
                <th>No</th>
                <th>User</th>
                <th>Message</th>
                <th>Date</th>
                <th>Time</th>
              </tr>
            </thead>
            <tbody>
            
            	<% 
            	List<MsgBEAN> list = (List<MsgBEAN>)request.getAttribute("list");
            	int a=0;
            	for(MsgBEAN mb1:list)
            	{
            	%> 	
    					<tr>
    						<td><%= a=a+1 %></td>
    						<% String link = "StudentSERVLET?id="+mb1.getCreator_id(); %>
 							<td><a href="<%= link %>"><%= mb1.getF_name() %> <%= mb1.getL_name() %></a></td>
    		                <td><%= mb1.getDisription() %></td>
    		                <td colspan="2"><%= mb1.getDate_time() %></td>
    					</tr>
    			<%
    			}
    			%>
            		
            
            </tbody>
          </table>
        </div>
        </div>
        <jsp:include page="footer.jsp" />    
</div>
      </div>
	
<!------------------------- Received Message ends -------------------------->


</body>

</html>
