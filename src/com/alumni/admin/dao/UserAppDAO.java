package com.alumni.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alumni.dao.ConnectionDAO;
import com.alumni.admin.beans.UserAppBEAN;

public class UserAppDAO {

	public List<UserAppBEAN> displayListOfApp() throws SQLException {
		Connection con = null;
		List<UserAppBEAN> lisrbean = new ArrayList<UserAppBEAN>();
		UserAppBEAN bean;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT doc_Id,members.f_name,members.enr_No,data,date_time,sub,pannding FROM doc_req,members where(doc_req.m_Id=members.m_Id)AND(pannding=1);");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				do {
					bean = new UserAppBEAN();
					bean.setDoc_Id(rs.getInt(1));
					bean.setSenderName(rs.getString(2));
					bean.setEnrollNo(rs.getString(3));
					bean.setData(rs.getString(4));
					bean.setDate(rs.getDate(5));
					bean.setSubject(rs.getString(6));
					bean.setStatus(rs.getInt(7));

					lisrbean.add(bean);

				} while (rs.next());
				return lisrbean;
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;
	}

	public void deleteApp(int d_Id) throws SQLException {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from doc_req where doc_Id=?");
			ps.setInt(1, d_Id);
			ps.executeUpdate();

		} finally {
			ConnectionDAO.closeConnection(con);
		}
	}

	public void updateAppStatus(UserAppBEAN d) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			int st = d.getStatus();
			if (st == 1) {
				PreparedStatement ps = con.prepareStatement("UPDATE  doc_req SET pannding=0 Where doc_Id=?;");
				ps.setInt(1, d.getDoc_Id());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = con.prepareStatement("UPDATE  doc_req SET pannding=1 WHERE doc_Id=?;");
				ps.setInt(1, d.getDoc_Id());
				ps.executeUpdate();

			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}

	}

	public int getStatus(int doc_Id) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT pannding FROM doc_req where(doc_Id=?);");
			ps.setInt(1, doc_Id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int stu = rs.getInt(1);
				return stu;
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return (Integer) null;
	}

	public int getmem(int doc) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT m_Id from doc_req where doc_Id=?;");
			ps.setInt(1, doc);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int stu = rs.getInt(1);
				return stu;
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return (Integer) null;
	}

	public String getemail(int m) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT email_id from members where m_Id=?;");
			ps.setInt(1, m);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String stu = rs.getString(1);
				return stu;
			}

		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;
	}

}
