package com.alumni.web;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.HtmlUtils;

import com.alumni.beans.EmailVerificationBEAN;
import com.alumni.beans.EmailVerificationCodeBEAN;
import com.alumni.bo.BranchDrpBO;
import com.alumni.bo.EmailVerificationBO;
import com.alumni.bo.EmailVerificationCodeBO;
import com.alumni.bo.PassoutYrDrpBO;

@Controller
public class RegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@GetMapping({"/signup", "/signup.jsp"})
	public String signup(Model model) {
		try {
			model.addAttribute("branches", new BranchDrpBO().branch());
			model.addAttribute("passoutYears", new PassoutYrDrpBO().p_years());
		} catch (ClassNotFoundException | SQLException exception) {
			logger.error("Registration options could not be loaded", exception);
			model.addAttribute("branches", List.of());
			model.addAttribute("passoutYears", List.of());
			model.addAttribute("loadError", "Registration options are temporarily unavailable.");
		}
		return "signup";
	}

	@GetMapping("/api/branches")
	@ResponseBody
	public List<Map<String, Object>> branches() {
		try {
			return new BranchDrpBO().branch().stream()
					.map(branch -> Map.<String, Object>of("id", branch.getBranchId(), "name", branch.getBranch()))
					.toList();
		} catch (ClassNotFoundException | SQLException exception) {
			logger.error("Branch options could not be loaded", exception);
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
					"Branch options are temporarily unavailable.", exception);
		}
	}

	@GetMapping("/api/passout-years")
	@ResponseBody
	public List<Map<String, Object>> passoutYears() {
		try {
			return new PassoutYrDrpBO().p_years().stream()
					.map(year -> Map.<String, Object>of("id", year.getPassOutYearId(), "name", year.getPassOutYear()))
					.toList();
		} catch (ClassNotFoundException | SQLException exception) {
			logger.error("Pass-out year options could not be loaded", exception);
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
					"Pass-out year options are temporarily unavailable.", exception);
		}
	}

	@PostMapping(value = "/EmailVerificationSERVLET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> requestVerification(
			@RequestParam String inputFname,
			@RequestParam String inputLname,
			@RequestParam String gender,
			@RequestParam String dob,
			@RequestParam String inputEmail,
			@RequestParam int inputPassyr,
			@RequestParam int branch,
			@RequestParam String inputEnrno) {
		EmailVerificationBEAN request = new EmailVerificationBEAN();
		if (inputFname.isBlank() || inputLname.isBlank() || inputEmail.isBlank() || inputEnrno.isBlank()
				|| inputPassyr <= 0 || branch <= 0 || (!gender.equals("m") && !gender.equals("f"))) {
			return ResponseEntity.badRequest().body(Map.of("message", "Enter valid registration details."));
		}
		try {
			request.setFname(inputFname.trim());
			request.setLname(inputLname.trim());
			request.setGender(gender);
			request.setDob(Date.valueOf(LocalDate.parse(dob)));
			request.setEmail(inputEmail.trim());
			request.setPassyrId(inputPassyr);
			request.setBranchId(branch);
			request.setEnrno(inputEnrno.trim());
		} catch (DateTimeParseException exception) {
			return ResponseEntity.badRequest().body(Map.of("message", "Enter valid registration details."));
		}

		try {
			EmailVerificationBEAN result = EmailVerificationBO.sendCode(request);
			if (result == null || !result.isSuccess() || !result.isNetwork()) {
				return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
						.body(Map.of("message", "A verification email could not be sent. Please try again later."));
			}
			return ResponseEntity.ok(Map.of("message", "A verification code has been sent to your email address."));
		} catch (ClassNotFoundException | SQLException | MessagingException exception) {
			logger.error("Email verification could not be started", exception);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
					.body(Map.of("message", "Email verification is temporarily unavailable."));
		}
	}

	@PostMapping(value = "/EmailVerificationCodeSERVLET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> verifyCode(@RequestParam String inputCode,
			@RequestParam String inputEmail) {
		if (inputCode.isBlank() || inputEmail.isBlank()) {
			return ResponseEntity.badRequest()
					.body(Map.of("verified", false, "message", "Enter your email and verification code."));
		}
		EmailVerificationCodeBEAN request = new EmailVerificationCodeBEAN();
		request.setCode(inputCode.trim());
		request.setEmail(inputEmail.trim());
		try {
			EmailVerificationCodeBEAN result = new EmailVerificationCodeBO().checkCode(request);
			boolean verified = result != null && result.getToken() != null;
			return ResponseEntity.ok(Map.of("verified", verified,
					"message", verified ? "Your registration request has been submitted."
							: "The verification code is not valid."));
		} catch (SQLException exception) {
			logger.error("Email verification code could not be checked", exception);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
					.body(Map.of("verified", false, "message", "Email verification is temporarily unavailable."));
		}
	}

	@PostMapping(value = "/BranchDrpSERVLET", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public ResponseEntity<String> legacyBranchOptions() {
		try {
			String options = new BranchDrpBO().branch().stream()
					.map(branch -> "<option value=\"" + branch.getBranchId() + "\">"
							+ HtmlUtils.htmlEscape(branch.getBranch()) + "</option>")
					.reduce("", String::concat);
			return ResponseEntity.ok(options);
		} catch (ClassNotFoundException | SQLException exception) {
			logger.error("Branch options could not be loaded", exception);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("null");
		}
	}

	@PostMapping(value = "/PassoutYrDrpSERVLET", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public ResponseEntity<String> legacyPassoutYearOptions() {
		try {
			String options = new PassoutYrDrpBO().p_years().stream()
					.map(year -> "<option value=\"" + year.getPassOutYearId() + "\">"
							+ HtmlUtils.htmlEscape(year.getPassOutYear()) + "</option>")
					.reduce("", String::concat);
			return ResponseEntity.ok(options);
		} catch (ClassNotFoundException | SQLException exception) {
			logger.error("Pass-out year options could not be loaded", exception);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("null");
		}
	}
}
