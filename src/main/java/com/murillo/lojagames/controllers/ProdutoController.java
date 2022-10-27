package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.entities.Produto;
import com.murillo.lojagames.services.ProdutoService;

@Controller
public class ProdutoController {
	private static String caminhoImagens = "/Spring Boot Projects/games-capa/";

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/produto/cadastrar")
	public ModelAndView cadastrar(Produto produto) {
		ModelAndView mv = new ModelAndView("/administrativo/produto_cadastro");
		return mv.addObject("produto", produto);
	}

	@PostMapping("/produto/salvar")
	public ModelAndView salvar(Produto produto) {
		produtoService.salvar(produto);
		return cadastrar(new Produto());
	}
}
