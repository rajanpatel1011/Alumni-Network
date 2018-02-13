<%@page import="java.util.List"%>
<% 
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<jsp:include page="header.jsp" />
<jsp:include page="sidebar.jsp" />
<div class="tab-content" style="position: inherit;height:100%">
<%@ page import="com.alumni.admin.beans.*" %>
<script>
$('#news-btn').addClass('click-btn-css');
</script>
<div class="news" id="news">
                <label class="tab-title">Archive News</label><br />
                <a href="admin/createNews.jsp"><button class="crtbtn" id="crnews" >Create News</button></a>
				<div class="prvnews">
                	<table>
                		<tr class="colname">
                    		<th>ID</th>
                        	<th>Title</th>
                        	<th>Description</th>
    	                    <th>Show/Hide</th>
	                        <th>Delete</th>
        	                <th>Date</th>
            	            <th></th>
                	    </tr>
                    	<tr>
	                    	<td colspan="6">
                        		<hr />
                        	</td>
                    	</tr>
                    	<%
                    		int n=1;
							List<NewsBEAN>  list= (List<NewsBEAN>) request.getAttribute("list");
							if(list == null)
								out.println("<tr><td colspan='6'><font style='margin-top:250px'>No Users</font></td></tr>");	
							else 
							{
								//for(int i=0;i<=10;i++){
								for(NewsBEAN bean : list) {
                    	%>
					<form name='newsupdate' action='NewsUpdateSERVLET' method='post' >
								<tr>
                    				<td><%= n %></td>    
                        			<td><a href="#"><%= bean.getTitle() %></a></td>
                        			<td><%= bean.getDescription() %></td>
                        			<td>
                        				<select>
                        					<% if(bean.getHideStatus() == 0){ %>
                        							<option selected="selected">Show</option>
                            						<option>Hide</option>
                        					<%}else{ %>
		                        					<option>Show</option>
	                            					<option selected="selected">Hide</option>
                        					<%} %>
		                        			
                        				</select>
                        			</td>
                        			<td>
                        				<img src="/ff" alt="X" />
                        			</td>
                        			<td>
                        				<%= bean.getDate_time().getDate() +"-"+bean.getDate_time().getDay()+"-"+bean.getDate_time().getYear() %>
                        			</td>
                    			</tr>
			
			<%						n++;
	    	   					}
                    		       					}
	       					//}
	        %>
                    	
                     	
                    	<tr>
                    		<td colspan="6" style="margin-top:30px;padding-bottom: 140px;">
                        		<button class="crtbtn" ><center>Update</center></button>
                        	</td>                    
                    	</tr>
                </table>
			</div>
		</div>
</div>
</div>
</body>
</html>