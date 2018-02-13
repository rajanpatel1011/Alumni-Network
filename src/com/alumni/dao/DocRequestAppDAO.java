package com.alumni.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.alumni.beans.DocRequestAppBean;

public class DocRequestAppDAO {

	
				
	public int sendDocRequest(DocRequestAppBean app,int m_id,String email ) /* fetching specific user data from database using tempID   */
	{
		Connection con=null;
		try
		{
			con=ConnectionDAO.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO doc_req values(?,?,?,now(),?,?,?,?,?,?);");
			st.setInt(1,0);
			st.setInt(2,m_id);
			st.setString(3,app.getData());
			st.setString(4,email);
			st.setString(5,app.getSubject());
			st.setInt(6,app.getAccept());
			st.setInt(7,app.getPanding());
			st.setInt(8,app.getReady());
			st.setInt(9,app.getRejected());	
			
			int flag=st.executeUpdate();
			return flag;
	
		}
		catch(Exception e)
		{
			System.out.println (e);
		}
		return 0;
		
		
		
		
		
	}
	
	
	
	
	
}
