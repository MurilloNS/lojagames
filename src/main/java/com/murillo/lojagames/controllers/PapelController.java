package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.entities.Papel;
import com.murillo.lojagames.services.PapelService;

@Controller
public class PapelController {
	@Autowired
	private PapelService papelService;

	@GetMapping("/papel/cadastro")
	public ModelAndView cadastrar(Papel papel) {
		ModelAndView mv = new ModelAndView("administrativo/papel_cadastro");
		return mv.addObject("papel", papel);
	}
	
	@PostMapping("/papel/salvar")
	public ModelAndView salvar(Papel papel) {
		papelService.salvarPapel(papel);
		return cadastrar(new Papel());
	}
}