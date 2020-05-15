package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alumni.beans.PhotoUploadBean;

public class DeletePicDAO {

	public String selectPhoto(PhotoUploadBean bean) throws SQLException
	{
		Connection con=null;
		try
		{	
			con=ConnectionDAO.getConnection();
			PreparedStatement p = con.prepareStatement("Select picture_loc from photos WHERE ph_Id=?;");
			p.setInt(1,bean.getPhoto_id());
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				String path=rs.getString(1);
				return path;
			}
			
		}
		finally{

			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public void delectPhoto(PhotoUploadBean bean) throws SQLException
	{
		Connection con=null;
		try
		{	
			con=ConnectionDAO.getConnection();
			PreparedStatement p = con.prepareStatement("DELETE FROM photos WHERE ph_Id=?;");
			p.setInt(1,bean.getPhoto_id());
			p.executeUpdate();
		
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}

	}

}
