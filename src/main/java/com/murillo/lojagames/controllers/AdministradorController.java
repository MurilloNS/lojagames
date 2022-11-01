package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.services.AdministradorService;

@Controller
public class AdministradorController {
	@Autowired
	private AdministradorService administradorService;
	
	@GetMapping("/administrador/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/administrador_lista");
		return mv.addObject("listaAdministradores", administradorService.listarAdministradores());
	}
}
