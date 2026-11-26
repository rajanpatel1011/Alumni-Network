package com.alumni.web;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.alumni.beans.LoginBEAN;
import com.alumni.bo.LoginBO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping({"/login", "/login.jsp", "/Login"})
	public String loginPage(@RequestParam(required = false) Integer validation, Model model) {
		if (validation != null && validation == 1) {
			model.addAttribute("error", "Invalid username or password.");
		} else if (validation != null && validation == 2) {
			model.addAttribute("error", "The service is temporarily unavailable. Please try again.");
		}
		return "login";
	}

	@PostMapping({"/login", "/Login"})
	public String authenticate(@RequestParam(name = "uid", required = false) String userId,
			@RequestParam(name = "pwd", required = false) String password,
			HttpSession session, Model model) {
		if (userId == null || userId.isBlank() || password == null || password.isBlank()) {
			model.addAttribute("error", "Enter your username and password.");
			return "login";
		}

		try {
			LoginBEAN user = new LoginBO().login(userId, password);
			if (user == null || (user.getRole() != 0 && user.getRole() != 1)) {
				model.addAttribute("error", "Invalid username or password.");
				return "login";
			}
			session.setAttribute("loginBEAN", user);
			return "redirect:/";
		} catch (SQLException exception) {
			logger.error("Login could not be completed", exception);
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
					"Login is temporarily unavailable. Please try again.", exception);
		}
	}

	@PostMapping({"/logout", "/LogoutSERVLET"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/LogoutSERVLET")
	public String legacyLogout(HttpSession session) {
		return logout(session);
	}
}
