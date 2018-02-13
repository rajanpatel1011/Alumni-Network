package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.EducationBEAN;
import com.alumni.beans.JobBean;
import com.alumni.beans.MemhobbiesBEAN;
import com.alumni.beans.ProfileBEAN;
import com.alumni.dao.ProfileDAO;

public class ProfileBO {
	
	//---------------------------------------- profile details fatch ---------------------
	public ProfileBEAN  fetch(int m_id) throws SQLException{ 
	ProfileDAO profileDAO=new ProfileDAO();
	ProfileBEAN bean = profileDAO.fetch(m_id);
	bean.setEducation(profileDAO.educationfatch(bean.getMemberId()));
	bean.setOthereducation(profileDAO.othereducationfatch(bean.getMemberId()));
	bean.setMemhobbieshobbies(profileDAO.getMemHobbies(bean.getMemberId()));
	bean.setJob(profileDAO.fatchMemJob(bean.getMemberId()));
	return bean;
	}
	//--------------------------------------- get education details for first login user----------------
//	public  List<EducationBEAN> getFirstListOfEducation() throws SQLException{
//		ProfileDAO o1= new ProfileDAO();
	//	List<EducationBEAN> b1 = o1.;
	//	return null;
		
//	}
	//-------------------------------------- get all hobbies from check box option ----------------
	public List<MemhobbiesBEAN> getAllListOfHobbies() throws SQLException{
		ProfileDAO o= new ProfileDAO();
		List<MemhobbiesBEAN> b = o.getAllHobbies();
		return b;
	}
	//-------------------------------------- update profile details ----------------------------
	public void  updateprofile(ProfileBEAN bean)throws SQLException{
		ProfileDAO profileedit=new ProfileDAO();
		profileedit.updateprofile(bean);
		profileedit.updatehobbies(bean.getMemhobbieshobbies());
		profileedit.updateeducationdeatil(bean.getEducation());
		profileedit.updateothereducationdeatil(bean.getOthereducation());
		profileedit.updatejob(bean.getJob());
	}
	
	
	//------------ all degree except selected list BE/ME/PH.D -------------------------
	public List<EducationBEAN> alldegree(int u_Id) throws SQLException{
		ProfileDAO profileoptiondegree = new ProfileDAO();
		List<EducationBEAN> bean =profileoptiondegree.getdegreelist(u_Id);
		return bean;
	}
	 
	//------------------ add job block ---------------------
	public int addJob(JobBean bean)throws SQLException{
		ProfileDAO profiledao = new ProfileDAO();
		int b=profiledao.addjob(bean);
		return b;
	}
//--------------------- delete job block ------------------
	public int delJob(JobBean bean)throws SQLException{
		ProfileDAO dao = new ProfileDAO();
		int d=dao.deljob(bean);
		return d;
	}
	
}
