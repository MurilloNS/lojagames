package com.murillo.lojagames.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/produto/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/produto_lista");
		return mv.addObject("listaProdutos", produtoService.listarProdutos());
	}

	@PostMapping("/produto/salvar")
	public ModelAndView salvar(Produto produto, @RequestParam("file") MultipartFile arquivo) {
		produtoService.salvarProduto(produto, arquivo);
		return cadastrar(new Produto());
	}
	
	@SuppressWarnings("null")
	@GetMapping("/produto/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
		File imagemArquivo = new File(caminhoImagens + imagem);
		if(imagem != null || imagem.trim().length() > 0) {
			return Files.readAllBytes(imagemArquivo.toPath());
		}
		return null;
	}
	
	@GetMapping("/produto/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Produto produto = produtoService.encontrarProduto(id);
		return cadastrar(produto);
	}
	
	@GetMapping("produto/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		produtoService.apagarProduto(id);
		return listar();
	}
}