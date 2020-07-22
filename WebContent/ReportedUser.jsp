<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<%@page import="com.alumni.beans.ReportedUserBEAN"%>
<%@page import="com.alumni.beans.ReporterUserBEAN"%>
<%@page import="com.alumni.bo.ReportedUserBO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.alumni.beans.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reported User</title>
<link rel="stylesheet" href="Mod.css" type="text/css" media="screen">

<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>


<style type="text/css">
th, td {
	text-align: center;
}

a {
	text-decoration: none;
	color: #000;
}

.content {
	margin-top: 240px;
	position: absolute;
	background-color: #F5F1E5;
}

.main {
	background-color: #F5F1E5;
}

#reportuser {
	background-color: #F25C27;
	color: #FFF;
}
</style>

</head>

<body>
	<jsp:include page="header.jsp" />

	<div class="content">
		<div class="main"
			style="border-top-right-radius: 50px; border-bottom-left-radius: 50px; margin-left: 10px; margin-right: 10px; margin-bottom: 20px;">
			<table width="100%">
				<tbody>
					<tr class="colname">
						<table width="100%" class="table table-hover">
							<tr style="color: #EA8C2D;">
								<th rowspan="2" style="text-align: center;">No.</th>
								<th style="text-align: center;">Reported</th>
								<th colspan="3" style="text-align: center;">Reported by
									<hr />
								</th>
								<th colspan="2" style="text-align: center;">Action
									<hr />
								</th>
							</tr>
							<%
								ReportedUserBEAN bean = new ReportedUserBEAN();
							%>
							<tr style="color: #EA8C2D;">
								<th style="text-align: center;">Username</th>
								<th style="text-align: center;">No.</th>
								<th style="text-align: center;">Reporter User</th>
								<th style="text-align: center;">Issue Message</th>
								<th style="text-align: center;">Warning</th>
								<th style="text-align: center;">Ban</th>

							</tr>
							<tr>
								<td colspan="7" style="text-align: center;">
									<hr />
								</td>
							</tr>
							<%
								String flag = request.getParameter("flag");

							if (!StringUtils.isEmpty(flag)) {
								if (flag == "1") {
							%>
							<tr align="center">
								<td colspan="7" style="text-align: center;"><b><%="No data!"%></b></td>
							</tr>
							<%
								} else if (flag == "2") {
							%>
							<tr align="center">
								<td colspan="7" style="text-align: center;"><b><%="No data!"%></b></td>
							</tr>
							<%
								}
							}

							else

							{

								LoginBEAN lb = (LoginBEAN) session.getAttribute("loginBEAN");

								List<ReportedUserBEAN> list = (List<ReportedUserBEAN>) request.getAttribute("list");
								if (list == null) {
							%>
							<tr>
								<td colspan="7" style="text-align: center;"><center>
										<b><%="No data!"%></b>
									</center></td>
							</tr>
							<%
								} else {
								int i = 1;
								for (ReportedUserBEAN rtdub1 : list) {
									List<ReporterUserBEAN> rtrub = rtdub1.getReporterUser();
									// ============get the list of Reported_Users================
							%>
							<tr>
								<td style="text-align: center;"><%=i%></td>
								<td style="text-align: center;"><a href=""><%=rtdub1.getReported_fname()%>&nbsp;<%=rtdub1.getReported_lname()%></a></td>
								<td colspan="3" style="text-align: center;">
									<table width="100%">
										<%
											List<ReporterUserBEAN> list1 = rtdub1.getReporterUser();
										int k = 1;
										for (ReporterUserBEAN rtrub1 : list1) {
										%>
										<tr>
											<td style="text-align: center;"><%=k%> <%
 	k++;
 %></td>
											<td style="text-align: center;"><a href="#"><%=rtrub1.getReporter_fname()%>
													&nbsp;<%=rtrub1.getReporter_lname()%></a></td>
											<td style="text-align: center;"><%=rtrub1.getIssu_msg()%></td>
										</tr>
										<%
											}
										%>
									</table>
								</td>
								<script>
						$(document).ready(function() {
							$('#warndiv<%=i%>').hide();
							$('.warnbutton<%=i%>').click(function(){
								if(!$('#warnTextArea<%=i%>').val()){
										$('#warndiv<%=i%>').fadeIn(300);
										$('#warndiv<%=i%>').fadeOut(800);
								}else{
										$('#warndiv<%=i%>
									')
																						.hide();
																			}
																		});
													});
								</script>
								<td style="text-align: center;">
									<form id="form1" name="form1" method="post"
										action="ReportedUserWarnSERVLET?user=<%=rtdub1.getReported_Id()%>">
										<textarea id="warnTextArea<%=i%>" style="resize: none"
											name="warning_msg" rows="5" cols="25" name="warn"></textarea>
										<div id="warndiv<%=i%>">This field is required!</div>
										<br />

									</form>
									<button id="post-btn" value="Send" tpye="submit"
										class="warnbutton<%=i%>">Send</button>
								</td>
								<td style="text-align: center;">
									<form id="form2" name="form2" method="post"
										action="ReportedUserBanSERVLET?user=<%=rtdub1.getReported_Id()%>">
										<button name="ban" type="button" id="ban" type="submit">Ban
											User</button>
									</form>
								</td>
							</tr>
							<%
								i++;
							}
							}
							} // This one is for IF ELSE !
							%>
							</tbody>
						</table>
					</tr>
				</tbody>
			</table>


		</div>
		<jsp:include page="footer.jsp" />
</body>
</html>