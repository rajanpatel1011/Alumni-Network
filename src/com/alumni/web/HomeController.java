package com.alumni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping({"/", "/index.jsp"})
	public String home() {
		return "home";
	}
}
