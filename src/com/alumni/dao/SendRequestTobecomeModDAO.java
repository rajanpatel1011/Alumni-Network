package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.alumni.beans.sendRequestToBecomeModbeans;

public class SendRequestTobecomeModDAO {

	public sendRequestToBecomeModbeans check(sendRequestToBecomeModbeans bean)throws SQLException  {
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
		
		PreparedStatement st=con.prepareStatement("SELECT count(m_id) FROM modrequest where m_id=?;");
		st.setInt(1,bean.getM_id());
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			bean.setCheck(rs.getInt(1));
			return bean;
		}
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}
		return bean;
	}
	public void sendRequestToBecomeMod(sendRequestToBecomeModbeans bean)throws SQLException  {
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
		
		PreparedStatement st=con.prepareStatement("INSERT INTO modrequest VALUES (?,?,?,?);");
		st.setString(1,null);
		st.setInt(2,bean.getM_id());
		st.setString(3,null);
		st.setString(4,null);
		st.executeUpdate();
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}
	
	
	}
	
	public sendRequestToBecomeModbeans canBeMod(sendRequestToBecomeModbeans bean)throws SQLException  {
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
		
		PreparedStatement st=con.prepareStatement("SELECT count(m_id) from members where (acc_type=1) and(p_Id=? and b_Id=?);");
		st.setInt(1,bean.getBid());
		st.setInt(2,bean.getPid());
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			bean.setEnable(rs.getInt(1));
			return bean;
		}
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}
		return bean;
	}
	
	public sendRequestToBecomeModbeans Modacc(sendRequestToBecomeModbeans bean)throws SQLException  {
		Connection con=null;
		try{
			con=ConnectionDAO.getConnection();
		
		PreparedStatement st=con.prepareStatement("SELECT acc_type from members where (m_Id=?);");
		st.setInt(1,bean.getM_id());
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			bean.setAcctype(rs.getInt(1));
			return bean;
		}
		}
		finally{
			ConnectionDAO.closeConnection(con);
		}
		return bean;
	}

}

