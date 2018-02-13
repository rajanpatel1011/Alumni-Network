package com.alumni.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.beans.GalleryAlbumUploadBEAN;
import com.alumni.beans.ModeratorRequestBean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GalleryAlbumUploadDAO {
	
	
	public void uploadAlbum(GalleryAlbumUploadBEAN bean) 
	{
		Connection con=null;
		try
		{	
			SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
			String newdate1=formetter.format(bean.getDate_time());
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO album values(?,?,?,?,?,?,?,?,?,now(),?)");
			st.setInt(1,0);
			st.setInt(2, bean.getM_id());
			st.setInt(3,bean.getPermission());
			st.setString(4,newdate1);
			st.setString(5,bean.getCaption());
			st.setString(6, bean.getUpload_pic());
			st.setString(7,bean.getAlbum_name());
			st.setString(8,null);
			st.setString(9, bean.getDetails());
			st.setInt(10,0);
			st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println (e);
		}
	
		
	}
	
	
	public List<GalleryAlbumUploadBEAN> view(int p_id, int b_id) throws ClassNotFoundException, SQLException /* Method to display List of all available users data in database name Tempuserdata  */
	{
		
		Connection con=null;

		 	
		try
		{
		
		con=ConnectionDAO.getConnection();
		String s="SELECT album.*,members.f_name,members.l_name,permision.perm_Name,members.m_Id  FROM album,members,permision where (album.uplodr_Id=members.m_id) and (album.perm_Id=permision.perm_Id) and (album.delete_flag = 0) and ((album.perm_Id=1) or (album.perm_Id=2 and p_Id=? and b_Id=?) or (album.perm_Id=3 and p_Id=?) or (album.perm_Id=4 and b_Id=?)); ";
		PreparedStatement ps1=(PreparedStatement) con.prepareStatement(s);
		ps1.setInt(1,p_id);
		ps1.setInt(2,b_id);
		ps1.setInt(3,p_id);
		ps1.setInt(4,b_id);
		ResultSet rs=ps1.executeQuery();
		List<GalleryAlbumUploadBEAN> array =new ArrayList<GalleryAlbumUploadBEAN>();
		GalleryAlbumUploadBEAN ub;
		if(rs.next())
		{
			do {
				ub	=new GalleryAlbumUploadBEAN();
				int a_id=rs.getInt(1);
				int u_id=rs.getInt(2);
				int permission=rs.getInt(3);
				Date DateandTime=rs.getDate(4);	
				String  caption=rs.getString(5);
				String uploadpic=rs.getString(6);
				String AlbumName=rs.getString(7);
				String details=rs.getString(9);
				Date CreationDate=rs.getDate(10);
				int delflag=rs.getInt(11);
				String f_name=rs.getString(12);
				String l_name=rs.getString(13);
				String permission_name=rs.getString(14);
				int m_id=rs.getInt(15);
				ub.setA_id(a_id);
				ub.setM_id(u_id);
				ub.setPermission(permission);
				ub.setDate_time(DateandTime);
				ub.setCaption(caption);
				ub.setUpload_pic(uploadpic);
				ub.setAlbum_name(AlbumName);
				ub.setDetails(details);
				ub.setAlbumCreatedTime(CreationDate);
				ub.setDeleteFlag(delflag);
				ub.setF_name(f_name);
				ub.setL_name(l_name);
				ub.setPermissionName(permission_name);
				ub.setM_id(m_id);
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
