package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alumni.admin.beans.NewsBEAN;

import com.alumni.dao.ConnectionDAO;

public class NewsDAO {

	public List<NewsBEAN> news() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
	 	
		try
		{
			con=ConnectionDAO.getConnection();
			Statement st=con.createStatement();
			String s="select title,description,hide,date_time from news";
			ResultSet rs=st.executeQuery(s);
			List<NewsBEAN> array =new ArrayList<NewsBEAN>();
			NewsBEAN nb;
			if(rs.next())
			{
				do {
					nb	=new NewsBEAN();
					nb.setTitle(rs.getString(1));
					nb.setDescription(rs.getString(2));
					nb.setHideStatus(rs.getInt(3));
					nb.setDate_time(rs.getDate(4));
					array.add(nb);
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

	public NewsBEAN createNews(NewsBEAN bean) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into news(title,description,hide,date_time) values(?,?,?,now());");
			ps.setString(1,bean.getTitle());
			ps.setString(2,bean.getDescription());
			ps.setInt(3,bean.getHideStatus());
			
			if(ps.executeUpdate()==1){
				bean.setSuccess(true);
				return bean;
			}else{
				 bean.setSuccess(false);
				return bean;
			 }
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}

	}


}
