<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<html>
<head>
<style>
#makeapp{
background-color: #F25C27;
color: #FFF;
};

#forum, #myprofile ,#searchmem,#gallery,#privmsg,#reportuser,#mod_req,#user_req{
background-color: #F5F1E5;
color: #000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Application</title>
<link rel="stylesheet" href="css/DocRequest.css" type="text/css" media="screen">
 <style>
   .content{
   	 margin-top:240px;
   	 position:absolute;
   	 
   	 background-color:#F5F1E5;
   	
   	 
   }
   .main{
   background-color:#F5F1E5;
   }
   
   .center tr td{
   		padding-left:60px;
   }
   </style>  
</head>
<body>
<jsp:include page="header.jsp" />
 <div class="content">
<form action=DocRequestAppSERVLET method="post">

			<% 
        String resultFlag=request.getParameter("flag");
        if(resultFlag!=null && !"".equals(resultFlag))
       {
       %>
          <%    if(resultFlag.equals("1"))
       {%>
<table align="center"> <tr> <th bgcolor="#211C19"><font color="#11DA00">Document Request Sent!</font>  </th></tr></table>       <%
            	}
              if(resultFlag.equals("2"))
          {%>
   <table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Try After sometime!</font>  </th></tr></table>       <%
               	}
              if(resultFlag.equals("3"))
              {%>
       <table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Fill Subject And Description Comulsory</font>  </th></tr></table>       <%
                   	}
            	} %>
			<table width="100%" height="100%" cellspacing="15" class="center" style="background-color:#F5F1E5;margin-bottom:60px;color:#000;">
            	
            	
            	<tr>
                	<td> Subject :</td>
                    <td><input type="text" name="subject" id="subject" style="width:800px;" placeholder="Subject of the application"></td>                    
                </tr>
              
             	<tr>
                	<td>Description :</td>
                    <td><textarea rows="5" name="description" id="subject" cols="1000" style="width:800px" placeholder="Desription of the application"></textarea></td>
                </tr>
                <tr>
                	<td colspan="2">
                    	<center><input type="submit" value="Send" class="btn" > </center>
                    </td>
                </tr>
	      </table>
      </form>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>