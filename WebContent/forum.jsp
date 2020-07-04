<%@page import="java.util.ArrayList"%>
<%@page import="com.alumni.beans.CommentBEAN"%>
<%@page import="com.alumni.beans.LoginBEAN"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.alumni.beans.LoginBEAN"%>
<%@page import="com.alumni.beans.ForumBean"%>
<%@page import="com.alumni.bo.ForumBO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
	int forum_Id = 0;
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>
#forum {
	background-color: #F25C27;
	color: #FFF;
}

;
#myprofile, #searchmem, #gallery, #privmsg, #makeapp, #reportuser,
	#mod_req, #user_req {
	background-color: #F5F1E5;
	color: #000;
}
</style>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link href="css/style.css" rel="stylesheet" type="text/css">

<!-------------------------- starts SCRIPT for forum  ----------------------------->
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
		function value(control,msg)
		{
			if(control.value=="0")
			{
				alert(msg);
				control.focus();
				return false;
			}
			
			return true;
		}
		
		function val(frm)
		{
				with(frm)
				{
					if(blank(f1,"This field is required!")==false)
					{
						return false;
					}
					
					if(blank(f2,"This field is required!")==false)
					{
						return false;
					}
					
					if(value(f3,"Select visibility!")==false)
					{
						return false;
					}
			}
	}
		
		
</script>
<!-------------------------- ends Script for forum ---------------------------->


</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<form id="form1" name="form1" method="post"
			action="ForumCreateSERVLET">

			<div style="margin-left: 10px; margin-right: 10px;">
				<div class="newpost-content" id="newpost-content1"
					style="border-top-right-radius: 50px;">
					<div id="newforum">
						<div style="float: left; width: 70%;" class="newpost-content2">
							<legend
								style="margin-left: 40px; margin-right: 0px; width: 92%; margin-top: 40px;">
								<h4>New Post :</h4>
							</legend>
							<h4
								style="margin-left: 40px; margin-right: 10px; display: inline">Subject
								:</h4>
							<input type="text" name="f1" class="foruminput"
								style="margin-left: 31px; margin-right: 10px; width: 70%;"
								placeholder="Enter Subject/Topic Name "> <br />
							<h4
								style="margin-left: 40px; margin-right: 10px; display: inline">Description
								:</h4>
							<textarea name="f2" class="forumtextarea" rows="4"
								style="margin-right: 21px; width: 70%; vertical-align: top; resize: none;"
								placeholder="Enter your Description/Message"></textarea>
						</div>


						<div style="float: left; margin-top: 40px;"
							class="newpost-content3">
							<br />
							<script type="text/javascript">
$(document).ready(function() {
	$.post('PermisionDrpSERVLET',{},function(responseText) {
		if(responseText != "null")
			$('#inputPerm').append(responseText);         
	});	
});

</script>
							<select style="margin-top: 20px;" class="forumselect" name="f3"
								id="inputPerm">
								<option value="0" selected="selected">-select-</option>

							</select> <br /> <br /> <br />
							<button id="post-btn" type="submit" name="button" id="button"
								value="Submit" onclick="return val(form1)">Post</button>
						</div>
					</div>

					<div style="margin-top: 225px;">
						<button type="button" class="newpost-btn" id="newpost-btn1">
							New Post</button>
					</div>
				</div>
			</div>
		</form>

		<!------------------ Forum Posts starts --------------->

		<div class="forum" id="i-fourm"
			style="border-top-right-radius: 50px; border-bottom-left-radius: 50px; margin-left: 10px; margin-right: 10px; margin-bottom: 20px;">
			<div style="margin-top: 0px; width: 100%">
				<button class="newpost-btn" id="newpost-btn2">New Post</button>
			</div>
			<!-- form class="form-search">
          <span style="font-size:16px;font-weight:bold;">Forum Search :</span>
          <input type="text" style="width:70%;font-size:14px;height:25px;margin:20px;margin-left:40px;margin-right:40px;" class="input-medium search-query">
          <button type="submit" class="btn1">Search</button>
        </form -->
			<br /> <br /> <br /> <br />
			<div class="all-forum" style="margin-bottom: 20px;">
				<table width="100%" height="100%" class="table table-hover"
					style="margin-bottom: -10px;">
					<caption></caption>
					<style>
.tableHead tr th {
	text-align: center;
	vertical-align: middle;
}
</style>
					<thead class="tableHead">
						<tr style="color: #EA8C2D;">
							<th>Permission</th>
							<th>No. of Comments</th>
							<th>Subject</th>
							<th>Creator Id</th>
							<th>Date</th>
							<th>Time</th>
							<th>Fav</th>
						</tr>
					</thead>
					<tbody class="selectforum">
						<%
							SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
						SimpleDateFormat fmt1 = new SimpleDateFormat("HH:hh:ss");
						List<ForumBean> list = (List<ForumBean>) request.getAttribute("list");
						String c_Id = (String) session.getAttribute("cmt_Id");
						session.removeAttribute("cmt_Id");
						System.out.print("coment ID" + c_Id);
						//ForumBean fb;
						LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");
						ArrayList<CommentBEAN> cmtArray;
						int i = 0;
						for (ForumBean fb1 : list) {
						%>
						<tr id="posted-forum<%=i%>" class="forum">
							<td style="text-align: center;"><%=fb1.getPerm_name()%></td>
							<td style="text-align: center;"><%=fb1.getNo_Of_cmt()%></td>
							<td style="text-align: center;"><%=fb1.getP_sub()%></td>
							<%
								String link = "StudentSERVLET?id=" + fb1.getCreator_id();
							%>
							<td style="text-align: center;"><a href="<%=link%>"><%=fb1.getF_name()%></a></td>
							<td style="text-align: center;"><%=fmt.format(fb1.getDate_time())%></td>
							<td style="text-align: center;"><%=fmt1.format(fb1.getDate_time())%></td>
							<%
								if (fb1.isPinned()) {
							%>

							<td style="text-align: center;">
								<form action="RemoveFavForumSERVLET" name="remfavform<%=i%>"
									method="post">
									<input type="hidden" value="comment<%=i%>" name="cmt_ID" /> <input
										type="hidden" value="<%=fb1.getF_id()%>" name="f_id" />
									<%
										String favformname = "remfavform" + i;
									%>
									<a onclick="$('form[name=<%=favformname%>]').submit();"><img
										src="images/pinned.png" height="30" width="40" class="pin1">
										<img src="images/pinned.png" height="28" width="40"
										class="pinned1" style="display: none;"></a>
								</form>
							</td>
							<%
								} else {
							%>
							<td style="text-align: center;">

								<form action="FavForumSERVLET" name="favform<%=i%>"
									method="post">
									<input type="hidden" value="comment<%=i%>" name="cmt_ID" /> <input
										type="hidden" value="<%=fb1.getF_id()%>" name="f_id" />
									<%
										String favformname = "favform" + i;
									%>
									<a onclick="$('form[name=<%=favformname%>]').submit();"><img
										src="images/pin.png" height="20" width="30" class="pin1">
										<img src="images/pinned.png" height="28" width="40"
										class="pinned1" style="display: none;"></a>
								</form>
							</td>
							<%
								}
							%>
						</tr>
						<tr id="comment<%=i%>">
							<td colspan="7">
								<table width="100%" border="1">
									<tr>
										<td style="color: #EA8C2D;"><b>Description :</b></td>

										<td colspan="5"><%=fb1.getDesription()%></td>
										<td>
											<%
												if (lb.getM_id() == fb1.getCreator_id())
												;
											{
											%>
											<form name="dlt" action="ForumDeleteSERVLET" method="post">
												<input type="hidden" value="<%=fb1.getF_id()%>"
													name="f_id" />
												<%
													if (lb.getM_id() == fb1.getCreator_id()) {
												%>
												<center>
													<button id="btn" class="btnStyleDel" type="submit"
														name="delete-btn"></button>
												</center>
												<%
													}
												%>
											</form> <%
 	}
 %>
										</td>
									</tr>
									<%
										cmtArray = fb1.getCommentList();
									if (cmtArray != null) {
										int k = 0;
										for (CommentBEAN cb : cmtArray) {
									%>
									<tr>
										<td style="color: #660066;"><b><%=cb.getFname() + " " + cb.getLname() + ":"%></b><br />
											<br />Date :<%=fmt.format(cb.getCreated_DateTime())%><br />Time
											:<%=fmt1.format(cb.getCreated_DateTime())%></td>
										<td colspan="5">
											<table width="100%">
												<tr>
													<td colspan="5"><%=cb.getCmt_Data()%></td>
												</tr>
											</table>
										</td>
										<td style="width: 70px;">
											<%
												if (cb.isLiked()) {
											%>
											<center>
												<img src="images/rated.png"
													style="width: 26px; height: 26px;"><b
													Style="font-size: 30px; color: #F25C27;"><%="  " + cb.getRate()%></b>
											</center> <%
 	} else {
 %>
											<form action="LikeCommentSERVLET"
												name="likeform<%=i + "" + k%>" method="post">
												<input type="hidden" value="comment<%=i%>" name="cmt_ID" />
												<input type="hidden" value="<%=cb.getC_Id()%>" name="c_id" />
												<%
													String formname = "likeform" + i + "" + k;
												%>
												<center>
													<a onclick="$('form[name=<%=formname%>]').submit();"><img
														src="images/rate.png" id="like"
														style="width: 26px; height: 26px;" /><b
														Style="font-size: 30px; color: #F25C27;"><%="  " + cb.getRate()%></b></a>
												</center>
											</form> <%
 	}
 %> <br /> <%
 	if (cb.getCreator_Id() == lb.getM_id() || fb1.getCreator_id() == lb.getM_id()) {
 %>
											<form name="dlt" action="CommentDeleteSERVLET" method="post">
												<input type="hidden" value="<%=cb.getC_Id()%>" name="c_id" />
												<input type="hidden" value="comment<%=i%>" name="cmt_ID" />
												<center>
													<button id="btn" class="cmtbtnStyleDel" type="submit"
														name="cmt-delete-btn"></button>
												</center>
											</form> <%
 	}
 %>
										</td>
									</tr>

									<%
										k++;
									}
									}
									%>


									<tr>
										<td style="color: #EA8C2D;"><b>comment :</b></td>
										<td colspan="6">
											<table width="100%">
												<tr class="pending">
													<form action="CommentSERVLET" method="post"
														id="CommentForm<%=i%>">
														<td><textarea rows="3"
																style="resize: none; design: inline;"
																id="addcomment<%=i%>" name="addcomment" cols="100"></textarea><br />
															<label id="EmptyCmt<%=i%>">This Field is
																Required.</label></td>
														<td><input type="hidden" value="<%=fb1.getF_id()%>"
															name="f_Id" /> <input type="hidden"
															value="comment<%=i%>" name="cmt_ID" /> <input
															type="submit" class="btnStyle" id="post-btn<%=i%>"
															value="POST" /></td>
													</form>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<%
							i++;
						}
						%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<%
					int j;
				for (j = 0; j < i; j++) {
				%>

				<script>
				$(document).ready(function() {
					
					hideall();
					$("#posted-forum<%=j%>").click(function(){
						if($('#comment<%=j%>').is(':visible')){
							hideall();
						}else{
							hideall();
							$("#comment<%=j%>").toggle();
						}
					});
					
					$( "#CommentForm<%=j%>" ).submit(function( event ) {
						if(!$('#addcomment<%=j%>').val()){
							$('#EmptyCmt<%=j%>').show();
							return false;
						}
					});
				});
				
			</script>
				<%
					if (c_Id != null) {
					out.print("<script>$(document).ready(function() {$('#" + c_Id + "').show();}); </script>");
				}
				%>
				<%
					}
				%>
				<script>
      		function hideall(){
      			<%for (j = 0; j < i; j++) {%>
					$("#comment<%=j%>").hide();
					$("#EmptyCmt<%=j%>
					").hide();
				<%}%>
					}
				</script>
				<%
					
				%>

			</div>
			<jsp:include page="footer.jsp" />
		</div>
	</div>




	<!------------------------- Forum posts ends -------------------------->

</body>

</html>
