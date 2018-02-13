package com.alumni.admin.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.dao.ConnectionDAO;
import com.alumni.admin.beans.InitModBEAN;

public class InitModDAO {

	 	public List<InitModBEAN> getIntUserList()throws SQLException{
	 		
	 		Connection con=null;
			try
			{		
				con=ConnectionDAO.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT init_users.m_Id,f_name,l_name,Branch_Name,Passout_yr FROM init_users,members,passout_year,branch WHERE(init_users.m_Id=members.m_Id) AND(members.p_Id=passout_year.p_Id) AND(members.b_Id=branch.b_Id);");
				ResultSet rs = ps.executeQuery();
				List<InitModBEAN> listofmod;
				InitModBEAN m;
				if(rs.next())
				{
					listofmod = new ArrayList<InitModBEAN>();
					do {
						m = new InitModBEAN();
						m.setM_Id(rs.getInt(1));
						m.setF_name(rs.getString(2));
						m.setL_name(rs.getString(3));
						m.setBranch_name(rs.getString(4));
						m.setYear(rs.getString(5));
						listofmod.add(m);
						
					}while(rs.next());	
					return listofmod;
				} else
					return null;
			}		
			finally 
			{
				ConnectionDAO.closeConnection(con);
			}
	 	}	
			public  void BecomeInitMod(InitModBEAN bean)throws SQLException{
				
			
		 		Connection con=null;
				try
				{		
					con=ConnectionDAO.getConnection();
					PreparedStatement ps = con.prepareStatement("DELETE from init_users where m_Id=?;");
					ps.setInt(1,bean.getM_Id());
					ps.executeUpdate();
					ps=con.prepareStatement("insert into init_mod(m_Id) VALUES (?);");
					ps.setInt(1,bean.getM_Id());
					ps.executeUpdate();
					ps=con.prepareStatement("INSERT into moderator(m_Id) VALUES (?);");
					ps.setInt(1,bean.getM_Id());
					ps.executeUpdate();
					ps=con.prepareStatement("UPDATE members SET acc_type=1 WHERE m_Id=?;");
					ps.setInt(1,bean.getM_Id());
					ps.executeUpdate();
				}		
				finally 
				{
					ConnectionDAO.closeConnection(con);
				}
				
			}
			
			public int getMemId(int m) throws SQLException{
				Connection con=null;
				
				try{
					con=ConnectionDAO.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT m_Id FROM init_users where i_Id=?;");
					ps.setInt(1,m);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						return rs.getInt(1);
					}
					
				}finally{
					ConnectionDAO.closeConnection(con);
				}
				return (Integer) null;
			}
}
