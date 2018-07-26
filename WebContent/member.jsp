<%@page import="com.alumni.beans.LoginBEAN"%>
<% // include header file %>


<jsp:include page="header.jsp" />
<% LoginBEAN loginBEAN = (LoginBEAN) session.getAttribute("loginBEAN");
if(loginBEAN.getRole() == 1){
	response.sendRedirect("moderator.jsp");
} %>
<% // tabs for member  %>
<div class="tab-block">
	<div class="tab">
		<label class="active-tab"><a href="#tab1" id="forum">
				Forum </a></label> <label id="myprofilelbl"><a href="#tab2"
			id="myprofile"> My Profile </a></label> <label><a href="#tab3"
			id="searchmem"> Search Member </a></label> <label><a href="#tab4"
			id="gallery"> Gallery </a></label> <label><a href="#tab5"
			id="privmsg"> Private Message</a></label> <label><a href="#tab6"
			id="makeapp"> Make Application </a></label>
	</div>
</div>
</div>

<% // All Tab Contents of Member %>
<div class="content">
	<div id="tab1"
		style="max-height: 500px; overflow-y: scroll; display: block; height: 400px;">
	</div>
	<div id="tab2"
		style="max-height: 500px; overflow-y: scroll; display: block; height: 400px; margin-left: 15px; margin-right: 15px; padding-left: 20px; background-color: #F4ECDD;">
	</div>
	<div id="tab3">Tab 3 Contents</div>
	<div id="tab4">Tab 4 Contents</div>
	<div id="tab5">Tab 5 Contents</div>
	<div id="tab6">Tab 6 Contents</div>

</div>
<jsp:include page="footer.jsp" />