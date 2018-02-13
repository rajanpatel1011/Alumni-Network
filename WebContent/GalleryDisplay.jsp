<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
 <div style="height:70%;">
 <iframe width="100%" height="70%" style="margin-bottom:20px" src="Gallery.jsp"></iframe>
 </div>
 <jsp:include page="footer.jsp" />    
</div>
</body>
</html>