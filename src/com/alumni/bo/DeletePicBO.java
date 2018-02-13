package com.alumni.bo;

import java.sql.SQLException;

import com.alumni.dao.DeletePicDAO;
import com.alumni.beans.PhotoUploadBean;

public class DeletePicBO {
	
	public void deletePhoto(PhotoUploadBean bean)throws SQLException{
		DeletePicDAO dao = new DeletePicDAO();
		dao.delectPhoto(bean);
		
	}

	public String SelectPhoto(PhotoUploadBean bean)throws SQLException{
		DeletePicDAO dao = new DeletePicDAO();
		String s=dao.selectPhoto(bean);
		return s;
		
		
	}

}
