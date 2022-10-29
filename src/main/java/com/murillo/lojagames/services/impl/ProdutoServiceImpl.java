package com.murillo.lojagames.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.murillo.lojagames.entities.Produto;
import com.murillo.lojagames.repositories.ProdutoRepository;
import com.murillo.lojagames.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	private static String caminhoImagens = "/Spring Boot Projects/games-capa/";
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto salvarProduto(Produto produto, MultipartFile arquivo) {
		produtoRepository.saveAndFlush(produto);
		
		try {
			if (!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths
						.get(caminhoImagens + String.valueOf(produto.getId()) + arquivo.getOriginalFilename());
				Files.write(caminho, bytes);

				produto.setImagem(String.valueOf(produto.getId()) + arquivo.getOriginalFilename());
				produtoRepository.saveAndFlush(produto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return produto;
	}

	@Override
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto encontrarProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	@Override
	public void apagarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}