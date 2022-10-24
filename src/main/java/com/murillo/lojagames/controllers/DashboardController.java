package com.murillo.lojagames.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	@GetMapping("/administrativo")
	public String telaDashboard() {
		return "administrativo/home";
	}
}
