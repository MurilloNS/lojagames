package com.murillo.lojagames.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView salvar(Produto produto, @RequestParam("file") MultipartFile arquivo) {
		produtoService.salvar(produto);

		try {
			if (!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths
						.get(caminhoImagens + String.valueOf(produto.getId()) + arquivo.getOriginalFilename());
				Files.write(caminho, bytes);

				produto.setImagem(String.valueOf(produto.getId()) + arquivo.getOriginalFilename());
				produtoService.salvar(produto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cadastrar(new Produto());
	}
}
