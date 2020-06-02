<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
#myprofile {
	background-color: #F25C27;
	color: #FFF;
}

#forum, #searchmem, #gallery, #privmsg, #makeapp, #reportuser, #mod_req,
	#user_req {
	background-color: #F5F1E5;
	color: #000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<%@ page import="com.alumni.beans.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<title>user profile</title>

<script src="css/jquery-latest.min.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>


<link href="css/profile1.css" rel="stylesheet" type="text/css" />
<style>
.content {
	margin-top: 240px;
	position: absolute;
	background-color: #F5F1E5;
}

.main {
	background-color: #F5F1E5;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<%
        String resultFlag=request.getParameter("flag");
        if(resultFlag!=null && !"".equals(resultFlag))
       {
       %>
		<%    if(resultFlag.equals("2"))
       {%>
		<table align="center">
			<tr>
				<th bgcolor="#211C19"><font color="#11DA00">Request
						sent!</font></th>
			</tr>
		</table>


		<% } if(resultFlag.equals("1")){     
    	%>
		<table align="center">
			<tr>
				<th bgcolor="#211C19"><font color="red">You have already
						sent request</font></th>
			</tr>
		</table>

		<% } if(resultFlag.equals("21")){
    	 %><table align="center">
			<tr>
				<th bgcolor="#211C19"><font color="#11DA00">Profile
						Updated!</font></th>
			</tr>
		</table>
		<%
     }
       } %>

		<div class="main"
			style="border-top-right-radius: 50px; border-bottom-left-radius: 50px; margin-left: 10px; margin-right: 10px; margin-bottom: 20px; padding: 20px;">

			<form name="profile-action" action="EditProfileSERVLET" method="post">


				<table width="100%" height="100%" class="panel">
					<tr>
						<td colspan="2">
							<%-- <h1> <b>Username</b></h1>    --%> <% 
        	ProfileBEAN bean = (ProfileBEAN) request.getAttribute("Profilebean"); 
                
                    
                    int uid=bean.getMemberId();
                    String user=bean.getUserId(); 
                    String pwd=bean.getPassword(); 
                    String fname=bean.getFirstName();
                    String mname=bean.getMiddleName();
                    String lname=bean.getLastName();
                    
                    //  gen valse is only in one digit in data base thats why i used 
                    String gen=bean.getGender();
                   String gender="null";
                    if(gen.equals("m"))
                    {
                     	 gender="Male";
                    }
                    if(gen.equals("f"))
                    {
                    	gender="Female";
                    }
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String dat=sdf.format(bean.getDateAndBirth());
                   
                    String mobileno=bean.getMobileNumber();
                    String email=bean.getEmailId();
                    String enroll=bean.getEnrollmentNumber();
                    String add1=bean.getAddressLineOne();
                    String add2=bean.getAddressLineSecond();
                    String totexpyear=bean.getTotalExprianceYear();
                    String totexpmonth=bean.getTotalExprianceMonth();
                    String keyskills=bean.getKeySkills();
                    String picpath=bean.getPic();
                    String otherhobbies=bean.getOtherHobbies();
        %>
							<h1>
								<b><%=lname%> <%=fname%> <%=mname%></b>
							</h1>
							<button type="submit" class="btn" id="edit_btn">Edit</button> <%          String s=(String) request.getAttribute("flag");
       String s1=(String) request.getAttribute("acctype");
       
       if(!s.equals("2")&&!s1.equals("1")){
      %> <a href="SendRequestToBecomeMod">
								<button type="button" class="btn" id="mod_btn">Become
									moderator</button>
						</a> <%}  %>
						</td>
					</tr>
					<tr>
						<td height="10" colspan="2">
							<hr />
						</td>
					</tr>
					<tr>
						<td height="28">&nbsp;</td>
					</tr>
					<tr>
						<td width="50%" height="812"
							style="border-right: 0.5px groove #A0A0A4; padding-right: 25px; height: 500px;"><table
								width="100%" height="125%">
								<tbody>
									<tr>
										<td colspan="2">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2"><legend class="main-heading">Personal
												details :</legend></td>
									</tr>
									<tr>
										<td><span class="tm_image_reflection"><img
												src="<%=picpath %>" width="160" height="200" /></span><br /></td>
										<td>
											<table width="100%">
												<tr>
													<td><b> <label class="label">Username :</label>
													</b></td>
													<td><label class="value"><%=user %></label></td>
												</tr>
												<tr>
													<td><label class="label"><b> password:</b></label></td>
													<td><label class="value">************</label></td>
												</tr>

											</table>
											<hr />
										</td>
									</tr>
									<tr>
										<td><b> <label class="label">Full Name :</label>
										</b></td>
										<td>
											<%if(lname.equals(null)){%><label class="value"></label>
											<%}else{ %> <label class="value"><%=lname%></label>
											<%}%> <%if(fname.equals(null)){ %><label class="value"> </label>
											<%}else{ %> <label class="value"><%=fname%></label>
											<%}%> <%if(mname.equals(null)){%><label class="value"></label>
											<%}else{ %> <label class="value"><%=mname%></label>
											<%} %> <br />
										</td>
									</tr>
									<tr>
										<td><b> <label class="label">Gender :</label>
										</b></td>
										<td><label class="value"><%=gender%></label></td>
									</tr>
									<tr>
										<td><b> <label class="label">Date Of Birth :</label>
										</b></td>
										<td><label class="value"><%=dat %></label></td>
									</tr>
									<tr>
										<td><b> <label class="label"> Mobile No :</label>
										</b></td>
										<td>
											<%if(mobileno.equals(null)){ %><label class="value"></label>
											<%}else{ %> <label class="value"><%=mobileno%></label>
											<%} %>
										</td>
									</tr>
									<tr>
										<td><b> <label class="label"> Email Id :</label>
										</b></td>
										<td><label class="value"><%=email%></label></td>
									</tr>
									<tr>
										<td><b> <label class="label"> Hobbies :</label>
										</b></td>
										<td>
											<%
              	
             List<MemhobbiesBEAN> hbean=bean.getMemhobbieshobbies();
                if(hbean==null){
              	%> <%="no hobbies"%>
											<%
 	}
                 else{
                 	for(MemhobbiesBEAN hobbies:hbean){
                 		String hobbiesname = hobbies.getHobbieesname();
 %> <label><%=hobbiesname %>, <%
                	}
                }
                     %> <%=otherhobbies%></label>

										</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td><b> <label class="label">Address :</label>
										</b> <br />
										<br />
										<br />
										<br />
										<br /></td>
										<td><hr />
											<table>
												<tr>
													<td><b> <label class="label">Address line
																1 :</label>
													</b></td>
													<td>
														<%if(add1.equals(null)){ %><label class="value"></label>
														<%}else{ %> <label class="value"><%=add1%></label>
														<%} %>
													</td>
												</tr>
												<tr>
													<td><b> <label class="label">Address line
																2:</label>
													</b></td>
													<td>
														<%if(add2.equals(null)){ %><label class="value"></label>
														<%}else{ %> <label class="value"><%=add2%></label>
														<%} %>

													</td>
												</tr>
												<tr>
													<td>
														<%-- <b>
             <label class="label">City :</label>
           </b></td>
           <td><label class="value">city_name</label>
                     --%>
													</td>
												</tr>
												<tr>
													<td>
														<%-- <b>
             <label class="label">Country :</label>
           </b></td>
           <td><label class="value">country_name</label>
           </td>  --%>
												</tr>
											</table> <br /> <br /> <br /> <br /> <br /></td>
									</tr>
								</tbody>
							</table></td>
						<td style="padding-left: 25px;" width="50%">
							<table width="100%" id="add_job_btn">
								<tr>
									<td colspan="2"><legend class="main-heading">Education
											Details :</legend></td>
								</tr>
								<%
       	EducationBEAN education=bean.getEducation();
                   if(education==null){
                	  
       %>
								<tr>
									<td><b><label class="label">Highest Education
												:</label></b></td>
									<td>
										<table width="100%">

											<tr>
												<td><b><label class="label">Degree :</label></b></td>
												<td><label class="value">B.E</label></td>
											</tr>

											<tr>
												<td><b><label class="label">Branch :</label></b></td>
												<td><label class="value">Information Techology</label></td>
											</tr>

											<tr>
												<td><b><label class="label">Passout Year :</label></b></td>
												<td><label class="value">2002</label></td>
											</tr>

											<tr>
												<td><b><label class="label">College/Institute
															:</label></b></td>
												<td><label class="value">This college</label></td>
											</tr>
										</table>
										<hr />
									</td>
								</tr>
								<% 
            }
            else{
            		String educationbranch = education.getBranch();
            		String educationdegree=education.getDegree();
            	 	String educationclgname=education.getCollegeName();
            	 	String educationpassoutyear=education.getPassOutYear();
            	
            	
		%>
								<tr>
									<td><b><label class="label">Highest Education
												:</label></b></td>
									<td>
										<table width="100%">

											<tr>
												<td><b><label class="label">Degree :</label></b></td>
												<td><label class="value"><%=educationdegree %></label></td>
											</tr>

											<tr>
												<td><b><label class="label">Branch :</label></b></td>
												<td><label class="value"><%=educationbranch %></label></td>
											</tr>

											<tr>
												<td><b><label class="label">Passout Year :</label></b></td>
												<td><label class="value"><%=educationpassoutyear %></label></td>
											</tr>

											<tr>
												<td><b><label class="label">College/Institute
															:</label></b></td>
												<td><label class="value"><%=educationclgname %>
												</label></td>
											</tr>

										</table>
										<hr />
									</td>
								</tr>
								<%
    } 	
   
            %>
								<tr>
									<td><b><label class="label">Other Education :</label></b>
									</td>
									<td>
										<% 
		  OtherEducationBean othereducation=bean.getOthereducation();
          if(othereducation==null){
          	%>
										<table width="100%">
											<tr>
												<td><b><label class="label">Degree :</label></b></td>
												<td><label class="value"></label></td>
											</tr>
											<tr>
												<td><b><label class="label">Branch(cource
															Name) :</label></b>
													<td><label class="value"> <br /></td>
												</label></td>

											</tr>
											<tr>
												<td><b><label class="label">Passout Year :</label></b>
												</td>
												<td><label class="value"></label></td>
											</tr>
											<tr>
												<td><b><label class="label">College/Institute
															:</label></b></td>
												<td><label class="value"></label></td>
											</tr>
										</table> <% 
          }
          else{
          		String othereducationcourse = othereducation.getCourse();
          		String othereducationdegree=othereducation.getDegree();
          	 	String othereducationclgname=othereducation.getCollegeName();
          	 	String othereducationpassoutyear=othereducation.getPassoutYear();
          	
		   	%>
										<table width="100%">
											<tr>
												<td><b><label class="label">Degree :</label></b></td>
												<td><label class="value"><%=othereducationdegree %></label>

												</td>
											</tr>
											<tr>
												<td><b><label class="label">Branch(cource
															Name) :</label></b>
													<td><label class="value"><%=othereducationcourse %>
															<br /></td>
												</label></td>

											</tr>
											<tr>
												<td><b><label class="label">Passout Year :</label></b>
												</td>
												<td><label class="value"><%=othereducationpassoutyear %></label>

												</td>
											</tr>
											<tr>
												<td><b><label class="label">College/Institute
															:</label></b></td>
												<td><label class="value"><%=othereducationclgname %></label>

												</td>
											</tr>
										</table> <%} %>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<hr /> <legend class="main-heading">Professional
											Details :</legend>
									</td>
								</tr>
								<tr>
									<td><b><label class="label">Total Experience:</label></b>
									</td>
									<td><label class="value">
											<%if(totexpyear.equals(null)){ %><span class="year">-</span>
											<%}else{ %><span class="year"><%=totexpyear %></span>
											<%} %> Year <%if(totexpmonth.equals(null)){ %><span class="month"></span>
											<%}else{ %><span class="month>"><%=totexpmonth %></span>
											<%} %> Month
									</label></td>
								</tr>
								<tr>
									<td><b><label class="label">Key Skill :</label></b></td>
									<td>
										<%if(keyskills.equals(null)){ %><label class="value">no
											keyskills</label>
										<%}else{ %><label class="value"><%=keyskills %></label>
										<%} %>

									</td>
								</tr>

								<tr>
									<td height="204"><b><label class="label">Job
												Detail :</label></b></td>
									<td>
										<% 
      List<JobBean> job = bean.getJob();

       	if(job==null){
       	%>
										<hr />
										<table width="100%">
											<tr>
												<td><b><label class="label">Job Type :</label></b></td>
												<td><label class="value">no Job data</label></td>
											</tr>
											<tr>
												<td><label class="label">Start :</label></td>
												<td><label class="value">- / -</label></td>
											</tr>
											<tr>
												<td><label class="label">End :</label></td>
												<td><label class="value">- / -</label></td>
											</tr>
											<tr>
												<td><b> <label class="label">Industry Name:</label>
												</b></td>
												<td><label class="value">-</label></td>
											</tr>
											<tr>
												<td><b> <label class="label">Functional
															Area :</label>
												</b></td>
												<td><label class="value">-</label></td>
											</tr>
										</table> <%
       	}
       	else
       	{
       		for(JobBean jbean:job){
       			String jobtype=jbean.getJobType();
       			String startmonth=jbean.getStartedMonth();
       			String startyear=jbean.getStartedYear();
       			String endmonth=jbean.getEndedMonth();
       			String endyear=jbean.getEndedYear();
       			String industryname=jbean.getIndustryName();
       			String functionarea=jbean.getFuncationArea();
       	
       	%>

										<hr />
										<table width="100%">
											<tr>
												<td><b><label class="label">Job Type :</label></b></td>
												<td><label class="value"><%=jobtype %></label></td>
											</tr>
											<tr>
												<td><label class="label">Start :</label></td>
												<td><label class="value"><%=startmonth %>/ <%=startyear %></label>

												</td>
											</tr>
											<tr>
												<td><label class="label">End :</label></td>
												<td><label class="value"><%=endmonth%>/ <%=endyear%></label>

												</td>
											</tr>
											<tr>
												<td><b> <label class="label">Industry Name:</label>
												</b></td>
												<td><label class="value"><%=industryname %></label></td>
											</tr>
											<tr>
												<td><b> <label class="label">Functional
															Area :</label>
												</b></td>
												<td><label class="value"><%=functionarea %></label></td>
											</tr>
										</table> <%
       		}
		}%>
									</td>
								</tr>
							</table>

						</td>
					</tr>
					<tr>
						<td colspan="2"><hr />
							<center></center></td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
