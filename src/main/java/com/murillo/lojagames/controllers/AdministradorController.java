package com.murillo.lojagames.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/administrador/cadastrar")
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

	@PostMapping("/administrador/salvar")
	public ModelAndView salvar(Administrador administrador, HttpSession session) {
		administradorService.salvarAdministrador(administrador, session);
		return cadastrar(new Administrador(), new Papel());
	}

	@GetMapping("/administrador/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Administrador administrador = administradorService.encontrarAdministrador(id);
		return cadastrar(administrador, null);
	}

	@GetMapping("/administrador/excluir/{id}")
	public ModelAndView apagar(@PathVariable("id") Long id) {
		administradorService.apagarAdministrador(id);
		return listar();
	}
}