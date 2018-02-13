package com.alumni.bo;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.alumni.beans.UserRequestBean;
import com.alumni.dao.UsersRequestDAO;

import java.util.Random;
import java.security.SecureRandom;


public class UserRequestBO {

	/**
	 * @param k 
	 * @param j 
	 * @param i 
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<UserRequestBean> users(int i, int j, int k) throws ClassNotFoundException, SQLException 
	{
		
		UsersRequestDAO userRequestDAO=new UsersRequestDAO();
		List<UserRequestBean> userRequestBean=userRequestDAO.users(i,j,k);
		return userRequestBean;
	}
	
	 
	public  UserRequestBean usersInfo(int Tempid)
	{
		UsersRequestDAO DAO=new UsersRequestDAO();
		UserRequestBean ub=DAO.usersInfo(Tempid);
		return ub;
	} 
	
	public  UserRequestBean RandomPassword(char [] characterSet,int length,UserRequestBean bean)
	 {
	    Random random = new SecureRandom();
	    char[] result = new char[length];
	    for (int i = 0; i < result.length; i++) {
	        // picks a random index out of character set > random character
	        int randomCharIndex = random.nextInt(characterSet.length);
	        result[i] = characterSet[randomCharIndex];
	    }
	    bean.setPassword(new String(result));
	    return bean;
	}
	
	public String Email(UserRequestBean bean)
	{
		
		final String Username="alumninw@gmail.com";
		final String Password="cgpit123";
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Username, Password);
					}
				  });
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alumninw@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(bean.getEmail_id()));
			message.setSubject("Alumni Network");
			message.setText("Dear User Your Account is verified successfully!!"+"\n UserID:"+bean.getEmail_id()+"\nPassword:"+bean.getPassword().toString());
			Transport.send(message);
			
			return "message Sent successfully!";
			
		} 
		
		catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
		
	}
	
	public void AcceptedUsers(UserRequestBean bean)
	{
		
		UsersRequestDAO user=new UsersRequestDAO();
		user.AcceptedUser(bean);

	}
	public void RejectedUsers(UserRequestBean bean)
	{
		UsersRequestDAO user=new UsersRequestDAO();
		user.RejectedUsers(bean);
		
	}
	public void DelUsers(UserRequestBean bean)
	{
		UsersRequestDAO user=new UsersRequestDAO();
		user.DelUsers(bean);
		
	}
	
	
	
}

