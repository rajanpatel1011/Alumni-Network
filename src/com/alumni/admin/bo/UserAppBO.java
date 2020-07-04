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

import com.alumni.admin.dao.UserAppDAO;
import com.alumni.admin.beans.UserAppBEAN;

public class UserAppBO {

	public List<UserAppBEAN> displayApp() throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		List<UserAppBEAN> bean = dao.displayListOfApp();
		return bean;
	}

	public void deleteApp(int u) throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		dao.deleteApp(u);
	}

	public void updateAppStatus(UserAppBEAN d) throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		dao.updateAppStatus(d);
	}

	public int getStatus(int doc) throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		return dao.getStatus(doc);
	}

	public int getmem(int doc) throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		return dao.getmem(doc);
	}

	public String getemail(int doc) throws SQLException {
		UserAppDAO dao = new UserAppDAO();
		return dao.getemail(doc);
	}

	public String EmailON(String Email) {

		final String Username = "alumninetwork83@gmail.com";
		final String Password = "cgpit123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Username, Password);
			}
		});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alumninetwork83@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
			message.setSubject("Alumni Network");
			message.setText("Your document is ready. Kindly collect it from administration.");
			Transport.send(message);

			return "sent";

		}

		catch (MessagingException e) {
			throw new RuntimeException(e);

		}

	}

	public String EmailOFF(String Email) {

		final String Username = "alumninetwork83@gmail.com";
		final String Password = "cgpit123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Username, Password);
			}
		});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alumninetwork83@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
			message.setSubject("Alumni Network");
			message.setText(
					"Your document request has been recieved. We will reply you back as soon as your document gets ready. ");
			Transport.send(message);

			return "sent";

		}

		catch (MessagingException e) {
			throw new RuntimeException(e);

		}

	}
}
