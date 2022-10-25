package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.murillo.lojagames.services.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
}
