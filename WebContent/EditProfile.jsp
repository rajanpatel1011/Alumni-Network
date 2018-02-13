<%@page import="com.mysql.jdbc.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <style>
#myprofile {
background-color: #F25C27;
color: #FFF;
}

#forum,#searchmem,#gallery,#privmsg,#makeapp,#reportuser,#mod_req,#user_req{
background-color: #F5F1E5;
color: #000;
}
</style>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
  <%@ page import="com.alumni.beans.*" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.text.SimpleDateFormat;" %>
  
   <title>Edit Profile</title>
  
   <script src="css/jquery-latest.min.js"></script>
   <script src="js/jquery-1.9.1.min.js"></script>
   <script src="js/jquery.validate.js"></script>
   <script src="js/editprofile.js"></script>
 	
   <link href="css/profile1.css" rel="stylesheet" type="text/css" />
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
 
  <%
        String resultFlag=request.getParameter("resultFlag");
        if(resultFlag!=null && !"".equals(resultFlag))
       {
       %>
          <%    if(resultFlag.equals("3"))
       {%><table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Unchecked!!</font>  </th></tr></table>  
       			 <%} %> 
        <%if(resultFlag.equals("4")) {%>
        	<table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Enter Other hobbies !</font>  </th></tr></table> 
	<%}%>
       
      <%  if(resultFlag.equals("5")){     
    	%><table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Enter First Name!</font>  </th></tr></table>    
    	
     <% } if(resultFlag.equals("6")){
    	 %><table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Enter Middle Name!</font></th></tr></table>
   <% }  if(resultFlag.equals("7"))
     {%><table align="center"> <tr> <th bgcolor="#211C19"><font color="red">Enter Last Name!</font>  </th></tr></table>  
		 <%} %>
		 <%if(resultFlag.equals("8")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Select Gender!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("9")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Mobile Number!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("10")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Email Address!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("11")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Address Line one!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("12")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Address line Second!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("13")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Select Degree!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("14")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Highest Education college Name!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("15")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Course Name!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("16")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter PassoutYear !</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("17")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter The Other Institude Name!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("18")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Job Year!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("19")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Joy Month!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("20")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Key Skills!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("22")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Internal Error!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("23")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">File Not Found!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("24")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Image must be jpg or jpeg or png file only!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("25")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter the Job Type!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("26")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Industry Name!</font></th></tr></table>
		  <%} %>
		  <%if(resultFlag.equals("27")){ %>
		  <table align="center"><tr><th bgcolor="#211C19"><font color="red">Enter Funcational Area!</font></th></tr></table>
		  <%} %>
      <% } %>
  <div class="main" style="border-top-right-radius: 50px;border-bottom-left-radius: 50px;margin-left: 10px;margin-right: 10px;margin-bottom: 20px;padding: 20px;" >
      <form name="profile-action" id=fom action="UpdateProfileSERVLET" method="post" enctype="multipart/form-data" >
	    <table width="100%" height="100%" class="panel">
       	  <tr>              
    	    <td colspan="2">
            <%-- <h1> <b>Username</b></h1>    --%>
            <%
            	ProfileBEAN bean = (ProfileBEAN)request.getAttribute("EditProfilebean");
                      
             			int uid=bean.getMemberId();
             			
                        String user=bean.getUserId(); 
                        String pwd=bean.getPassword(); 
                        String fname=bean.getFirstName();
                        String mname=bean.getMiddleName();
                        String lname=bean.getLastName();
                        
                        //  gen valse is only in one digit in data base thats why i used 
                        String gen=bean.getGender();
                      
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String dat=sdf.format(bean.getDateAndBirth());
                        String mobileno=bean.getMobileNumber();
                        String email=bean.getEmailId();
                        String enroll=bean.getEnrollmentNumber();
                        String add1=bean.getAddressLineOne();
                        String add2=bean.getAddressLineSecond();
                        String totexpmont=bean.getTotalExprianceMonth();
                        String totexpyear=bean.getTotalExprianceYear();
                        String keyskills=bean.getKeySkills();
                        String otherhobbies=bean.getOtherHobbies();
                        String picpath=bean.getPic(); 
            %>
            <h1><b><%=lname%> <%=fname%> <%=mname%></b></h1>
             <a href="profileSERVLET"> <input type="button"  name="back" class="btn" id="back" value="Back" /></a>
            </td>
          </tr>
          <tr>                	
    	    <td height="10" colspan="2">
              <hr />
            </td>
          </tr>
          <tr> <td height="28">&nbsp;</td></tr>
          <tr>
            <td width="50%" height="812" style="border-right:0.5px groove #A0A0A4;padding-right:25px;height:500px;"><table width="96%" height="114%">
              <tbody>
                <tr>
                  <td colspan="2">&nbsp;</td>
              	</tr>
                <tr>
                  <td colspan="2"><legend class="main-heading">Personal details :</legend></td>
              	</tr>
                <tr>
                <% LoginBEAN lb = (LoginBEAN)session.getAttribute("loginBEAN");
                	lb.setPic(picpath);
                %>
                  <td><span class="tm_image_reflection" ><img src="<%=picpath %>" width="160" height="200"/></span><br /><input type="file" value="pic" name="profilepic"></td>
                  <td>
               <table width="100%">
                 <tr>
                   <td>
                     <b> 	
                       <label class="label" >Username :</label>
              	     </b>
              	   </td>
                 <td>  
                   <input type="text"  value="<%=user %>"  name="username" disabled/></td>
                 </tr>
                 
                   <tr id=temp>
                   <td><label class="label" ><b></b></label></td>
    	           <td>
                     <button  class="btn" type="button"  id="edit_btn" >Change Password</button>
                     
                     
                   </td>
                 </tr>
                 
                 
                  <tr class="edit">
                   <td><label class="label" ><b>New password:</b></label></td>
    	           <td>
                     <input type="password"  id=npwd name="oldpwd" />
                      <div id="emptynpwd" class="bubble">
                         <span   style="color:red;">
                           *This field is required.
                    </span></div>
                    
                   </td>
                 </tr>
                  
                  
                   <tr >
                   <td><b>
                     
              	   </b></td>
                   <td>
                     </td>
                     <td>
          			</td>
						
                 </tr>
                  
                 <tr class="edit">
                   <td><b>
                     <label class="label"> Confirm Password :</label>
              	   </b></td>
                   <td>
                     <input type="password" id=cpwd name="newpwd"/>
                       <div id="emptycpwd" class="bubble">
                         <span   style="color:red;">
                           *This field is required.
                    </span></div>
                    <div id="Notmatchpwd" class="bubble">
                         <span   style="color:red;">
                           *Password not match.
                    </span></div>
                     </td>
                     <td>
                     <%
        String resultFlag1=request.getParameter("resultFlag");
        if(resultFlag1!=null && !"".equals(resultFlag1))
       {  
 							if(resultFlag1.equals("100")){
								out.println("<tr><td id=passwordempty colspan='2'><font color=red>Password empty </font></td></tr>");
							} else if(resultFlag1.equals("2")) {
								out.println("<tr><td id=passwordnotmatch colspan='2'><font color=red>Password not match</font></td></tr>");
							} 
       } %>
						</td>
						
                 </tr>  
               </table>
               <hr />
             </td>
           </tr>
           <tr>
             <td>
               <b>
                 <label class="label">Full Name :</label>
               </b>
             </td>
             <td>
             <%if(lname.equals(null)){ %><input style="display:inline;width:100px;" type="text"  name="lname"/><%}else{ %>
               <input style="display:inline;width:100px;" type="text"  id=lname value="<%=lname%>" name="lname"/><%} %>
               <%if(fname.equals(null)){ %><input style="display:inline;width:100px;" type="text"  name="fname"/><%}else{ %>
               <input style="display:inline;width:100px;" type="text"  id=fname value="<%=fname %>" name="fname"/><%} %>
               <%if(mname.equals(null)){ %><input type="text" style="display:inline;width:100px;"  name="mname"/><%}else{ %>
               <input type="text" style="display:inline;width:100px;" id=mname  value="<%=mname%>" name="mname"/><%} %>
               <div id="emptylname" class="bubble">
                         <span   style="color:red;">
                           *Last Name  is required
                    </span></div>
                    <div id="Caplname" class="bubble">
                         <span   style="color:red;">
                           *First letter must be Captial in Last Name. 
                    </span></div>
                    <div id="nolname" class="bubble">
                         <span   style="color:red;">
                           *Numbers Not Allowed in last name.
                    </span></div>
                    
                    <div id="emptymname" class="bubble">
                         <span   style="color:red;">
                           *Middle name is required
                    </span></div>
                    <div id="Capmname" class="bubble">
                         <span   style="color:red;">
                           *First letter must be  Captial in Middle Name. 
                    </span></div>
                    <div id="nomname" class="bubble">
                         <span   style="color:red;">
                          *Numbers Not Allowed in Middle Name.
                    </span></div>
                    
                    <div id="emptyfname" class="bubble">
                         <span   style="color:red;">
                           *First nam is required.
                    </span></div>
                    <div id="Capfname" class="bubble">
                         <span   style="color:red;">
                           *First letter must be  Captial in First name. 
                    </span></div>
                    <div id="nofname" class="bubble">
                         <span   style="color:red;">
                          *Numbers Not Allowed in First name. 
                    </span></div>
                    
             <br />
             </td>
           </tr>
         <tr>
           <td><b>
             <label class="label" >Gender :</label>
           </b></td>
           <td>
           <%if(gen.equals("m"))
           { %>
             <input type="radio" name="gender"   id="Male" value="Male" checked />
             <%
             }else{ %>
             <span > Male </span>
             <input type="radio" name="gender"   id="Male" value="Male" />
             <span  >Female</span>
             <%} %>
             <%if(gen.equals("f"))
            	 {%>
            	  <input type="radio" name="gender"   id="Female" value="Female" checked />
             <%
             }else{ %>
             <span > Male </span>
             <input type="radio" name="gender"   id="Female" value="Female" />
             <span  >Female</span>
             <%} %>
           </td>
   	     </tr>
     	 <tr>
           <td><b>
             <label class="label" >Date Of Birth :</label>
           <td>
             <input type="date" name="dob" id="txtDate"  value="<%=dat%>" />
           </td>
         </tr>
         <tr>
   	       <td><b>
             <label class="label"> Mobile No :</label>
           </b></td>
           <td>
             <input type="text"  id="mobno" value="<%= mobileno%>" name="mobno"/>
             <div id="emptymobno" class="bubble">
                         <span   style="color:red;">
                           *Moblie number is required.
                    </span></div>
                    <div id="nomobno" class="bubble">
                         <span   style="color:red;">
                           *Mobile number must be in number digit.
                    </span></div>
                     <div id="digitmobno" class="bubble">
                         <span   style="color:red;">
                           *Mobile number must be is only 10 digit.
                    </span></div>
             </td>
         </tr>
         <tr>
           <td><b>
             <label class="label"> Email Id :</label>
           </b></td>
           <td>
             <input type="text" value="<%=email%>"  id=email name="em" />
             <div id="emptyemail" class="bubble">
                         <span   style="color:red;">
                           *Email is required.
                    </span></div>
                    <div id="properemail" class="bubble">
                         <span   style="color:red;">
                           *Email must be in proper format.
                    </span></div></td>
         </tr>
         <tr>
           <td><b>
             <label class="label"> Hobbies :</label>
           </b></td>
             <td>
             <%	
             List<MemhobbiesBEAN> hbean=bean.getMemhobbieshobbies();
          	 List<MemhobbiesBEAN> allOfHobbiesrequest=(List<MemhobbiesBEAN>)request.getAttribute("hobbieslist");
           if(hbean==null){
        	   %><% int j=1;
        	   for(MemhobbiesBEAN allhobbies:allOfHobbiesrequest){
        		   int hId=allhobbies.getHid();
        		   String name=allhobbies.getHobbieesname();
        		   %>		   
        		    <input type="checkbox" name="hobbiesnameid<%=j%>" value="<%=hId%>" ><%=name %></input>
   					 
   				<% j++;
   				%>
       	 			<input type="hidden" name="hobbiesallid" value="<%=name%>"/>
        	  <% }%><%
           }
           else{
        	  int j=1;
        	   for(MemhobbiesBEAN allhobbies:allOfHobbiesrequest){
        		   int hId=allhobbies.getHid();
        		   String name=allhobbies.getHobbieesname();
        		   %>		   
        		    <input type="checkbox" name="hobbiesnameid<%=j%>" value="<%=hId%>" <%if(hbean.contains(allhobbies)){ %> checked="checked" <%}%>><%=name %></input>
   					 
   				<% j++;
   				%>
       	 			<input type="hidden" name="hobbiesallid" value="<%=name%>"/>
        	  <% }
        	   }   %>	 
           </td>
  	     </tr>
         <tr>
           <td></td>
           <td><input type="checkbox" name="checkotherhobbies" id=ock checked="checked" />
             <label >Others : </label>
             <%if(otherhobbies.equals(null)){ %><input type="text"  name="others_hobbies" ></input><%}else{ %>
             <input type="text"  id=hob name="others_hobbies" value="<%=otherhobbies %>" /><%} %>
             <div id="notcheck" class="bubble">
                         <span   style="color:red;">
                           *Checkbox must be checked. 
                    </span></div>
                    <div id="emptyohob" class="bubble">
                         <span   style="color:red;">
                           *Other hobbie is reqquired. 
                    </span></div>
             
           </td>
         </tr>
         <tr>
           <td height="226"><b>
             <label class="label">Address :</label>
             </b> <br /><br /><br /><br /><br />
           </td>
       	 <td><hr />
       <table>
         <tr>
           <td><b>
             <label class="label" >Address line 1 :</label>
           </b></td>
           <td>
           <%if(add1.equals(null)){ %><textarea rows="2" cols="3" name="add1" ></textarea><%}else{ %>
           <textarea rows="2" cols="5" name="add1" id=add1 ><%=add1%></textarea><%} %>
             <div id="emptyadd1" class="bubble">
                         <span   style="color:red;">
                           *Address line is required. 
                    </span></div>
             </td>
         </tr>
         <tr>
           <td><b>
             <label class="label">Address line 2:</label>
           </b></td>
           <td>
           <%if(add2.equals(null)){ %><textarea rows="2" cols="3" name="add2" ></textarea><%}else{ %>
             <textarea rows="2" cols="5" name="add2" id=add2><%=add2%></textarea><%} %>
             <div id="emptyadd2" class="bubble">
                         <span   style="color:red;">
                           *Address line is required. 
                    </span></div>
           </td>
         </tr>
        
         <tr>
           <td></td>
           <td>
            </td> 
         </tr>
         <tr>
           <td></td>
           <td>
            </td>
         </tr>
       </table>
       <br />
       <br />
       <br />
       <br />
       <br />
       </td>
     </tr>
    </tbody>
   </table>
   
  </td>
     <td style="padding-left:25px;" width="50%">
    <table width="100%" id="add_job_btn">
  
           <%
             	EducationBEAN education=bean.getEducation();
                         if(education==null){
             %> <%="null"%><%
 	}
             else{ 	            		
            	
              
             		String educationbranch = education.getBranch();
             		String educationdegree=education.getDegree();
             		int educationdegegreeId=education.getDegreeId();
             	 	String educationclgname=education.getCollegeName();
             	 	String educationpassoutyear=education.getPassOutYear();
             	 	int educationId=education.getEducationId();
 %>               
      <tr>
        <td colspan="2"><legend class="main-heading">Education Detais :</legend>
        </td>
      </tr>  
                       
      <tr>
        <td><b><label class="label">Highest Education :</label></b>
		</td>
		<td>
          <table width="100%">
	        <tr>
              <td><b><label class="label">Degree :</label></b>
              </td>
		      <td>
		   
		        <select name="degree"  > <%--all degrees  --%>
	          <%
	          	List<EducationBEAN> listofdegree = (List<EducationBEAN>)request.getAttribute("degreelist");
	          if(listofdegree ==null){
	          %><%="null"%><%
	           	}else{  	
	          	        	 for(EducationBEAN degree1:listofdegree){
	          	        		 int alldegreeId = degree1.getDegreeId();
	          		    		  String alldegree = degree1.getDegree();
	          %>  <option value=<%=alldegreeId %> ><%=alldegree%> </option><%
  	 	 	 	}
  	         }
  %>
		          <option selected="selected" value="<%=educationdegegreeId%>"><%=educationdegree%></option>
		        </select>
		       
   <%-- <input type="text"   value="B.E/B.Tech" />  --%>	
	          </td>
		    </tr>
        	<tr>
              <td><b><label class="label">Branch :</label></b>
              </td>
              <td>
                	<%--all branchs  --%>
                  <input type="text"  value="<%=educationbranch%>" disabled/>
                
                
<%-- 	<input type="text"   value="I.T" /> --%> 
		      </td>
        	</tr>
            <tr>
              <td><b><label class="label">Passout Year :</label></b>
		      </td>
        	  <td>
                 <input type="hidden" name="educationId" value="<%=educationId%>"></input>
                <input type="text" value="<%=educationpassoutyear%>" disabled />
                                                 
		      </td>
		    </tr>
            <tr>
              <td><b><label class="label">College/Institute :</label></b>
		      </td>
              <td>
                <input type="text" name="colname"  id=highclg value="<%=educationclgname %> "/>
                <div id="emptyhighclg" class="bubble">
                         <span   style="color:red;">
                           *College name is required. 
                    </span></div>
		      </td>
		    </tr>
		  </table>
          <hr />
        </td>
      </tr>
      <%} %>
        <tr>
		  <td><b><label class="label">Other Education :</label></b>
		  </td>
		  <td><%
		  OtherEducationBean othereducation=bean.getOthereducation();
		  if(othereducation==null){
          	%> <%="null" %><% 
          }
          else{ 	            		
         	
            	int othereducationId=othereducation.getOtherEducationId();
          		String othereducationcourse = othereducation.getCourse();
          		String othereducationdegree=othereducation.getDegree();
          	 	String othereducationclgname=othereducation.getCollegeName();
          	 	String othereducationpassoutyear=othereducation.getPassoutYear();
          	 	
          	 	
          	
		  %>
            <table width="100%">
	          <tr>
                <td><b><label class="label">Degree :</label></b>
                </td>
		        <td>
		        <input type="hidden" name="othereducationId" value="<%=othereducationId%>"></input>
                  <input type="text" name="certi_cource"   value="<%=othereducationdegree%>" disabled />
		        
                         
		        </td>
		      </tr>
           <tr>
             <td><b><label class="label">Branch(cource Name) :</label></b></td>
               <td>
			     <input type="text" name=branch_name  id=ocource value="<%=othereducationcourse %>" />
			     <div id="emptycource" class="bubble">
                         <span   style="color:red;">
                           *Cource name is required. 
                    </span></div>
		       </td>
        	</tr>
            <tr>
              <td><b><label class="label">Passout Year :</label></b>
		      </td>
              <td>
                <input type="text" name=pas_year  id=oyear value="<%=othereducationpassoutyear %>" />
                <div id="emptyoyear" class="bubble">
                     <span   style="color:red;">
                           *Year is required. 
                    </span></div>
                    <div id="nooyear" class="bubble">
                         <span   style="color:red;">
                           *Year must be in Number form. 
                    </span></div>
		      </td>
		    </tr>
            <tr>
              <td><b><label class="label">College/Institute :</label></b>
		      </td>
              <td>
                <input type="text" name=col_name  id=oclg value="<%=othereducationclgname %>" />
                <div id="emptyoclg" class="bubble">
                         <span   style="color:red;">
                           *College name is required. 
                    </span></div>
		      </td>
		    </tr>
	      </table>
	      <%} %>
        </td>
	  </tr>  
      <tr>
	    <td colspan="2">
        <hr />
         
          <legend class="main-heading">Professional Detais :</legend>
    	</td>
	  </tr>
      <tr>
        <td><b><label class="label">Total Experience:</label></b>
        </td>
        <td>
        <%if(totexpyear.equals(null)){%><input  type="text" name=jyear style="width:50px;"  /><%}else{ %>
          <input type="text" name=jyear style="width:50px;"  id=jyear value="<%=totexpyear %>" /><%} %>
          <%if(totexpmont.equals(null)){ %><input type="text" name=jmonth style="width:50px;"/><%}else{ %>
		  <input type="text" name=jmonth style="width:50px;"  id=jmonth  value="<%=totexpmont %>" /><%} %>
		  
		   <div id="emptyjyear" class="bubble">
                         <span   style="color:red;">
                           *Year is required. 
                    </span></div>
                    <div id="nojyear" class="bubble">
                         <span   style="color:red;">
                           *Year must be in number. 
                    </span></div>
                     <div id="emptyjmonth" class="bubble">
                         <span   style="color:red;">
                           *Month is required. 
                    </span></div>
                    <div id=nojmonth class="bubble">
                         <span   style="color:red;">
                           *Month must be in number. 
                    </span></div>
		</td>
      </tr>
      <tr>
 		<td><b><label class="label">Key Skill :</label></b></td>
        <td>
          <%if(keyskills.equals(null)){ %><input type="text" name=key_skill /><%}else{ %>
          <input type="text" name=key_skill id=keys value="<%=keyskills %>" /><%} %>
           <div id="emptykeys" class="bubble">
                         <span   style="color:red;">
                           *Key Skill is required. 
                    </span></div>
        </td>
      </tr>
      <tr>
		<td height="204"><b><label class="label">Job Detail :</label></b>
		</td>
	    <td>
       
        
        <% 
        
     //   String addjob1=(String)request.getAttribute("addjob");
    //    int addjobint=0; 	
    //    addjobint=Integer.parseInt("addjob1");
         	%>
           <% 
      List<JobBean> job = bean.getJob();

       	if(job==null){
       	%> <%="null" %> 	<%
       	}
       	else
       	{
       		int i=1;
       		for(JobBean jbean:job){
       			String jobtype=jbean.getJobType();
       			String startmonth=jbean.getStartedMonth();
       			String startyear=jbean.getStartedYear();
       			String endmonth=jbean.getEndedMonth();
       			String endyear=jbean.getEndedYear();
       			String industryname=jbean.getIndustryName();
       			String functionarea=jbean.getFuncationArea();
       			int prof_Id=jbean.getProId();
       			String profe=Integer.toString(prof_Id);
       		 	
       	
       	%>
       	<input type="hidden" name="profeId<%=i%>" value="<%=profe%>"/> 
       	 <hr />
          <table width="100%">
	        <tr>
              <td><b><label class="label">Job Type :</label></b>
              </td>
		      <td>
                <input type="text" name="job_type<%=i%>"  id=jobtype value="<%=jobtype %>" />
                <div id="emptyjobtype" class="bubble">
                         <span   style="color:red;">
                           *Job Type is required. 
                    </span></div>
		      </td>
		    </tr>
        	<tr>
              <td><label class="label">Start :</label></td>
              <td>
                <select name="job_st_mon<%=i %>"  > 
                  <option>Jan</option>
                  <option>Feb</option>   		                                    
		          <option>Mar</option>
		          <option>Ape</option>
		          <option>May</option>
                  <option>Jun</option>
                  <option>Jul</option>
                  <option>Aug</option>
                  <option>Sep</option>
                  <option>Oct</option>
                  <option>Nov</option>
                  <option>Dec</option>
		          <option selected="selected"><%=startmonth %></option></select>
                <select name="job_st_yer<%=i %>"  > 
                  <option>2012</option>   		                                    
		          <option>2011</option>
		          <option>2010</option>
		          <option>2009</option>
                  <option>2008</option>
                  <option>2007</option>
                  <option>2006</option>
                  <option>2005</option>
                  <option>2004</option>
                  <option selected="selected"><%=startyear %></option>
                </select>
              </td>
            </tr>
            <tr>
              <td ><label class="label">End :</label></td>
              <td>
                <select name="job_ed_month<%=i%>"  > 
                  <option>Jan</option>
                  <option>Feb</option>   		                                    
		          <option>Mar</option>
		          <option>Ape</option>
		          <option>May</option>
                  <option>Jun</option>
                  <option>Jul</option>
                  <option>Aug</option>
                  <option>Sep</option>
                  <option>Oct</option>
                  <option>Nov</option>
                  <option>Dec</option>
		          <option selected="selected"><%=endmonth %></option></select>
                <select name="job_ed_yer<%=i %>"  > 
                  <option>2012</option>   		                                    
		          <option>2011</option>
		          <option>2010</option>
		          <option>2009</option>
                  <option>2008</option>
                  <option>2007</option>
                  <option>2006</option>
                  <option>2005</option>
                  <option>2004</option>
                  <option selected="selected"><%=endyear %></option>
                </select>
              </td>
            </tr>
            <tr>
            <td><b>
              <label class="label">Industry Name:</label>
            </b></td>
        	<td>
              <input type="text" name="industry_name<%=i %>"   id=indu value="<%=industryname %>" />
              <div id="emptyindu" class="bubble">
                         <span   style="color:red;">
                           *Industry name is required. 
                    </span></div>
            </td>
		  </tr>
          <tr>
            <td><b>
              <label class="label">Functional Area :</label>
            </b></td>
            <td>
              <input type="text" name="f_area<%=i %>"  id=farea value="<%=functionarea %>" />
              <div id="emptyfarea" class="bubble">
                         <span   style="color:red;">
                           *Funcation area is required. 
                    </span></div>
            </td>
          </tr>
		</table>
		<%  i++;
		}
       		}%>
      </td>
    </tr>
  </table> 
  <table border="0" cellpadding="0"  width="100%" id='providersFormElementsTable'> </table>
  <table width="188"  > 
    <tr>
      <td width="39" height="20">&nbsp;&nbsp;</td>
      <td width="83">
      
      <a href="AddJobInProfile" id="1" ><button type="button"  value="Add Job" class="btn" id="update_btn">Add Job</button></a>
      <% String resultFlag2=(String)request.getParameter("add");%>
    	<% if(!StringUtils.isEmptyOrWhitespaceOnly(resultFlag2)||!StringUtils.isNullOrEmpty(resultFlag2)){ %>
    	<%if(resultFlag2.equals("notadd")){ %>
    	<label>Not added job </label>
    	<%} %>
    	<%if(resultFlag2.equals("deladd")){ %>
    	<label>Not able to delete </label>
    	<%} %>
    	<%if(resultFlag2.equals("cantdel")){ %>
    	<label>can not delete </label>
    	<%} %>
      	<a href="DeleteJobBlockSERVLET?del=<%=resultFlag2%>"><button type="button" id="edit_btn" class="btn">Delete Job</button></a>
      <%}%>  
      </td>
    </tr>
   </table>
 </td>
</tr>
<tr>
  <td colspan="2"><hr />
	<center>

      <button class="btn" id="update_btn" type="submit" >Update</button>
    </center>
  </td>
</tr>
</table>                            
</form>
</div>
  <%--  <script src="js/bootstrap-typeahead.js"></script>   --%> 
<script src="js/jquery.js"></script>   
<script src="js/jquery.isotope.min.js"></script>     
	<script>
	 	$(function(){
	  
	  		 var $container = $('#container10');

	   		 	$container.isotope({
	    			 itemSelector : '.element'
	   			});
	  
	  
	  		 var $optionSets = $('#options .option-set'),
	       		$optionLinks = $optionSets.find('a');

	   		 	$optionLinks.click(function(){
	     	var $this = $(this);
	    // don't proceed if already selected
	     	if ( $this.hasClass('selected') ) {
	       		return false;
	     		}
	     	var $optionSet = $this.parents('.option-set');
	     	$optionSet.find('.selected').removeClass('selected');
	     	$this.addClass('selected');

	    // make option object dynamically, i.e. { filter: '.my-filter-class' }
	       var options = {},
	       key = $optionSet.attr('data-option-key'),
	       value = $this.attr('data-option-value');
	    // parse 'false' as false boolean
	       value = value === 'false' ? false : value;
	       options[ key ] = value;
	     	if ( key === 'layoutMode' && typeof changeLayoutMode === 'function' ) {
	      // changes in layout modes need extra logic
	       	changeLayoutMode( $this, options );
	        }
	     	else {
	      // otherwise, apply new options
	       $container.isotope( options );
	     	}
	    
	     return false;
	  });

	  
	});
</script>
	
  <%-- <script src="js/bootstrap-tab.js"></script>   --%>
<script type="text/javascript" src="js/tabs-content.js"></script>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>