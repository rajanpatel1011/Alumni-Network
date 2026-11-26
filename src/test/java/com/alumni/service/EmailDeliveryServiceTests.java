package com.alumni.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

class EmailDeliveryServiceTests {
	@Test
	void sendsVerificationMessageUsingConfiguredSenderAddress() {
		JavaMailSender mailSender = mock(JavaMailSender.class);
		EmailDeliveryService service = new EmailDeliveryService(mailSender, "alumni@example.com");

		service.sendVerificationCode("student@example.com", "A1B2C3");

		var message = org.mockito.ArgumentCaptor.forClass(SimpleMailMessage.class);
		verify(mailSender).send(message.capture());
		assertEquals("alumni@example.com", message.getValue().getFrom());
		assertEquals("student@example.com", message.getValue().getTo()[0]);
		assertEquals("Alumni Network", message.getValue().getSubject());
		assertEquals("Your Alumni Network email verification code is: A1B2C3", message.getValue().getText());
	}

	@Test
	void rejectsMissingSenderAddressWithoutSending() {
		JavaMailSender mailSender = mock(JavaMailSender.class);
		EmailDeliveryService service = new EmailDeliveryService(mailSender, " ");

		assertThrows(MailSendException.class, () -> service.sendVerificationCode("student@example.com", "A1B2C3"));
		verify(mailSender, org.mockito.Mockito.never()).send(any(SimpleMailMessage.class));
	}
}
