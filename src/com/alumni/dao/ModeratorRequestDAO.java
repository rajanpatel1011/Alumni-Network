package com.alumni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.alumni.beans.ModeratorRequestBean;
import java.sql.PreparedStatement;

public class ModeratorRequestDAO {

	public List<ModeratorRequestBean> users()
			throws ClassNotFoundException, SQLException /*
														 * Method to display List of all available users data in
														 * database name Tempuserdata
														 */
	{

		Connection con = null;

		try {

			con = ConnectionDAO.getConnection();
			String s = "SElECT modrequest.*,members.f_name,members.l_name,members.gender,members.dob,members.email_Id,members.enr_No,members.b_Id,members.p_Id,branch.Branch_Name,passout_year.Passout_yr FROM modrequest INNER JOIN members ON modrequest.m_id=members.m_Id INNER JOIN branch ON  members.b_Id = branch.b_Id INNER JOIN  passout_year ON members.p_id = passout_year.p_id AND members.b_Id = branch.b_Id; ";
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(s);
			ResultSet rs = ps1.executeQuery();

			List<ModeratorRequestBean> array = new ArrayList<ModeratorRequestBean>();
			ModeratorRequestBean ub;
			if (rs.next()) {
				do {
					ub = new ModeratorRequestBean();
					int R_id = rs.getInt(1);
					int m_id = rs.getInt(2);
					int Mod_id1 = rs.getInt(3);
					int Mod_id2 = rs.getInt(4);
					String F_name = rs.getString(5);
					String L_name = rs.getString(6);
					String Gender = rs.getString(7);
					Date dob = rs.getDate(8);
					String email = rs.getString(9);
					String enrno = rs.getString(10);
					int b_id = rs.getInt(11);
					int p_id = rs.getInt(12);
					String B_name = rs.getString(13);
					String P_year = rs.getString(14);
					ub.setR_Id(R_id);
					ub.setF_name(F_name);
					ub.setL_name(L_name);
					ub.setGender(Gender);
					ub.setDob(dob);
					ub.setEmail_Id(email);
					ub.setB_Id(b_id);
					ub.setB_name(B_name);
					ub.setP_Id(p_id);
					ub.setP_name(P_year);
					ub.setEnr_No(enrno);
					ub.setM_id(m_id);
					ub.setMod_Id1(Mod_id1);
					ub.setMod_Id2(Mod_id2);
					String s1 = "select members.f_name  from members INNER JOIN moderator ON moderator.m_Id=members.m_Id WHERE moderator.mod_Id=?;";
					PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(s1);
					ps2.setInt(1, Mod_id1);
					ResultSet rs1 = ps2.executeQuery();
					while (rs1.next()) {
						String Mod1_name = rs1.getString(1);
						ub.setMod1_name(Mod1_name);
					}
					String s2 = "select members.f_name  from members INNER JOIN moderator ON moderator.m_Id=members.m_Id WHERE moderator.mod_Id=?;";
					PreparedStatement ps3 = (PreparedStatement) con.prepareStatement(s2);
					ps3.setInt(1, Mod_id2);
					ResultSet rs2 = ps3.executeQuery();
					while (rs2.next()) {
						String Mod2_name = rs2.getString(1);
						ub.setMod2_name(Mod2_name);
					}
					array.add(ub);
				} while (rs.next());

				return array;
			} else {
				return new ArrayList<>();
			}

		}

		finally {

			ConnectionDAO.closeConnection(con);
		}

	}

	public ModeratorRequestBean userinfo(int R_Id) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			String s1 = "Select * from modrequest where R_Id=?;";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s1);
			ps.setInt(1, R_Id);
			ResultSet rs = ps.executeQuery();
			ModeratorRequestBean mb = new ModeratorRequestBean();
			while (rs.next()) {
				mb.setR_Id(rs.getInt(1));
				mb.setM_id(rs.getInt(2));
				mb.setMod_Id1(rs.getInt(3));
				mb.setMod_Id2(rs.getInt(4));
				return mb;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;
	}

	public void RejectedModRequest(ModeratorRequestBean bean) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			String s = "DELETE FROM modrequest WHERE R_Id=?;";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, bean.getR_Id());
			ps.executeUpdate();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}

	}

	public ModeratorRequestBean selectedAsMod(int m_id) {
		Connection con = null;
		ModeratorRequestBean bean = new ModeratorRequestBean();

		try {
			con = ConnectionDAO.getConnection();
			String s = "select mod_Id FROM moderator WHERE m_Id=?;";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, m_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setMod_Id1(rs.getInt(1));
				return bean;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public ModeratorRequestBean mod1vote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			String s = "UPDATE modrequest SET mod_Id1=? WHERE R_Id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, bean.getMod_Id1());
			ps.setInt(2, selectUserBean.getR_Id());
			ps.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public ModeratorRequestBean mod2vote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			String s = "UPDATE modrequest SET mod_Id2=? WHERE R_Id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, bean.getMod_Id1());
			ps.setInt(2, selectUserBean.getR_Id());
			ps.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public ModeratorRequestBean checkvote(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			String s = "SELECT count(*) FROM modrequest WHERE mod_id1=? AND R_ID=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, bean.getMod_Id1());
			ps.setInt(2, selectUserBean.getR_Id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setCheckSelction(rs.getInt(1));
				return bean;

			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public ModeratorRequestBean checkvote2(ModeratorRequestBean bean, ModeratorRequestBean selectUserBean) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			String s = "SELECT count(*) FROM modrequest WHERE mod_id2=? AND R_ID=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, bean.getMod_Id1());
			ps.setInt(2, selectUserBean.getR_Id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setCheckSelction(rs.getInt(1));
				return bean;

			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public void UserGrantedAsMod(ModeratorRequestBean selectUserBean2) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			String s = "UPDATE members SET acc_type=1 WHERE m_Id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, selectUserBean2.getM_id());
			ps.executeUpdate();
			String s2 = "INSERT INTO moderator values(?,?)";
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(s2);
			ps1.setString(1, null);
			ps1.setInt(2, selectUserBean2.getM_id());
			ps1.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
	}

	public int AcceptByTwo(ModeratorRequestBean selectUserBean1) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			String s = "SELECT COUNT(Mod_id1 AND MOD_id2) FROM Modrequest WHERE R_Id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setInt(1, selectUserBean1.getR_Id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int flag1 = rs.getInt(1);
				return flag1;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			ConnectionDAO.closeConnection(con);
		}
		return 0;

	}

}
