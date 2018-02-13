package com.alumni.admin.bo;

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

import com.alumni.admin.beans.HelpandSupportBEAN;
import com.alumni.admin.dao.HelpandSupportDAO;
import com.alumni.beans.UserRequestBean;

public class HelpandSupportBO {

	
	
	public List<HelpandSupportBEAN> HelpandSupportDisplay() throws SQLException
	{
		HelpandSupportDAO DAO=new HelpandSupportDAO();
		List<HelpandSupportBEAN> bean=DAO.HelpandSupportDisplay();
		
		return bean;
		
		
	}
	public void deleteHelpandSupport(int h_id) throws SQLException
	{
		HelpandSupportDAO DAO=new HelpandSupportDAO();
		DAO.deleteHelpandSupport(h_id);
		
		
	}
	public String Email(String Email,String message1)
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
			InternetAddress.parse(Email));
			message.setSubject("Alumni Network");
			message.setText(message1);
			Transport.send(message);
			
			return "sent";
			
		} 
		
		catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
		
	}
}
