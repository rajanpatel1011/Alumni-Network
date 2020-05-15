package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.MsgBEAN;

public class MsgDAO {
	
	// ---------------------------------- Method for fetching messages from db----------------------
	
	public List<MsgBEAN> msg(int member_id) throws ClassNotFoundException, SQLException

	{
		Connection con = null;
		try
		{
			con = ConnectionDAO.getConnection();

			String s = "select forum.creator_id,members.f_name,members.l_name,forum.desription,forum.date_time from aumninw.forum,aumninw.members where (forum.creator_id=members.m_id) and (forum.reciver_id=?);";
			
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, member_id);
			ResultSet rs = ps.executeQuery();
			List<MsgBEAN> array = new ArrayList<MsgBEAN>();
			MsgBEAN mb;
			
			if(rs.next())
			{
				do{
					mb = new MsgBEAN();
					
					mb.setCreator_id(rs.getInt(1));
					mb.setF_name(rs.getString(2));
					mb.setL_name(rs.getString(3));
					mb.setDisription(rs.getString(4));
					mb.setDate_time(rs.getDate(5));					
					
					array.add(mb);
					
				}while(rs.next());
				return array;
			}
			else
			{
				return new ArrayList<>();
			}
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
		
	}
	
	


}
