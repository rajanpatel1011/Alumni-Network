package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.BranchDrpBEAN;

public class BranchDrpDAO {

public List<BranchDrpBEAN> branch() throws ClassNotFoundException, SQLException{
		
		// System.out.println("In Branch DAO");
		Connection con=null;
		try
		{		
			con=ConnectionDAO.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from branch"); 
			ResultSet rs1 = ps1.executeQuery();

			List<BranchDrpBEAN> array;
			BranchDrpBEAN branchDrpBEAN;
			if(rs1.next())
			{
				array = new ArrayList<BranchDrpBEAN>();
				do {
					branchDrpBEAN = new BranchDrpBEAN();
					branchDrpBEAN.setBranch(rs1.getString(2));
					branchDrpBEAN.setBranchId(rs1.getInt(1));
					array.add(branchDrpBEAN);
				}while(rs1.next());	
				return array;
			} else {
				return new ArrayList<>();
			}
		}		
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
	}

}
