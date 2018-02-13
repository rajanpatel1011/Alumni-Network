package com.alumni.bo;

import java.sql.SQLException;
import java.util.List;
import com.alumni.beans.PhotoUploadBean;
import com.alumni.dao.PhotoUploadDAO;;

public class PhotoUploadBO {
	
public void PhotoUpload(PhotoUploadBean bean) 
{
	
	PhotoUploadDAO DAO=new PhotoUploadDAO();
	DAO.uploadAlbum(bean);
	
}

public List<PhotoUploadBean> view(int p_id, int b_id,int a_id) throws ClassNotFoundException, SQLException /* Method to display List of all available users data in database name Tempuserdata  */
{
	PhotoUploadDAO DAO=new PhotoUploadDAO();
	List<PhotoUploadBean> view=DAO.view(p_id, b_id, a_id);
	return view;
}

}