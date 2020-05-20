package com.alumni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.alumni.beans.EducationBEAN;
import com.alumni.beans.JobBean;
import com.alumni.beans.MemhobbiesBEAN;
import com.alumni.beans.OtherEducationBean;
import com.alumni.beans.ProfileBEAN;


public class ProfileDAO {
	//------------------------------------------------fatch profile--------------------------------------
	 	public ProfileBEAN fetch(int u_Id) throws SQLException 
	 	 	{
		 	 	Connection con=null;
		 	 	try{
		 	 			con=ConnectionDAO.getConnection();
	 	
		 	 			PreparedStatement st=con.prepareStatement("select m_Id,u_Id,pwd,f_name,m_name,l_name,gender,dob,Mob_No,email_Id,hobbies,add1,add2,tot_exp_month,tot_exp_year,keyskills,hobbies,profile_pic from members where m_id=? ");
		 	 			st.setInt(1,u_Id);
		 	 			ResultSet rs=st.executeQuery();
		 	 			
		 	 			ProfileBEAN bean;
		 	 			
		 	 			if(rs.next()){
		 	 			
		 	 				bean=new ProfileBEAN();
		 	 				int mid=rs.getInt(1);
		 	 				String uid=rs.getString(2);
		 	 				
		 	 				String pwd=rs.getString(3);
		 	 				String fname=rs.getString(4);  
		 	 				String mname=rs.getString(5);
		 	 				String lname=rs.getString(6);
		 	 				String gender=rs.getString(7);
		 	 						
		 	 				Date d = rs.getDate(8);
		 	 				
		 	 				String mob=rs.getString(9);
		 	 				String email=rs.getString(10);
		 	 				String enroll=rs.getString(11);
		 	 				String add1=rs.getString(12);
		 	 				String add2=rs.getString(13);
		 	 				String totexpmonth=rs.getString(14);
		 	 				String totexpyear=rs.getString(15);
		 	 				String keyskills=rs.getString(16);
		 	 				String otherhobbies=rs.getString(17);
		 	 				String picpath=rs.getString(18);
		 	 				bean.setMemberId(mid);
		 	 				bean.setUserId(uid);  
		 	 				bean.setPassword(pwd); 
		 	 				bean.setFirstName(fname); 
		 	 				bean.setMiddleName(mname);
		 	 				bean.setLastName(lname);
		 	 				bean.setDateAndBirth(d);
		 	 				bean.setGender(gender);
		 	 				bean.setMobileNumber(mob);
		 	 				bean.setEmailId(email);
		 	 				bean.setEnrollmentNumber(enroll);
		 	 				bean.setAddressLineOne(add1);
		 	 				bean.setAddressLineSecond(add2);
		 	 				bean.setPic(picpath);
		 	 				bean.setTotalExprianceMonth(totexpmonth);
		 	 				bean.setTotalExprianceYear(totexpyear);
		 	 				bean.setKeySkills(keyskills);
		 	 				bean.setOtherHobbies(otherhobbies);
		 	 				
					return bean;
		 	 			}
		 	 		
		 	 	}
		 	 	finally{
		 	 		ConnectionDAO.closeConnection(con);
		 	 	}
	 			
		 	 	return null;
	 	}
	 	// education details for memebers
	 	public EducationBEAN educationfatch(int mid) throws SQLException  {	 		
	 		Connection cn = null;		
			ProfileBEAN pb = fetch(mid);
			EducationBEAN bean;
			
	 		try{
	 			cn=ConnectionDAO.getConnection();
	 			PreparedStatement ps=cn.prepareStatement("SELECT degree_type.degree_Type,branch.Branch_Name,passout_year.Passout_yr,edu_details.college_name,edu_details.e_Id,edu_details.d_Id from branch,degree_type,edu_details,members,passout_year where(edu_details.d_Id=degree_type.d_id)AND(members.p_Id=passout_year.p_Id)AND(members.m_Id=edu_details.m_Id)AND(members.b_Id=branch.b_Id)AND(members.highest_degree=degree_type.degree_Type)AND(members.m_Id=?);");
	 			ps.setInt(1, mid);
	 			ResultSet rs=ps.executeQuery();
	 			if(rs.next()){
	 				do {
	 					String degree=rs.getString(1); //BE or ME 
	 					String branch=rs.getString(2); //courceName is branch 
	 					String year=rs.getString(3);  //year 2001
	 					String clgName=rs.getString(4); 	// college name=adit
	 					int educationId=rs.getInt(5);
	 					int degreeId=rs.getInt(6);
	 					
	 					bean=new EducationBEAN();
	 					
	 					bean.setEducationId(educationId);
	 					bean.setDegreeId(degreeId);
	 					bean.setDegree(degree);
	 					bean.setBranch(branch);
	 					bean.setPassOutYear(year);
	 					bean.setCollegeName(clgName);
	 					
	 				}while(rs.next());
	 				pb.setEducation(bean);
	 				return bean;
	 				
 	 			} 
	 			else{
 					return null;
	 			}
	 		}
	 		finally {
				ConnectionDAO.closeConnection(cn);
	 		}
	 	}
	 	//Othereducation where education degree = others
	 	public OtherEducationBean othereducationfatch(int mid) throws SQLException  {	 		
	 		Connection cn = null;
	 		
			ProfileBEAN pb = fetch(mid);
			OtherEducationBean bean;
			
	 		try{
	 			cn=ConnectionDAO.getConnection();
	 			PreparedStatement ps=cn.prepareStatement("SELECT degree_type.degree_Type,cource_name,year,college_name,e_Id FROM edu_details,degree_type,members WHERE (edu_details.d_Id=degree_type.d_Id)AND(members.m_Id=edu_details.m_Id) AND (degree_type.degree_Type='other')AND(edu_details.m_Id=?);");
	 			ps.setInt(1, mid);
	 			ResultSet rs=ps.executeQuery();
	 			if(rs.next()){
	 				do {
	 					String degree=rs.getString(1); //BE or ME 
	 					String course=rs.getString(2); //courceName is in  branch 
	 					String year=rs.getString(3);  //year 2001
	 					String clgName=rs.getString(4); 	// college name=adit
	 					int othereducationId=rs.getInt(5);
	 					bean=new OtherEducationBean();
	 					
	 					bean.setOtherEducationId(othereducationId);
	 					bean.setDegree(degree);
	 					bean.setCourse(course);
	 					bean.setPassoutYear(year);
	 					bean.setCollegeName(clgName);	
	 					
	 				}while(rs.next());
	 				pb.setOthereducation(bean);
	 				return bean;
	 				
 	 			} 
	 			else{
 					return null;
	 			}
	 		}
	 		
	 		finally {
				ConnectionDAO.closeConnection(cn);
	 		}
	 	}
	// ---------member's job 
		public List<JobBean> fatchMemJob(int m_Id) throws SQLException{
 			Connection connectionhobbies = null;
 			
 			List<JobBean> jbean=new ArrayList<JobBean>();
 		
 			ProfileBEAN pbean = fetch(m_Id);
 			JobBean bean;
				
 			try{
 				
 				connectionhobbies = ConnectionDAO.getConnection();
 				PreparedStatement memjob = connectionhobbies.prepareStatement("SELECT designation,start_month,start_year,end_month,end_year,industry_name,fun_Area,pr_Id FROM heroku_9915491d71b4e71.proff_details WHERE m_Id=?");
 				memjob.setInt(1,m_Id);
 				ResultSet jobs = memjob.executeQuery();
 				
 				if(jobs.next()){
 					
 					do{
 						
 						String jobtype=jobs.getString(1);
 						String startmonth=jobs.getString(2);
 						String startyear=jobs.getString(3);
 						String endmonth=jobs.getString(4);
 						String endyear=jobs.getString(5);
 						String industryname=jobs.getString(6);
 						String funcationarea=jobs.getString(7);
 						int prId=jobs.getInt(8);
 						
 						bean=new JobBean();
 						bean.setJobType(jobtype);
 						bean.setStartedMonth(startmonth);
 						bean.setStartedYear(startyear);
 						bean.setEndedMonth(endmonth);
 						bean.setEndedYear(endyear);
 						bean.setIndustryName(industryname);
 						bean.setFuncationArea(funcationarea);
 						bean.setProId(prId);
 						
 						jbean.add(bean);
 						
 					}while(jobs.next());
 					return jbean;
 				}
 				 				
 				else{
 					return new ArrayList<>();
 				}
 			

 			} 
 			catch(Exception e){
 				e.printStackTrace();
 				System.out.print(e);
 			}
		finally {
			pbean.setJob(jbean);	
			ConnectionDAO.closeConnection(connectionhobbies);
				
			}
			return new ArrayList<>();
	 	}
	//-------------------------- all hobbies -------------------------------
		public List<MemhobbiesBEAN> getAllHobbies()throws SQLException{
			Connection con=null;
			MemhobbiesBEAN memhobbiesbean;
			try{
				con=ConnectionDAO.getConnection();
				
				List<MemhobbiesBEAN> listofhobbies= new ArrayList<MemhobbiesBEAN>();
				PreparedStatement hobbieslistquery=con.prepareStatement("SELECT * FROM hobbies");
				ResultSet rs=hobbieslistquery.executeQuery();
				if(rs.next()){
					do{
						memhobbiesbean = new MemhobbiesBEAN();
						memhobbiesbean.setHid(rs.getInt(1));
						memhobbiesbean.setHobbieesname(rs.getString(2));
						listofhobbies.add(memhobbiesbean);
						
					}while(rs.next());
					return listofhobbies;
				}
				
			}
			
			finally{
				ConnectionDAO.closeConnection(con);
			}
			return new ArrayList<>();
		}
		
		public List<Integer> getMemHobbiesid(int m_id){
			Connection con=null;
			try{
				con=ConnectionDAO.getConnection();
			
				List<Integer> listofmemhobbies= new ArrayList<Integer>();
				PreparedStatement secondqueary=con.prepareStatement("SELECT hob_id FROM member_hob  where m_Id=?");
				secondqueary.setInt(1,m_id);
				ResultSet rs2=secondqueary.executeQuery();
				
				if(rs2.next()){
						do {
						int hobid=rs2.getInt(1);
					
					
						listofmemhobbies.add(hobid);
				
						}while(rs2.next());
						return listofmemhobbies;
				} 

			}catch(Exception e){
				System.out.print(e);
				e.printStackTrace();
			}
			return new ArrayList<>();
			
		}
	//----------------- memberhobbies ---------------------------
		public List<MemhobbiesBEAN> getMemHobbies(int m_id)throws SQLException {
			Connection con=null;
			List<MemhobbiesBEAN> listofhobbies= new ArrayList<MemhobbiesBEAN>();
			ProfileBEAN profilebean=fetch(m_id);
			MemhobbiesBEAN memhobbiesbean;
			try{
				con=ConnectionDAO.getConnection();
				List<Integer> listofmemhobbiesid=getMemHobbiesid(m_id);
				if(listofmemhobbiesid==null){
					return new ArrayList<>();
				}
				PreparedStatement hobbieslistquery=con.prepareStatement("SELECT * FROM hobbies");
				ResultSet rs=hobbieslistquery.executeQuery();
				if(rs.next()){
					do{
						if(listofmemhobbiesid.contains(rs.getInt(1)))
						{
							memhobbiesbean = new MemhobbiesBEAN();
							memhobbiesbean.setHobbieesname(rs.getString(2));
							memhobbiesbean.setHid(rs.getInt(1));
							listofhobbies.add(memhobbiesbean);
						}
					}while(rs.next());
					return listofhobbies;
				}
				
			}
			
			finally{
				profilebean.setMemhobbieshobbies(listofhobbies);
				ConnectionDAO.closeConnection(con);
				
			}
			return new ArrayList<>();
		}
//------------------------------------update profile --------------------------
		public void updateprofile(ProfileBEAN bean)throws SQLException {


			Connection updateconnection=null;
		//	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			
			try{
				
				updateconnection=ConnectionDAO.getConnection();
				PreparedStatement updatestatement=updateconnection.prepareStatement("UPDATE members SET pwd=?,f_name=?,m_name=?,l_name=?,email_Id=?,Mob_No=?,gender=?,add1=?,add2=?,tot_exp_month=?,tot_exp_year=?,keyskills=?,hobbies=?,profile_pic=? WHERE m_Id=?");

			
			//	String st = sdf.format(bean.getDateAndBirth());
			
				
				updatestatement.setString(1,bean.getPassword());
				updatestatement.setString(2,bean.getFirstName());
				updatestatement.setString(3,bean.getMiddleName());
				updatestatement.setString(4,bean.getLastName());					
				updatestatement.setString(5,bean.getEmailId());
				updatestatement.setString(6,bean.getMobileNumber());
				updatestatement.setString(7,bean.getGender()); //gender
				updatestatement.setString(8,bean.getAddressLineOne());
				updatestatement.setString(9,bean.getAddressLineSecond());
				updatestatement.setString(10,bean.getTotalExprianceYear());
				updatestatement.setString(11,bean.getTotalExprianceMonth());
				updatestatement.setString(12,bean.getKeySkills());
		//		updatestatement.setString(13,st);
				updatestatement.setString(13,bean.getOtherHobbies());
				updatestatement.setString(14,bean.getPic());
				updatestatement.setInt(15,bean.getMemberId());
				
				updatestatement.executeUpdate();
		
						
			}
			finally{
				ConnectionDAO.closeConnection(updateconnection);
			}
		}
		
	//----------------------------update member's hobbies ---------------------	
		public void updatehobbies(List<MemhobbiesBEAN> hbean)throws SQLException {
			Connection con= null;
			try{
			con=ConnectionDAO.getConnection();
				for(MemhobbiesBEAN bea:hbean){
					PreparedStatement st= con.prepareStatement("DELETE FROM member_hob WHERE m_id=?");
					st.setInt(1,bea.getMem_Id());
					st.executeUpdate();
					break;	
				}
				PreparedStatement st2= con.prepareStatement("INSERT INTO member_hob(m_id,hob_id) VALUES(?,?)");
				for(MemhobbiesBEAN bean2:hbean){
					st2.setInt(1, bean2.getMem_Id());
					st2.setInt(2,bean2.getHid()); 
					st2.executeUpdate();
				}
			}
			finally {
				ConnectionDAO.closeConnection(con);
			}
		}
// 	------------------------- update educationdetails--------------------------
	    public void updateeducationdeatil(EducationBEAN ed)throws SQLException {
	    	
	    	Connection con = null;
	    	Connection con2 = null;
	    	Connection con3 = null;
		try{
			int educationid=ed.getEducationId();
			int degreeid=ed.getDegreeId();			
			String clg=ed.getCollegeName();
			int temmenerid=ed.getTempm_id();
			
			con=ConnectionDAO.getConnection();
			con2=ConnectionDAO.getConnection();
			PreparedStatement st=con2.prepareStatement("SELECT degree_Type FROM degree_type WHERE d_Id=?;");
			st.setInt(1,degreeid);
			ResultSet rs=st.executeQuery();
			
			if(rs.next()){
			String degreename=rs.getString(1);
			 con3=ConnectionDAO.getConnection();	
				PreparedStatement highestdegree=con3.prepareStatement("UPDATE members SET highest_degree=? WHERE m_Id=?;");
				
				highestdegree.setString(1,degreename);
				highestdegree.setInt(2,temmenerid);
				highestdegree.executeUpdate();
			}
			
			PreparedStatement quaryforupdateeducation=con.prepareStatement("UPDATE edu_details SET d_Id=?,college_name=? where e_Id=?");
			quaryforupdateeducation.setInt(1,degreeid);
			quaryforupdateeducation.setString(2,clg);
			quaryforupdateeducation.setInt(3,educationid);
			quaryforupdateeducation.executeUpdate();
			
			
			
		 	}
				
		finally{
			ConnectionDAO.closeConnection(con);
			ConnectionDAO.closeConnection(con2);
			ConnectionDAO.closeConnection(con3);
		}
	}
//------------ update otherseducation details------------------------------
	public void updateothereducationdeatil(OtherEducationBean ed)throws SQLException {
		
		Connection con = null;
		try{
			int eid=ed.getOtherEducationId();
//			String degree=ed.getDegree();
			String course=ed.getCourse();
			String year=ed.getPassoutYear();
			String clg=ed.getCollegeName();
	
			con=ConnectionDAO.getConnection();
			PreparedStatement quaryforupdateothereducation=con.prepareStatement("UPDATE edu_details SET cource_name=?,year=?,college_name=? where e_Id=?");
	//		quaryforupdateothereducation.setString(,degree);
			quaryforupdateothereducation.setString(1,course);
			quaryforupdateothereducation.setString(2,year);
			quaryforupdateothereducation.setString(3,clg);
			quaryforupdateothereducation.setInt(4,eid);
	
			quaryforupdateothereducation.executeUpdate();
		}
			finally{
				ConnectionDAO.closeConnection(con);
			}
	}
//------------------- update jobs details in memeber profile---------------
	public void updatejob(List<JobBean> listofjobs)throws SQLException {
	 
	Connection con = null;
	try{	
		
		for(JobBean list:listofjobs){	
		con=ConnectionDAO.getConnection();
		PreparedStatement pr=con.prepareStatement("UPDATE proff_Details SET designation=?,fun_Area=?,start_month=?,start_year=?,end_month=?,end_year=?,industry_name=? where pr_Id=?;");
		pr.setString(1, list.getJobType());
		pr.setString(2,list.getFuncationArea());
		pr.setString(3,list.getStartedMonth());
		pr.setString(4,list.getStartedYear());
		pr.setString(5,list.getEndedMonth());
		pr.setString(6,list.getEndedYear());
		pr.setString(7,list.getIndustryName());
		pr.setInt(8,list.getProId());
		pr.executeUpdate();
	
		}
	}
	finally{
		ConnectionDAO.closeConnection(con);
	}
}

	
	//------------------------------------------ profile edit option -----------------------
	public List<EducationBEAN> getbranchlist(int u_Id)throws SQLException {
		Connection con=null;
		List<EducationBEAN> listofbranch= new ArrayList<EducationBEAN>();
		EducationBEAN educationbean;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement branch=con.prepareStatement("SELECT branch.b_Id,Branch_Name FROM branch,members where (m_Id=?) and (branch.b_Id<>members.b_Id); ");
			branch.setInt(1,u_Id);
			ResultSet rs=branch.executeQuery();
			if(rs.next()){
				do{
					educationbean=new EducationBEAN();
					educationbean.setBranchId(rs.getInt(1));
					educationbean.setBranch(rs.getString(2));
				
					listofbranch.add(educationbean);
					
				}while(rs.next());
				return listofbranch;
			}
			
		}
		
		finally{
			ConnectionDAO.closeConnection(con);
			
		}
		return new ArrayList<>();
	}
	
	public List<EducationBEAN> getdegreelist(int u_Id)throws SQLException {
		Connection con=null;
		List<EducationBEAN> listofdegree= new ArrayList<EducationBEAN>();
		EducationBEAN educationbean;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement degree=con.prepareStatement("SELECT d_Id,degree_Type FROM degree_type,members where (degree_Type<>'other') AND(degree_Type<>'---')AND (degree_type.degree_Type<>members.highest_degree)AND(m_Id=?); ");
			degree.setInt(1,u_Id);
			ResultSet rs=degree.executeQuery();
			if(rs.next()){
				do{
					educationbean=new EducationBEAN();
					educationbean.setDegreeId(rs.getInt(1));
					educationbean.setDegree(rs.getString(2));
					listofdegree.add(educationbean);
					
				}while(rs.next());
				return listofdegree;
			}
			
		}
		
		finally{
			ConnectionDAO.closeConnection(con);
			
		}
		return new ArrayList<>();
	}
	

	public EducationBEAN getSinglebranchlist(int b_id)throws SQLException {
		Connection con=null;
		EducationBEAN listofbranch= new EducationBEAN();
		EducationBEAN educationbean;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement branch=con.prepareStatement("SELECT * FROM branch where b_Id=? ");
			branch.setInt(1,b_id);
			ResultSet rs=branch.executeQuery();
					educationbean=new EducationBEAN();
					educationbean.setBranch(rs.getString(2));
				return listofbranch;
		}
		
		finally{
			ConnectionDAO.closeConnection(con);
			
		}
	}
	
	public List<EducationBEAN> getsingledegreelist(int d_id)throws SQLException {
		Connection con=null;
		List<EducationBEAN> listofdegree= new ArrayList<EducationBEAN>();
		EducationBEAN educationbean;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement degree=con.prepareStatement("SELECT * FROM degree_type WHERE d_id=?");
			degree.setInt(1,d_id);
			ResultSet rs=degree.executeQuery();
			if(rs.next()){
				do{
					educationbean=new EducationBEAN();
					educationbean.setDegree(rs.getString(2));
					listofdegree.add(educationbean);
					
				}while(rs.next());
				return listofdegree;
			}
			
		}
		
		finally{
			ConnectionDAO.closeConnection(con);
			
		}
		return new ArrayList<>();
	}
//------------------------------------ add job ---------------------------------------
	public int addjob(JobBean bean)throws SQLException {
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement degree=con.prepareStatement("INSERT INTO proff_details(m_Id) VALUES (?);",Statement.RETURN_GENERATED_KEYS);
			degree.setInt(1,bean.getM_Id());
			degree.executeUpdate();
			ResultSet rs = degree.getGeneratedKeys();
			rs.next();
			int id=rs.getInt(1);
			return id;
		}
		
		finally{
			ConnectionDAO.closeConnection(con);
			
		}
	}
//--------------------------------------- del job ---------------------------------------
	public int deljob(JobBean bean)throws SQLException{
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
			PreparedStatement del=con.prepareStatement("DELETE FROM proff_details WHERE pr_Id=?;");
			del.setInt(1,bean.getProId());
			int aff=del.executeUpdate();
			return aff;
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}
	}
}
