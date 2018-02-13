package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.SearchMembersBEAN;

public class SearchMembersDAO {

	public List<SearchMembersBEAN> getSearchMembers(String searchText, String optionSelected, int b_Id, int p_Id, int loginId) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps1 = null;
			
			if(optionSelected.equals("1")){
				ps1 = con.prepareStatement("select m.m_Id,m.u_Id,m.f_name,m.l_name,m.profile_pic,b.Branch_Name as b_Name,p.Passout_yr as p_Name from members m,branch b,passout_year p where m.b_Id=b.b_Id and m.p_Id=p.p_Id and f_name Like '"+searchText+"%' and m.m_Id<>?");
				ps1.setInt(1, loginId);
			}else if(optionSelected.equals("2")){
				ps1 = con.prepareStatement("select m.m_Id,m.u_Id,m.f_name,m.l_name,m.profile_pic,b.Branch_Name as b_Name,p.Passout_yr as p_Name from members m,branch b,passout_year p where m.b_Id=b.b_Id and m.p_Id=p.p_Id and f_name Like '"+searchText+"%' and m.p_Id=? and m.b_Id=? and m.m_Id<>?");
				ps1.setInt(1, p_Id);
				ps1.setInt(2, b_Id);
				ps1.setInt(3, loginId);
			}else if(optionSelected.equals("3")){
				ps1 = con.prepareStatement("select m.m_Id,m.u_Id,m.f_name,m.l_name,m.profile_pic,b.Branch_Name as b_Name,p.Passout_yr as p_Name from members m,branch b,passout_year p where m.b_Id=b.b_Id and m.p_Id=p.p_Id and f_name Like '"+searchText+"%' and m.p_Id=? and m.m_Id<>?");
				ps1.setInt(1, p_Id);
				ps1.setInt(2, loginId);
			}else if(optionSelected.equals("4")){
				ps1 = con.prepareStatement("select m.m_Id,m.u_Id,m.f_name,m.l_name,m.profile_pic,b.Branch_Name as b_Name,p.Passout_yr as p_Name from members m,branch b,passout_year p where m.b_Id=b.b_Id and m.p_Id=p.p_Id and f_name Like '"+searchText+"%' and m.b_Id=? and m.m_Id<>?");
				ps1.setInt(1, b_Id);
				ps1.setInt(2, loginId);
			}
			 
			ResultSet rs1 = ps1.executeQuery();

			List<SearchMembersBEAN> array;
			SearchMembersBEAN bean;
			if(rs1.next())
			{
				array = new ArrayList<SearchMembersBEAN>();
				do {
					bean = new SearchMembersBEAN();
					bean.setmId(rs1.getInt(1));
					bean.setuId(rs1.getString(2));
					bean.setFname(rs1.getString(3));
					bean.setLname(rs1.getString(4));
					bean.setPicUrl(rs1.getString(5));
					bean.setBranch(rs1.getString(6));
					bean.setYear(rs1.getString(7));
					
				
					array.add(bean);
				}while(rs1.next());	
				return array;
			} else
				return null;
		}		
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
		
	}

}
