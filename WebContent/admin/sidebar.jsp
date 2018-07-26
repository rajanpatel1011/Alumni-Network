
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<div class="containt">
	<div class="tabs">
		<div></div>
		<% String url = null;
        	url = (String) request.getAttribute("javax.servlet.forward.request_uri"); 
        	if(url == null){
        		url = "aoaoaoaoaoaoaooaooaoa";
        	}
        	System.out.print("Url =>"+url);
        		String strurl = url.substring(0, 7);
        		System.out.print("strurl =>"+strurl);
        		if(strurl.equals("/Alumni")){
        			if(strurl.length() > 13){
            			if(strurl.subSequence(0, 13).equals("/Alumni/admin")){
            			
        			%>
		<div>
			<a href="newsdisplayservlet.jsp"><button id="news-btn">News</button></a>
		</div>
		<div>
			<a href="eventdisplayservlet.jsp"><button id="event-btn">Events</button></a>
		</div>
		<div>
			<a href="initMod.jsp"><button id="ini-mod-btn">Initial
					Modrators</button></a>
		</div>
		<div>
			<a href="initUser.jsp"><button id="ini-usr-btn">Initial
					Users</button></a>
		</div>
		<div>
			<a href="userApp.jsp"><button id="usr-app-btn">User
					Applications</button></a>
		</div>
		<div>
			<a href="branch.jsp"><button id="branch-btn">Branch</button></a>
		</div>
		<div>
			<a href="passoutYear.jsp"><button id="pyear-btn">PassoutYear</button></a>
		</div>
		<div>
			<a href="HelpandSupportDisplaySERVELT.jsp"><button
					id="help-spt-btn">Help/Supprot</button></a>
		</div>

		<%}
        			}else{ %>
		<div>
			<a href="NewsDisplaySERVLET"><button id="news-btn">News</button></a>
		</div>
		<div>
			<a href="EventDisplaySERVLET"><button id="event-btn">Events</button></a>
		</div>
		<div>
			<a href="admin/initMod.jsp"><button id="ini-mod-btn">Initial
					Modrators</button></a>
		</div>
		<div>
			<a href="admin/initUser.jsp"><button id="ini-usr-btn">Initial
					Users</button></a>
		</div>
		<div>
			<a href="admin/userApp.jsp"><button id="usr-app-btn">User
					Applications</button></a>
		</div>
		<div>
			<a href="admin/branch.jsp"><button id="branch-btn">Branch</button></a>
		</div>
		<div>
			<a href="admin/passoutYear.jsp"><button id="pyear-btn">PassoutYear</button></a>
		</div>
		<div>
			<a href="HelpandSupportDisplaySERVELT"><button id="help-spt-btn">Help/Supprot</button></a>
		</div>

		<%
        			}
        		}else{
        			%>

		<div>
			<a href="newsdisplayservlet.jsp"><button id="news-btn">News</button></a>
		</div>
		<div>
			<a href="eventdisplayservlet.jsp"><button id="event-btn">Events</button></a>
		</div>
		<div>
			<a href="initMod.jsp"><button id="ini-mod-btn">Initial
					Modrators</button></a>
		</div>
		<div>
			<a href="initUser.jsp"><button id="ini-usr-btn">Initial
					Users</button></a>
		</div>
		<div>
			<a href="userApp.jsp"><button id="usr-app-btn">User
					Applications</button></a>
		</div>
		<div>
			<a href="branch.jsp"><button id="branch-btn">Branch</button></a>
		</div>
		<div>
			<a href="passoutYear.jsp"><button id="pyear-btn">PassoutYear</button></a>
		</div>
		<div>
			<a href="HelpandSupportDisplaySERVELT.jsp"><button
					id="help-spt-btn">Help/Supprot</button></a>
		</div>
		<%
        		}
        	%>






	</div>