package com.murillo.lojagames.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	@RequestMapping("/administrativo")
	public String telaDashboard() {
		return "/administrativo/home";
	}
}
