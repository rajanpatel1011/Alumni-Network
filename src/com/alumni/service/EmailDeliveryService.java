package com.alumni.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailDeliveryService {
	private final JavaMailSender mailSender;
	private final String fromAddress;

	public EmailDeliveryService(JavaMailSender mailSender,
			@Value("${alumni.email.from:${spring.mail.username:}}") String fromAddress) {
		this.mailSender = mailSender;
		this.fromAddress = fromAddress;
	}

	public void sendVerificationCode(String recipient, String code) throws MailException {
		if (fromAddress.isBlank()) {
			throw new MailSendException("Configure EMAIL_FROM or SPRING_MAIL_USERNAME before sending email.");
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(recipient);
		message.setSubject("Alumni Network");
		message.setText("Your Alumni Network email verification code is: " + code);
		mailSender.send(message);
	}
}
