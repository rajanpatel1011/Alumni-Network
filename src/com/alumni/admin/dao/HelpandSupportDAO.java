package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alumni.admin.beans.HelpandSupportBEAN;
import com.alumni.dao.ConnectionDAO;

public class HelpandSupportDAO {
	
	
	public List<HelpandSupportBEAN> HelpandSupportDisplay() throws SQLException
	{
		Connection con=null;
		try
		{	
			
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("Select * from helpsuppot");
			ResultSet rs=st.executeQuery();
			List<HelpandSupportBEAN> list=new ArrayList<HelpandSupportBEAN>();
		
			if(rs.next())
			{
				do{
					int e_id=rs.getInt(1);
					String email_id=rs.getString(2);
					String Mesage=rs.getString(3);
					HelpandSupportBEAN bean=new HelpandSupportBEAN();
					bean.setH_id(e_id);
					bean.setEmail_id(email_id);
					bean.setMessage(Mesage);
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
	
		
		
		public void deleteHelpandSupport(int h_id) throws SQLException
		{
			Connection con=null;
			try
			{	
				
				con=ConnectionDAO.getConnection();
				PreparedStatement st=con.prepareStatement("delete from helpsuppot where h_id=?");
				st.setInt(1,h_id);
				st.executeUpdate();
				
			}
			
			finally
			{
				ConnectionDAO.closeConnection(con);
			}
		
		
		}
	}


