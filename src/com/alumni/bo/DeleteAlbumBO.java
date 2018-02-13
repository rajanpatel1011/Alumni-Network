package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;

import com.alumni.beans.DeleteAlbumBEAN;
import com.alumni.dao.DeleteAlbumDAO;


public class DeleteAlbumBO {
	public List<DeleteAlbumBEAN> DeleteAlbum(DeleteAlbumBEAN bean) throws ClassNotFoundException, SQLException 
	{
		
		DeleteAlbumDAO DAO=new DeleteAlbumDAO();
		List<DeleteAlbumBEAN> DeleteAlbumBEAN=DAO.deleteAlbum(bean);
		return DeleteAlbumBEAN;
	}
	
	public void deletepic(DeleteAlbumBEAN bean)
	{
		DeleteAlbumDAO dao=new DeleteAlbumDAO();
		dao.deletePhotoPath(bean);
		
	}
	
	public String selectImagepath(DeleteAlbumBEAN bean)
	{
		DeleteAlbumDAO DAO=new DeleteAlbumDAO();
		String albumPath=DAO.selectAlbumpic(bean);
		return albumPath;
	}
	
	public void deletealbum(DeleteAlbumBEAN bean)
	{
		DeleteAlbumDAO DAO=new DeleteAlbumDAO();
		DAO.deleteAlbumPic(bean);
		
	}
	

}
