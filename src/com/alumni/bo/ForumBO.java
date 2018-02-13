package com.alumni.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.alumni.beans.ForumBean;
import com.alumni.dao.ForumDAO;


public class ForumBO {
	
	
	// For viewing FORUM to user
	public List<ForumBean> forum(int batch_id,int passout_id, int m_Id) throws ClassNotFoundException, SQLException, ParseException
	//public List<ForumBean> forum() throws ClassNotFoundException, SQLException
	{
		
		ForumDAO fdao = new ForumDAO();
		List<ForumBean> fb = fdao.forum(batch_id,passout_id,m_Id);
		return fb;		
	}

	// For creating new thread in FORUM
	public void createForum(ForumBean fb) throws ClassNotFoundException, SQLException
	{
		ForumDAO fdao = new ForumDAO();
		fdao.forumCreate(fb);
		
		
	}
	
	public ForumBean forumPost(int forum_id,int batch_id,int passout_id) throws ClassNotFoundException, SQLException
	//public List<ForumBean> forum() throws ClassNotFoundException, SQLException
	{
		System.out.print("In Forum POST BO!");
		ForumDAO fdao = new ForumDAO();
		ForumBean fb = fdao.forumPost(forum_id,batch_id,passout_id);
		return fb;		
	}
	
	
	public void forumDelete(int forum_id,int member_id) throws ClassNotFoundException, SQLException
	{
		System.out.print("In forumDelete");
		ForumDAO fdao = new ForumDAO();
		fdao.forumDelete(forum_id, member_id);
		
	}

	public void FavForum(int f_Id, int m_id) throws SQLException {
		// TODO Auto-generated method stub
		ForumDAO  dao = new ForumDAO();
		dao.FavForum(f_Id,m_id);
		
	}

	public void remFavForum(int f_Id, int m_id) throws SQLException {
		// TODO Auto-generated method stub
		ForumDAO  dao = new ForumDAO();
		dao.remFavForum(f_Id,m_id);
	}
	
}
