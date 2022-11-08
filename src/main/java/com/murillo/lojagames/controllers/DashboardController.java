package com.murillo.lojagames.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	@RequestMapping("/home")
	public String home() {
		return "/administrativo/home";
	}
	
	@RequestMapping("/logout")
	public String sair() {
		return "/administrativo/home";
	}
	
	@RequestMapping("/")
	public String sairDois() {
		return "/administrativo/home";
	}
}