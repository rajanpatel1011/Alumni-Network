package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.alumni.admin.beans.EventCreateBEAN;
import com.alumni.admin.beans.EventDisplayBEAN;
import com.alumni.dao.ConnectionDAO;

public class EventDAO {

	public void CreateEvent(EventCreateBEAN bean) 
	{
		Connection con=null;
		try
		{	
			SimpleDateFormat formetter=new SimpleDateFormat("yyyy-mm-dd");
			String newdate1=formetter.format(bean.getOrgdate());
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO event values(?,?,?,?,?,now(),?)");
			st.setInt(1,0);
			st.setString(2,bean.getTitle());
			st.setString(3,bean.getEvent_pic());
			st.setString(4,newdate1);
			st.setString(5,bean.getDescription());
			st.setInt(6,1);
			st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println (e);
		}
	
		
	}
	public void DeleteEvent(EventCreateBEAN bean) 
	{
		Connection con=null;
		try
		{	
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("delete from event where evnt_id=?");
			st.setInt(1,bean.getE_id());
			st.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println (e);
		}
	
		
	}
	
	public List<EventDisplayBEAN> eventDisplay() throws SQLException
	{
		Connection con=null;
		try
		{	
			
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("Select * from event");
			ResultSet rs=st.executeQuery();
			List<EventDisplayBEAN> list=new ArrayList<EventDisplayBEAN>();
		
			if(rs.next())
			{
				do{
					int Event_id=rs.getInt(1);
					String title=rs.getString(2);
					String pic_path=rs.getString(3);
					Date orgdate=rs.getDate(4);
					String Description=rs.getString(5);
					Date posteddate=rs.getDate(6);
					int Flag=rs.getInt(7);
					EventDisplayBEAN bean=new EventDisplayBEAN();
					bean.setEvent_id(Event_id);
					bean.setTitle(title);
					bean.setDescription(Description);
					bean.setFlag(Flag);
					bean.setOrg_date(orgdate);
					bean.setPic_path(pic_path);
					bean.setPosteddate(posteddate);
					list.add(bean);
			
					}
			while(rs.next());
				
			return list;
			}
			else
				return null;
	
	
		
			
	}
		finally
		{
			ConnectionDAO.closeConnection(con);
		}
	
	
	}
	public void eventVisibilityON(int e_id) throws SQLException
	{
		Connection con=null;
		try
		{	
			
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("update event set flag=? where evnt_id=?");
			st.setInt(1,1);
			st.setInt(2,e_id);
			st.executeUpdate();	
	}
		finally
		{
			ConnectionDAO.closeConnection(con);
		}
	
	
	}
	public void eventVisibilityOFF(int e_id) throws SQLException
	{
		Connection con=null;
		try
		{	
			
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("update event set flag=? where evnt_id=?");
			st.setInt(1,0);
			st.setInt(2,e_id);
			st.executeUpdate();	
	}
		finally
		{
			ConnectionDAO.closeConnection(con);
		}
	
	
	}


	
}
