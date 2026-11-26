package com.alumni.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mail.MailSendException;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.beans.EmailVerificationCodeBEAN;
import com.alumni.beans.LoginBEAN;
import com.alumni.bo.BranchDrpBO;
import com.alumni.bo.EmailVerificationBO;
import com.alumni.bo.EmailVerificationCodeBO;
import com.alumni.bo.LoginBO;
import com.alumni.bo.PassoutYrDrpBO;

@SpringBootTest
@AutoConfigureMockMvc
class PublicAuthenticationFlowTests {
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private EmailVerificationBO emailVerificationBO;

	@Test
	void publicTemplatesRender() throws Exception {
		try (var branches = mockConstruction(BranchDrpBO.class,
				(mock, context) -> when(mock.branch()).thenReturn(List.of()));
				var years = mockConstruction(PassoutYrDrpBO.class,
						(mock, context) -> when(mock.p_years()).thenReturn(List.of()))) {
			mockMvc.perform(get("/"))
					.andExpect(status().isOk())
					.andExpect(view().name("home"))
					.andExpect(content().string(org.hamcrest.Matchers.containsString("Alumni Network")));

			mockMvc.perform(get("/login"))
					.andExpect(status().isOk())
					.andExpect(view().name("login"))
					.andExpect(content().string(org.hamcrest.Matchers.containsString("Log in")));

			mockMvc.perform(get("/signup"))
					.andExpect(status().isOk())
					.andExpect(view().name("signup"))
					.andExpect(content().string(org.hamcrest.Matchers.containsString("Join the Alumni Network")));
		}
	}

	@Test
	void successfulLoginCreatesSessionAndRedirectsHome() throws Exception {
		LoginBEAN user = new LoginBEAN();
		user.setUserName("alumni-user");
		user.setRole(0);

		try (var login = mockConstruction(LoginBO.class,
				(mock, context) -> when(mock.login(anyString(), anyString())).thenReturn(user))) {
			mockMvc.perform(post("/login").param("uid", "alumni-user").param("pwd", "password"))
					.andExpect(status().is3xxRedirection())
					.andExpect(redirectedUrl("/"))
					.andExpect(request().sessionAttribute("loginBEAN", user));
		}
	}

	@Test
	void failedLoginRendersErrorWithoutCreatingSession() throws Exception {
		try (var login = mockConstruction(LoginBO.class,
				(mock, context) -> when(mock.login(anyString(), anyString())).thenReturn(null))) {
			mockMvc.perform(post("/login").param("uid", "unknown").param("pwd", "wrong"))
					.andExpect(status().isOk())
					.andExpect(view().name("login"))
					.andExpect(content().string(org.hamcrest.Matchers.containsString("Invalid username or password.")))
					.andExpect(request().sessionAttributeDoesNotExist("loginBEAN"));
		}
	}

	@Test
	void blankLoginIsRejectedBeforeCallingBusinessLogic() throws Exception {
		try (var logins = mockConstruction(LoginBO.class)) {
			mockMvc.perform(post("/login").param("uid", " ").param("pwd", "password"))
					.andExpect(status().isOk())
					.andExpect(view().name("login"))
					.andExpect(content().string(org.hamcrest.Matchers.containsString("Enter your username and password.")));

			org.junit.jupiter.api.Assertions.assertTrue(logins.constructed().isEmpty());
		}
	}

	@Test
	void logoutInvalidatesAuthenticatedSession() throws Exception {
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("loginBEAN", new LoginBEAN());

		mockMvc.perform(post("/logout").session(session))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));

		org.junit.jupiter.api.Assertions.assertTrue(session.isInvalid());
	}

	@Test
	void invalidRegistrationDetailsAreRejectedWithoutSendingEmail() throws Exception {
		mockMvc.perform(post("/EmailVerificationSERVLET")
				.param("inputFname", "A")
				.param("inputLname", "User")
				.param("gender", "invalid")
				.param("dob", "2000-01-01")
				.param("inputEmail", "a@example.com")
				.param("inputPassyr", "1")
				.param("branch", "1")
				.param("inputEnrno", "123"))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Enter valid registration details.")));

		verify(emailVerificationBO, org.mockito.Mockito.never()).sendCode(any(EmailVerificationBEAN.class));
	}

	@Test
	void invalidVerificationDateIsRejected() throws Exception {
		mockMvc.perform(post("/EmailVerificationSERVLET")
				.param("inputFname", "A")
				.param("inputLname", "User")
				.param("gender", "m")
				.param("dob", "not-a-date")
				.param("inputEmail", "a@example.com")
				.param("inputPassyr", "1")
				.param("branch", "1")
				.param("inputEnrno", "123"))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Enter valid registration details.")));
	}

	@Test
	void successfulVerificationCodeRequestReturnsConfirmation() throws Exception {
		EmailVerificationBEAN sent = new EmailVerificationBEAN();
		sent.setSuccess(true);
		sent.setNetwork(true);

		when(emailVerificationBO.sendCode(any(EmailVerificationBEAN.class))).thenReturn(sent);

		mockMvc.perform(post("/EmailVerificationSERVLET")
				.param("inputFname", "A")
				.param("inputLname", "User")
				.param("gender", "m")
				.param("dob", "2000-01-01")
				.param("inputEmail", "a@example.com")
				.param("inputPassyr", "1")
				.param("branch", "1")
				.param("inputEnrno", "123"))
				.andExpect(status().isOk())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("A verification code has been sent")));
	}

	@Test
	void mailDeliveryFailureReturnsServiceUnavailable() throws Exception {
		when(emailVerificationBO.sendCode(any(EmailVerificationBEAN.class)))
				.thenThrow(new MailSendException("mail service unavailable"));

		mockMvc.perform(post("/EmailVerificationSERVLET")
				.param("inputFname", "A")
				.param("inputLname", "User")
				.param("gender", "m")
				.param("dob", "2000-01-01")
				.param("inputEmail", "a@example.com")
				.param("inputPassyr", "1")
				.param("branch", "1")
				.param("inputEnrno", "123"))
				.andExpect(status().isServiceUnavailable())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("Email verification is temporarily unavailable.")));
	}

	@Test
	void verificationCodeSuccessAndFailureAreReported() throws Exception {
		EmailVerificationCodeBEAN verified = new EmailVerificationCodeBEAN();
		verified.setToken("verification-token");
		EmailVerificationCodeBEAN rejected = new EmailVerificationCodeBEAN();

		try (var codes = mockConstruction(EmailVerificationCodeBO.class,
				(mock, context) -> when(mock.checkCode(any(EmailVerificationCodeBEAN.class))).thenReturn(verified))) {
			mockMvc.perform(post("/EmailVerificationCodeSERVLET")
					.param("inputCode", "ABC123")
					.param("inputEmail", "a@example.com"))
					.andExpect(status().isOk())
					.andExpect(content().string(org.hamcrest.Matchers.containsString("\"verified\":true")));
		}

		try (var codes = mockConstruction(EmailVerificationCodeBO.class,
				(mock, context) -> when(mock.checkCode(any(EmailVerificationCodeBEAN.class))).thenReturn(rejected))) {
			mockMvc.perform(post("/EmailVerificationCodeSERVLET")
					.param("inputCode", "BAD000")
					.param("inputEmail", "a@example.com"))
					.andExpect(status().isOk())
					.andExpect(content().string(org.hamcrest.Matchers.containsString("\"verified\":false")));
		}
	}
}
