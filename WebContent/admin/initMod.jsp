<%@page import="com.mysql.jdbc.StringUtils"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<script>
$(document).ready(function() {	
	$.post('../InitModDisplaySERVLET',{},function(responseText) { 
		if(responseText != "null")
			$('#list').append(responseText);         
	});			
});
</script>
<script>
$('#ini-mod-btn').addClass('click-btn-css');
</script>
<div class="tab-content">
	<div id="ini-mod">
		<%String f=request.getParameter("result");
 	 			 	if(!StringUtils.isEmptyOrWhitespaceOnly(f)||!StringUtils.isNullOrEmpty(f)){
 						if(f=="1"){
 							%><%="Request Send... " %>
		<%
 						}
 						if(f=="2"){
 							%><%="Try..." %>
		<%
 						}
 						if(f=="3"){
 							%><%="Internal error.." %>
		<%
 						}
 	 			 	}%>
		<label class="tab-title">Initial Modrator</label><br />


		<div align="center">
			<br />
			<div id=list></div>
		</div>
	</div>
</div>
</div>

</body>
</html>