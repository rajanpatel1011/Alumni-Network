package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.alumni.beans.DeleteAlbumBEAN;

public class DeleteAlbumDAO {

	public List<DeleteAlbumBEAN> deleteAlbum(DeleteAlbumBEAN bean)
			throws ClassNotFoundException, SQLException /*
														 * Method to display List of all available users data in
														 * database name Tempuserdata
														 */
	{

		Connection con = null;

		try {

			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select picture_loc from photos where a_id=?");
			ps.setInt(1, bean.getA_id());
			ResultSet rs = ps.executeQuery();
			List<DeleteAlbumBEAN> array = new ArrayList<DeleteAlbumBEAN>();
			DeleteAlbumBEAN ub;
			if (rs.next()) {
				do {
					ub = new DeleteAlbumBEAN();
					String path = rs.getString(1);
					ub.setPic_path(path);
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

	public void deletePhotoPath(DeleteAlbumBEAN bean) {
		Connection con = null;

		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from photos where a_id=?;");
			ps.setInt(1, bean.getA_id());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			ConnectionDAO.closeConnection(con);
		}

	}

	public String selectAlbumpic(DeleteAlbumBEAN bean) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("Select upload_pic from album where a_id=?");
			ps.setInt(1, bean.getA_id());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String Album_picpath = rs.getString(1);
				return Album_picpath;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionDAO.closeConnection(con);
		}
		return null;

	}

	public void deleteAlbumPic(DeleteAlbumBEAN bean) {
		Connection con = null;
		try {
			con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from Album where a_id=?");
			ps.setInt(1, bean.getA_id());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionDAO.closeConnection(con);
		}
	}

}
