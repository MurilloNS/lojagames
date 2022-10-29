package com.murillo.lojagames.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.murillo.lojagames.entities.Produto;

public interface ProdutoService {
	List<Produto> listarProdutos();

	Produto salvarProduto(Produto produto, MultipartFile arquivo);

	Produto encontrarProduto(Long id);
	
	void apagarProduto(Long id);
}