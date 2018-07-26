<%@page import="com.mysql.jdbc.StringUtils"%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<%@ page import="com.alumni.admin.beans.*"%>
<%@ page import="java.util.List"%>
<script>
$('#usr-app-btn').addClass('click-btn-css');
</script>
<script>
$(document).ready(function() {		
	$.post('../UserAppDiaplySERVLET',{},function(responseText) { 
		//if(responseText != "null")
			$('#userapp').html(responseText);         
	});	
	
});
</script>
<div class="tab-content">
	<div id="usr-app">
		<label class="tab-title">Members Applications</label><br />
		<%String resultflag = request.getParameter("flag");
			if(!StringUtils.isNullOrEmpty(resultflag)||!StringUtils.isEmptyOrWhitespaceOnly(resultflag)){
			 	if(resultflag.equals("1")){
			 		%><%="User Application has been deleted!!" %>
		<%
			 	}
			 	if(resultflag.equals("2")){
			 		%><%="Can not able to delete " %>
		<%
			 	}
			 	if(resultflag.equals("3")){
			 		%><%="Status had been updated " %>
		<%
			 	}
			 	if(resultflag.equals("4")){
			 		%><%="can not be update the status" %>
		<%
			 	}
			}%>
		<div id=userapp></div>
	</div>
</div>
</body>
</html>
