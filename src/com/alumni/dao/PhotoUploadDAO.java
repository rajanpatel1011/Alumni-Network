package com.alumni.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.alumni.beans.PhotoUploadBean;

public class PhotoUploadDAO {

	
	public void uploadAlbum(PhotoUploadBean bean) 
	{
		Connection con=null;
		try
		{	
			SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
			String newdate1=formetter.format(bean.getTakendate());
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO photos values(?,?,?,?,?,?,?,?)");
			st.setInt(1,0);
			System.out.println("in dao");
			st.setInt(2, bean.getA_id());
			st.setString(3,bean.getTitle());
			st.setString(4,bean.getImagepath());
			st.setInt(5,bean.getM_id());
			st.setString(6, bean.getCaption());
			st.setInt(7,bean.getPrivacy());
			st.setString(8,newdate1);
			st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public List<PhotoUploadBean> view(int p_id, int b_id,int a_id) throws ClassNotFoundException, SQLException /* Method to display List of all available users data in database name Tempuserdata  */
	{
		
		Connection con=null;

		 	
		try
		{
		
		con=ConnectionDAO.getConnection();
		String s="SELECT photos.*,members.f_name,members.l_name,permision.perm_Name FROM photos,members,permision,album where (photos.creator_Id=members.m_id) and (photos.perm_Id=permision.perm_Id) and (album.a_Id=photos.a_Id) and (photos.a_Id=?) and (( ((photos.perm_Id=1) or (photos.perm_Id=2) or (photos.perm_Id=3) or (photos.perm_Id=4)) and album.perm_Id=1) or ( ((photos.perm_Id=1) or (photos.perm_Id=2) or (photos.perm_Id=3)) and p_Id=? and b_Id=? and album.perm_id=2) or ( ((photos.perm_Id=1) or (photos.perm_Id=3)) and p_Id=? and album.perm_Id=3) or ( ((photos.perm_Id=1) or (photos.perm_Id=4)) and b_Id=? and album.perm_Id=4));";
		PreparedStatement ps1=(PreparedStatement) con.prepareStatement(s);
		ps1.setInt(1,a_id);
		ps1.setInt(2,p_id);
		ps1.setInt(3,b_id);
		ps1.setInt(4,p_id);
		ps1.setInt(5,b_id);
		ResultSet rs=ps1.executeQuery();
		List<PhotoUploadBean> array =new ArrayList<PhotoUploadBean>();
		PhotoUploadBean ub;
		if(rs.next())
		{
			do {
				ub	=new PhotoUploadBean();
				int ph_id=rs.getInt(1);
				int a_id1=rs.getInt(2);
				String pic_title=rs.getString(3);
				String pic_loc=rs.getString(4);
				int m_id=rs.getInt(5);
				String caption=rs.getString(6);
				int P_id=rs.getInt(7);
				Date date=rs.getDate(8);
				String f_name=rs.getString(9);
				String l_name=rs.getString(10);
				String pername=rs.getString(11);
				
				ub.setA_id(a_id1);
				ub.setM_id(m_id);
				ub.setPrivacy(P_id);
				ub.setTakendate(date);
				ub.setCaption(caption);
				ub.setImagepath(pic_loc);
				
				ub.setF_name(f_name);
				ub.setL_name(l_name);
				ub.setPerm_name(pername);
				ub.setPhoto_id(ph_id);
				ub.setTitle(pic_title);
				array.add(ub);
			}
			while(rs.next());	
			
			return array;
		} else
			return null;

		
		}
		
		finally 
		{
			
			ConnectionDAO.closeConnection(con);
		}
		
		
	}








}
