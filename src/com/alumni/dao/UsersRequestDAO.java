package com.alumni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alumni.beans.UserRequestBean;

public class UsersRequestDAO {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public UserRequestBean usersInfo(int Tempid) /* fetching specific user data from database using tempID */
	{
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement st = con
					.prepareStatement("Select * from tempuserdata  where tempUID=? and email_verify=?");
			st.setInt(1, Tempid);
			st.setInt(2, 1);
			ResultSet rs = st.executeQuery();
			UserRequestBean ub = new UserRequestBean();
			while (rs.next()) {

				ub.setTempUID(rs.getInt(1));
				ub.setEnr_no(rs.getString(2));
				ub.setF_name(rs.getString(3));
				ub.setL_name(rs.getString(4));
				ub.setGender(rs.getString(5));
				ub.setDob(rs.getDate(6));
				ub.setEmail_id(rs.getString(7));
				ub.setP_id(rs.getInt(8));
				ub.setB_id(rs.getInt(9));
				return ub;

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	/*
	 * Method to display List of all available users data in database name
	 * Tempuserdata
	 */
	public List<UserRequestBean> users(int i, int j, int k) throws ClassNotFoundException, SQLException {

		Connection con = null;
		int chekflag = 0;

		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		try {
			con = ConnectionDAO.getConnection();
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			Statement st3 = con.createStatement();
			// String s="SELECT tempuserdata.tempUID, tempuserdata.enr_no,
			// tempuserdata.f_name,
			// tempuserdata.l_name,tempuserdata.gender,tempuserdata.dob,tempuserdata.email_Id,branch.Branch_Name,passout_year.Passout_yr
			// FROM tempuserdata INNER JOIN branch ON tempuserdata.b_Id = branch.b_Id INNER
			// JOIN passout_year ON tempuserdata.p_id = passout_year.p_id AND
			// tempuserdata.b_Id = branch.b_Id and verify_flag=1";
			String cls = "select tempuserdata.tempUID, tempuserdata.enr_no, tempuserdata.f_name, tempuserdata.l_name,tempuserdata.gender,tempuserdata.dob,tempuserdata.email_Id,branch.Branch_Name,passout_year.Passout_yr from tempuserdata,branch,passout_year,moderator modr,members mem where tempuserdata.b_Id = branch.b_Id and tempuserdata.p_id = passout_year.p_id and tempuserdata.email_verify=1 and tempuserdata.p_id=mem.p_Id and tempuserdata.b_id=mem.b_Id and modr.m_Id=mem.m_Id and modr.m_Id = "
					+ i;
			String branch = "select tempuserdata.tempUID, tempuserdata.enr_no, tempuserdata.f_name, tempuserdata.l_name,tempuserdata.gender,tempuserdata.dob,tempuserdata.email_Id,branch.Branch_Name,passout_year.Passout_yr from tempuserdata,branch,passout_year where tempuserdata.b_Id = branch.b_Id and tempuserdata.p_id = passout_year.p_id and tempuserdata.email_verify=1 and tempUID in(select tempUID from tempuserdata t where((t.p_id,t.b_id)  not in (select p_Id,b_Id from members m,moderator o where m.m_Id = o.m_Id)) and ((t.p_id)  not in (select p_Id from members m,moderator o where m.m_Id = o.m_Id)) and (t.b_id = "
					+ j + "));";
			String passoutYr = "select tempuserdata.tempUID, tempuserdata.enr_no, tempuserdata.f_name, tempuserdata.l_name,tempuserdata.gender,tempuserdata.dob,tempuserdata.email_Id,branch.Branch_Name,passout_year.Passout_yr from tempuserdata,branch,passout_year where tempuserdata.b_Id = branch.b_Id and tempuserdata.p_id = passout_year.p_id and tempuserdata.email_verify=1 and tempUID in(select tempUID from tempuserdata t where((t.p_id,t.b_id) not in (select p_Id,b_Id from members m,moderator o where m.m_Id = o.m_Id ))	and ((t.b_id)  not in (select b_Id from members m,moderator o where m.m_Id = o.m_Id)) and (t.p_id = "
					+ k + "))";
			String noMod = "select tempuserdata.tempUID, tempuserdata.enr_no, tempuserdata.f_name, tempuserdata.l_name,tempuserdata.gender,tempuserdata.dob,tempuserdata.email_Id,branch.Branch_Name,passout_year.Passout_yr from tempuserdata,branch,passout_year where tempuserdata.b_Id = branch.b_Id and tempuserdata.p_id = passout_year.p_id and tempuserdata.email_verify=1 and tempUID in(select tempUID from tempuserdata t where((t.p_id,t.b_id)  not in (select p_Id,b_Id from members m,moderator o where m.m_Id = o.m_Id)) and ((t.p_id)  not in (select p_Id from members m,moderator o where m.m_Id = o.m_Id)) and ((t.b_id)  not in (select b_Id from members m,moderator o where m.m_Id = o.m_Id)));";

			System.out.println("class =>" + cls);
			System.out.println("Branch =>" + branch);
			System.out.println("Passout Year =>" + passoutYr);

			List<UserRequestBean> array = new ArrayList<UserRequestBean>();

			// Class
			rs = st.executeQuery(cls);
			UserRequestBean ub;
			// Branch
			rs1 = st1.executeQuery(branch);
			UserRequestBean ub1;
			// Passout Year
			rs2 = st2.executeQuery(passoutYr);
			UserRequestBean ub2;

			rs3 = st3.executeQuery(noMod);
			UserRequestBean ub3;

			int flag = 0;
			if (rs.next()) {

				do {
					ub = new UserRequestBean();
					int tempUID = rs.getInt(1);

					String Enno = rs.getString(2);
					String f_name = rs.getString(3);
					String L_name = rs.getString(4);
					String Gender = rs.getString(5);
					Date Dob = rs.getDate(6);
					String Email_id = rs.getString(7);
					String B_name = rs.getString(8);
					String P_year = rs.getString(9);

					ub.setTempUID(tempUID);
					ub.setEnr_no(Enno);
					ub.setF_name(f_name);
					ub.setL_name(L_name);
					ub.setGender(Gender);
					ub.setDob(Dob);
					ub.setEmail_id(Email_id);
					ub.setB_name(B_name);
					ub.setP_year(P_year);
					array.add(ub);
				} while (rs.next());
				flag = 1;
			}

			if (rs1.next()) {
				// Branch
				do {
					ub1 = new UserRequestBean();
					int tempUID = rs1.getInt(1);

					String Enno = rs1.getString(2);
					String f_name = rs1.getString(3);
					String L_name = rs1.getString(4);
					String Gender = rs1.getString(5);
					Date Dob = rs1.getDate(6);
					String Email_id = rs1.getString(7);
					String B_name = rs1.getString(8);
					String P_year = rs1.getString(9);

					ub1.setTempUID(tempUID);
					ub1.setEnr_no(Enno);
					ub1.setF_name(f_name);
					ub1.setL_name(L_name);
					ub1.setGender(Gender);
					ub1.setDob(Dob);
					ub1.setEmail_id(Email_id);
					ub1.setB_name(B_name);
					ub1.setP_year(P_year);
					array.add(ub1);
				} while (rs1.next());
				flag = 1;
			}

			if (rs2.next()) {
				// Passout Year
				do {
					ub2 = new UserRequestBean();
					int tempUID = rs2.getInt(1);
					String Enno = rs2.getString(2);
					String f_name = rs2.getString(3);
					String L_name = rs2.getString(4);
					String Gender = rs2.getString(5);
					Date Dob = rs2.getDate(6);
					String Email_id = rs2.getString(7);
					String B_name = rs2.getString(8);
					String P_year = rs2.getString(9);

					ub2.setTempUID(tempUID);
					ub2.setEnr_no(Enno);
					ub2.setF_name(f_name);
					ub2.setL_name(L_name);
					ub2.setGender(Gender);
					ub2.setDob(Dob);
					ub2.setEmail_id(Email_id);
					ub2.setB_name(B_name);
					ub2.setP_year(P_year);
					array.add(ub2);
				} while (rs2.next());
				flag = 1;
			}

			if (rs3.next()) {
				// Passout Year
				do {
					ub3 = new UserRequestBean();
					int tempUID = rs3.getInt(1);
					String Enno = rs3.getString(2);
					String f_name = rs3.getString(3);
					String L_name = rs3.getString(4);
					String Gender = rs3.getString(5);
					Date Dob = rs3.getDate(6);
					String Email_id = rs3.getString(7);
					String B_name = rs3.getString(8);
					String P_year = rs3.getString(9);

					ub3.setTempUID(tempUID);
					ub3.setEnr_no(Enno);
					ub3.setF_name(f_name);
					ub3.setL_name(L_name);
					ub3.setGender(Gender);
					ub3.setDob(Dob);
					ub3.setEmail_id(Email_id);
					ub3.setB_name(B_name);
					ub3.setP_year(P_year);
					array.add(ub3);
				} while (rs3.next());
				flag = 1;
			}

			if (flag == 1) {
				return array;
			} else {
				return null;
			}

		} finally {
			rs.close();
			rs1.close();
			rs2.close();
			rs3.close();

			ConnectionDAO.closeConnection(con);
		}

	}

	public void AcceptedUser(UserRequestBean bean) {

		Connection con = null;
		java.sql.Date sqldate = new java.sql.Date(bean.getDob().getTime());

		try {
			System.out.println("b_id = " + bean.getB_id());
			System.out.println("P_id = " + bean.getP_id());
			System.out.println("Enr_no = " + bean.getEnr_no());

			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO members(u_Id,pwd,f_name,l_name,dob,email_Id,enr_No,gender,b_Id,p_Id) VALUES(?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bean.getEmail_id());
			ps.setString(2, bean.getPassword());
			ps.setString(3, bean.getF_name());
			ps.setString(4, bean.getL_name());
			ps.setDate(5, sqldate);
			ps.setString(6, bean.getEmail_id());
			ps.setString(7, bean.getEnr_no());
			ps.setString(8, bean.getGender());

			ps.setInt(9, bean.getB_id());
			ps.setInt(10, bean.getP_id());

			int i = ps.executeUpdate();
			System.out.println(i);
			System.out.println(ps);

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int m_id = rs.getInt(1);

			PreparedStatement ps1 = con.prepareStatement("insert into edu_details (m_id,d_Id) values(?,4);");
			ps1.setInt(1, m_id);
			ps1.executeUpdate();

			PreparedStatement ps2 = con.prepareStatement("insert into edu_details(m_Id,d_Id) values(?,3);");
			ps2.setInt(1, m_id);
			ps2.executeUpdate();

			PreparedStatement ps3 = con.prepareStatement("insert into proff_details(m_Id) values(?)");
			ps3.setInt(1, m_id);
			ps3.executeUpdate();

			System.out.println(i);

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public void RejectedUsers(UserRequestBean bean) {
		Connection con = null;
		java.sql.Date sqldate = new java.sql.Date(bean.getDob().getTime());
		try {
			con = ConnectionDAO.getConnection();

			PreparedStatement ps = con.prepareStatement("INSERT INTO rejected_users VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, bean.getEnr_no());
			ps.setString(3, bean.getF_name());
			ps.setString(4, bean.getL_name());
			ps.setString(5, bean.getGender());
			ps.setDate(6, sqldate);
			ps.setString(7, bean.getEmail_id());
			ps.setInt(8, bean.getP_id());
			ps.setInt(9, bean.getB_id());
			ps.setInt(10, bean.getEmail_verify());

			int i = ps.executeUpdate();
			System.out.println(i);

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public void DelUsers(UserRequestBean bean) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM tempuserdata WHERE tempUID=?");
			ps.setInt(1, bean.getTempUID());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
