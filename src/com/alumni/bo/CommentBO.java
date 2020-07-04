package com.alumni.bo;

import java.sql.SQLException;
import com.alumni.dao.CommentDAO;

public class CommentBO {

	public void AddComments(String addcomment, String f_Id, int cr_id) throws SQLException {
		CommentDAO dao = new CommentDAO();
		dao.AddComments(addcomment, f_Id, cr_id);
	}

	public void LikeComment(int c_Id, int m_id) throws SQLException {
		CommentDAO dao = new CommentDAO();
		dao.LikeComment(c_Id, m_id);

	}

	public void deleteComment(int c_Id) throws SQLException {
		CommentDAO dao = new CommentDAO();
		dao.deleteComment(c_Id);
	}

}
