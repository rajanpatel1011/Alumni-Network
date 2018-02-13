package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alumni.dao.ConnectionDAO;

public class BranchDAO {

	public int addBranch(String branch) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into branch(Branch_Name) values(?)");
			ps.setString(1,branch);
			
			if(ps.executeUpdate()==1){
				return 1;
			}else{
				return 0;
			 }
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}

	}
	
	public int checkAddedBranch(String branch) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT Count(Branch_Name) FROM branch where Branch_Name=?");
			ps.setString(1,branch);
			
			if(ps.executeUpdate()==1){
				return 1;
			}else{
				return 0;
			 }
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}

	}
	
	public void deleteBranch(int branch) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from branch where b_Id=?;");
			ps.setInt(1,branch); 
			ps.executeUpdate();
			
		}finally 
		{
			ConnectionDAO.closeConnection(con);
		}
	}

}
