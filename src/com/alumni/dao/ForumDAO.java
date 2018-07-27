package com.alumni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alumni.beans.CommentBEAN;
import com.alumni.beans.ForumBean;
// import com.alumni.beans.PassoutYrDrpBEAN; --------------------------PENDING jhj



public class ForumDAO {

	// ---------------------------------- Method for fetching forums from db------------STARTS----------
	
	public List<ForumBean> forum(int batch_id,int passout_id, int m_Id) throws ClassNotFoundException, SQLException,ParseException
	//public List<ForumBean> forum() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		try
		{
			con = ConnectionDAO.getConnection();

			String s = "SELECT forum.*,members.f_name,members.l_name,permision.perm_Name,(select count(c_Id) as noCmt from `comment` where f_Id=forum.f_Id),p.m_Id FROM members,permision,forum LEFT JOIN pinned_forum p ON (p.m_Id="+m_Id+" and p.f_Id=forum.f_Id) where (forum.creator_id=members.m_id) and (forum.perm_Id=permision.perm_Id) and (forum.delete_flag=0) and ((forum.perm_Id=1) or (forum.perm_Id=2 and p_Id=? and b_Id=?) or (forum.perm_Id=3 and p_Id=?) or (forum.perm_Id=4 and b_Id=?)) Order By forum.f_Id DESC;";
			String s10 = "SELECT forum.*,members.f_name,members.l_name,permision.perm_Name,(select count(c_Id) as noCmt from `comment` where f_Id=forum.f_Id) FROM forum,members,permision,pinned_forum p where (forum.creator_id=members.m_id) and (p.f_Id=forum.f_Id) and (forum.perm_Id=permision.perm_Id) and (forum.delete_flag=0) and ((forum.perm_Id=1) or (forum.perm_Id=2 and p_Id=? and b_Id=?) or (forum.perm_Id=3 and p_Id=?) or (forum.perm_Id=4 and b_Id=?)) and p.m_Id=? Order By p.f_Id DESC; ";
			
			List<ForumBean> array = null;
			ArrayList<CommentBEAN> cmtArray = null;
			ForumBean fb;
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			
			PreparedStatement ps10 = con.prepareStatement(s10);
			ps10.setInt(1, passout_id);
			ps10.setInt(2,batch_id);
			ps10.setInt(3, passout_id);
			ps10.setInt(4,batch_id);
			ps10.setInt(5,m_Id);
			System.out.println("string query = "+ps10);
			ResultSet rs10 = ps10.executeQuery();
			
			int flag=0;
			array = new ArrayList<ForumBean>();
			
			
			if(rs10.next())
			{
				
				do{
					
					fb = new ForumBean();
					fb.setF_id(rs10.getInt(1));
					fb.setP_sub(rs10.getString(2));
					fb.setPerm_id(rs10.getInt(3));
					fb.setCreator_id(rs10.getInt(4));
					fb.setDate_time(fmt.parse(rs10.getString(5)));
					fb.setReciver_id(rs10.getInt(6));
					fb.setNo_Of_cmt(rs10.getInt(14));
					fb.setDesription(rs10.getString(8));
					fb.setPinned_flag(rs10.getInt(9));
					fb.setDelete_flag(rs10.getInt(10));
					fb.setF_name(rs10.getString(11));
					fb.setL_name(rs10.getString(12));
					fb.setPerm_name(rs10.getString(13));
					fb.setPinned(true);
					//Comment ==============================
					cmtArray = new ArrayList<CommentBEAN>();
					
					String st = "SELECT m.f_name,m.l_name,c.c_Id,c.f_Id,c.cmt_data,c.m_Id,c.date_time,c.rate FROM `comment` c,members m where m.m_Id=c.m_Id and c.f_Id = ?;";
					PreparedStatement ps1 = con.prepareStatement(st);
					ps1.setInt(1,rs10.getInt(1));					
					ResultSet rs1 = ps1.executeQuery();
					
					CommentBEAN cb;
					if(rs1.next())
					{
						do{		
								
									cb = new CommentBEAN();
									cb.setFname(rs1.getString(1));
									cb.setLname(rs1.getString(2));
									cb.setC_Id(rs1.getInt(3));
									cb.setF_Id(rs1.getInt(4));
									cb.setCmt_Data(rs1.getString(5));									
									cb.setCreator_Id(rs1.getInt(6));
									cb.setCreated_DateTime(fmt.parse(rs1.getString(7)));
									cb.setRate(rs1.getInt(8));
									
									String stcmt1="select * from ratecmt where cmt_Id=? and m_Id=?";
									PreparedStatement pscmt2 = con.prepareStatement(stcmt1);
									pscmt2.setInt(1, cb.getC_Id());
									pscmt2.setInt(2, m_Id);
									ResultSet rscmt2 = pscmt2.executeQuery();
									if(rscmt2.next()){
										cb.setLiked(true);
									}else{
										cb.setLiked(false);
									}
									cmtArray.add(cb);
								}while(rs1.next());
						
					}
					
					
					fb.setCommentList(cmtArray);
					array.add(fb);
					
				}while(rs10.next());
				flag=1;
			}
			
			
			
			//=========sdfsdfdsf===============
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, passout_id);
			ps.setInt(2,batch_id);
			ps.setInt(3, passout_id);
			ps.setInt(4,batch_id);
			System.out.println("string query sfdfd = "+ps);
			ResultSet rs = ps.executeQuery();
			
						
		
			if(rs.next())
			{
				
				do{
					if(rs.getInt(15) != m_Id){			
					fb = new ForumBean();
					fb.setF_id(rs.getInt(1));
					fb.setP_sub(rs.getString(2));
					fb.setPerm_id(rs.getInt(3));
					fb.setCreator_id(rs.getInt(4));
					fb.setDate_time(fmt.parse(rs.getString(5)));
					fb.setReciver_id(rs.getInt(6));
					fb.setNo_Of_cmt(rs.getInt(14));
					fb.setDesription(rs.getString(8));
					fb.setPinned_flag(rs.getInt(9));
					fb.setDelete_flag(rs.getInt(10));
					fb.setF_name(rs.getString(11));
					fb.setL_name(rs.getString(12));
					fb.setPerm_name(rs.getString(13));
					fb.setPinned(false);
					
					//Comment ==============================
					cmtArray = new ArrayList<CommentBEAN>();
					String sto = "SELECT m.f_name,m.l_name,c.c_Id,c.f_Id,c.cmt_data,c.m_Id,c.date_time,c.rate FROM `comment` c,members m where m.m_Id=c.m_Id and c.f_Id = ?;";
					PreparedStatement ps11 = con.prepareStatement(sto);
					ps11.setInt(1,rs.getInt(1));					
					ResultSet rs11 = ps11.executeQuery();
					
					CommentBEAN cb;
					if(rs11.next())
					{
						do{		
								
									cb = new CommentBEAN();
									
									cb.setFname(rs11.getString(1));
									cb.setLname(rs11.getString(2));
									cb.setC_Id(rs11.getInt(3));
									cb.setF_Id(rs11.getInt(4));
									cb.setCmt_Data(rs11.getString(5));									
									cb.setCreator_Id(rs11.getInt(6));
									cb.setCreated_DateTime(fmt.parse(rs11.getString(7)));
									cb.setRate(rs11.getInt(8));
									
									String stcmt12="select * from ratecmt where cmt_Id=? and m_Id=?";
									PreparedStatement pscmt12 = con.prepareStatement(stcmt12);
									pscmt12.setInt(1, cb.getC_Id());
									pscmt12.setInt(2, m_Id);
									ResultSet rscmt12 = pscmt12.executeQuery();
									if(rscmt12.next()){
										cb.setLiked(true);
									}else{
										cb.setLiked(false);
									}
									cmtArray.add(cb);
								}while(rs11.next());
						
					}
					
					
					fb.setCommentList(cmtArray);
					array.add(fb);
					}
				}while(rs.next());
				flag = 1;
				
			}
			
			if(flag==1){
				return array;
			}
			else
				{
				return null;
				}
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
		
	}
	//---------------------------------- Method for fetching forums from db------------ENDS----------
	
	
	
	
	//---------------------------------- Method for creating forum---------STARTS-------------
	
	
	public void forumCreate(ForumBean fb) throws ClassNotFoundException,SQLException
	{
		Connection con = null;
		
		try
		{
			con = ConnectionDAO.getConnection();

			System.out.print("\n In forumCreate() ForumDAO! \n");
			PreparedStatement ps = con.prepareStatement("insert into forum(p_sub,desription,perm_Id,creator_id,date_time) values(?,?,?,?,now());");
			ps.setString(1,fb.getP_sub());
			ps.setString(2,fb.getDesription());
			ps.setInt(3,fb.getPerm_id());
			ps.setInt(4,fb.getCreator_id()); // ----------------------- Creator id need to be fetch from SESSION.java
			ps.executeUpdate();
			
			
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
	}
	
	//---------------------------------- Method for creating forum---------ENDS-------------
	
	
	
	
	// ----------------------------Method for viewing individual Forum Posts ------------------------STARTS---------------------
	
	public ForumBean forumPost(int forum_id,int batch_id,int passout_id) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		
		try
		{
			con = ConnectionDAO.getConnection();

			String s = "SELECT forum.*,members.f_name,members.l_name,permision.perm_Name FROM aumninw.forum,aumninw.members,aumninw.permision where (forum.creator_id=members.m_id) and (forum.perm_Id=permision.perm_Id) and (forum.delete_flag=0) and (forum.f_id=?) and ((forum.perm_Id=1) or (forum.perm_Id=2 and p_Id=? and b_Id=?) or (forum.perm_Id=3 and p_Id=?) or (forum.perm_Id=4 and b_Id=?));";
			
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1,forum_id);
			ps.setInt(2,passout_id);
			ps.setInt(3,batch_id);
			ps.setInt(4,passout_id);
			ps.setInt(5,batch_id);
			
			ResultSet rs = ps.executeQuery();
			
			ForumBean fb;
		
			if(rs.next())
			{
				
				do{
					fb = new ForumBean();
					System.out.print("In Forum POST DAO!");
					fb.setF_id(rs.getInt(1));
					fb.setP_sub(rs.getString(2));
					fb.setPerm_id(rs.getInt(3));
					fb.setCreator_id(rs.getInt(4));
					fb.setDate_time(rs.getDate(5));
					fb.setReciver_id(rs.getInt(6));
					fb.setNo_Of_cmt(rs.getInt(7));
					fb.setDesription(rs.getString(8));
					fb.setPinned_flag(rs.getInt(9));
					fb.setDelete_flag(rs.getInt(10));
					fb.setF_name(rs.getString(11));
					fb.setL_name(rs.getString(12));
					fb.setPerm_name(rs.getString(13));
					System.out.print(fb.getF_id()+" "+fb.getF_name());
					
				}while(rs.next());
				return fb;
			}
			else
				{
				return null;
				}
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}
		
	}
	
	
	//---------------------------- Method for viewing individual Forum Posts------------------------ENDS-----------------

	
	
	
	
	
	//---------------------------- Method for DELETE  Forum Posts------------------------STARTS-----------------
	
	public void forumDelete(int forum_id,int member_id) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		
		try
		{
			con = ConnectionDAO.getConnection();

			//String s = "DELETE FROM forum WHERE (f_id=? AND creator_id=?);";
			String s = "update forum set delete_flag=1 where (f_id=? AND creator_id=?);";
			
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1,forum_id);
			ps.setInt(2,member_id);
			ps.executeUpdate();
			
		}
		finally 
		{
			ConnectionDAO.closeConnection(con);
		}

		
	}




	public void FavForum(int f_Id, int m_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		
		con=ConnectionDAO.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into pinned_forum(f_Id,m_Id) values(?,?)");
		ps.setInt(1,f_Id);
		ps.setInt(2,m_id);
		ps.executeUpdate();
		
	}




	public void remFavForum(int f_Id, int m_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		
		con=ConnectionDAO.getConnection();
		
		PreparedStatement ps = con.prepareStatement("delete from pinned_forum where f_Id=? and m_Id=?");
		ps.setInt(1,f_Id);
		ps.setInt(2,m_id);
		ps.executeUpdate();
	}
	
	//---------------------------- Method for DELETE  Forum Posts------------------------ENDS-----------------
	
	
}