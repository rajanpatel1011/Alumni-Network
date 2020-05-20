package com.alumni.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.CommentBEAN;

public class CommentDAO {

	public void AddComments(String addcomment, String f_Id, int cr_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try
		{		
			con=ConnectionDAO.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into comment(f_Id,cmt_data,m_Id,date_time) values(?,?,?,now());");
			ps.setInt(1,Integer.parseInt(f_Id));
			ps.setString(2, addcomment);
			ps.setInt(3,cr_id);
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("update forum set No_Of_cmt = (select count(c_Id) as noCmt from comment where f_Id=forum.f_Id) where f_Id=forum.f_Id;");
			ps1.executeUpdate();
			
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}
	}

	public void LikeComment(int c_Id, int m_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		
		try
		{		
			con=ConnectionDAO.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into ratecmt(cmt_Id,m_Id) values(?,?)");
			ps.setInt(1,c_Id);
			ps.setInt(2,m_id);
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("Update comment set rate = rate + 1 where c_Id=?");
			ps1.setInt(1, c_Id);
			ps1.executeUpdate();
			
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}
		
		
	}

	public void deleteComment(int c_Id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try
		{
			con = ConnectionDAO.getConnection();

			String s = "delete from ratecmt where cmt_Id=?";
			//String s = "update forum set delete_flag=1 where (f_id=? AND creator_id=?);";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1,c_Id);
			ps.executeUpdate();

			String s1 = "delete from comment where c_Id=?";
			//String s = "update forum set delete_flag=1 where (f_id=? AND creator_id=?);";
			PreparedStatement ps1 = con.prepareStatement(s1);
			ps1.setInt(1,c_Id);
			ps1.executeUpdate();
			
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
	}

}
