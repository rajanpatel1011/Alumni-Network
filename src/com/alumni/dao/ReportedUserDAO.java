package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.ReportedUserBEAN;
import com.alumni.beans.ReporterUserBEAN;

public class ReportedUserDAO {

	public List<ReportedUserBEAN> reportedUserView(int batch_id,int passout_id) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		try
		{
			con = ConnectionDAO.getConnection();
			
			System.out.print("In reportedUserView : DAO ");
			String reported_userList = "SELECT DISTINCT repoted_users.Repoted_UId,members.f_name,members.l_name,repoted_users.wrng_msg,repoted_users.ban FROM repoted_users,members where (members.m_Id=repoted_users.repoted_UId) and (members.b_Id=?)and(members.p_Id=?)and(repoted_users.ban=0);";
			PreparedStatement ps = con.prepareStatement(reported_userList);
			
			ps.setInt(1,batch_id);
			ps.setInt(2,passout_id);
			System.out.print("Batch: "+batch_id+" & PassoutID: "+passout_id);

			ResultSet rs = ps.executeQuery();
			
			List<ReportedUserBEAN> array;
			ReportedUserBEAN rtdub;
			
			if(rs.next())
			{
				array = new ArrayList<ReportedUserBEAN>();
				do{
					rtdub = new ReportedUserBEAN();
					
					int reported_Id = rs.getInt(1); // For second query !
					rtdub.setReported_Id(rs.getInt(1));
					rtdub.setReported_fname(rs.getString(2));
					rtdub.setReported_lname(rs.getString(3));
					rtdub.setWrng_msg(rs.getString(4));
					rtdub.setBan(rs.getInt(5));
					// ==== Checking ===
					System.out.print("\nreported ID : "+rs.getInt(1));
					System.out.print("\nreported fname : "+rs.getString(2));
					System.out.print("\nreported lname : "+rs.getString(3));
					System.out.print("\nreported warning : "+rs.getString(4));
					System.out.print("\nreported ban? : "+rs.getInt(5));
					// === Checking over ===
					// ============================================== SubQuery ! Starts  ============================================
					String reporter_userList = "SELECT repoted_users.Repoter_UId,members.f_name,members.l_name,repoted_users.issu_msg FROM repoted_users,members where (members.m_Id=repoted_users.repoter_UId) and (repoted_users.Repoted_UId=?);";
					PreparedStatement ps1 = con.prepareStatement(reporter_userList);
					
					ps1.setInt(1,reported_Id);
					
					ResultSet rs1 = ps1.executeQuery();
					
					List<ReporterUserBEAN> array1 = new ArrayList<ReporterUserBEAN>();
					ReporterUserBEAN rtrub;
					
					if(rs1.next())
					{
						do{
							rtrub = new ReporterUserBEAN();
							rtrub.setReporter_id(rs1.getInt(1));
							rtrub.setReporter_fname(rs1.getString(2));
							rtrub.setReporter_lname(rs1.getString(3));
							rtrub.setIssu_msg(rs1.getString(4));
							array1.add(rtrub);
							
						}while(rs1.next());
					}

					rtdub.setReporterUser(array1);
					
					// ============================================== SubQuery ! ENDS    ============================================

					array.add(rtdub);
					
				}while(rs.next());
				return array;
			}
			else
				{
				return null;
				}

		}
	
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}


		
	}
	
	
	public void reportedUserWarn(int reported_User_Id) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		try
		{
			con = ConnectionDAO.getConnection();
			ReportedUserBEAN rtdub = new ReportedUserBEAN();
			String reported_warn = "UPDATE repoted_users SET wrng_msg=? where Repoted_UId=?;";
			PreparedStatement ps = con.prepareStatement(reported_warn);
			ps.setString(1,rtdub.getWrng_msg());
			ps.setInt(2,reported_User_Id);
			ps.executeUpdate();

		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}



	} 
	
	
	
}
