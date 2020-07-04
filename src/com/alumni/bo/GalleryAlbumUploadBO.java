package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;
import com.alumni.beans.GalleryAlbumUploadBEAN;
import com.alumni.dao.GalleryAlbumUploadDAO;

public class GalleryAlbumUploadBO {

	public void uploadAlbum(GalleryAlbumUploadBEAN bean) {

		GalleryAlbumUploadDAO DAO = new GalleryAlbumUploadDAO();
		DAO.uploadAlbum(bean);

	}

	public List<GalleryAlbumUploadBEAN> view(int p_id, int b_id) throws ClassNotFoundException, SQLException
	/*
	 * Method to display List of all available users data in database name
	 * Tempuserdata
	 */
	{
		GalleryAlbumUploadDAO DAO = new GalleryAlbumUploadDAO();
		List<GalleryAlbumUploadBEAN> view = DAO.view(p_id, b_id);
		return view;

	}

}
