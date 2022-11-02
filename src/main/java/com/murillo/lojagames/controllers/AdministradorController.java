package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.entities.Administrador;
import com.murillo.lojagames.entities.Papel;
import com.murillo.lojagames.services.AdministradorService;
import com.murillo.lojagames.services.PapelService;

@Controller
public class AdministradorController {
	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private PapelService papelService;
	
	

	@GetMapping("/administrador/")
	public ModelAndView cadastrar(Administrador administrador, Papel papel) {
		ModelAndView mv = new ModelAndView("administrativo/administrador_cadastro");
		mv.addObject("administrador", administrador);
		mv.addObject("papeis", papel);
		mv.addObject("listaPapeis", papelService.listarPapeis());
		return mv;
	}

	@GetMapping("/administrador/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/administrador_lista");
		return mv.addObject("listaAdministradores", administradorService.listarAdministradores());
	}
}
