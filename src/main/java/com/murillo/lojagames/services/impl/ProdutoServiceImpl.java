package com.murillo.lojagames.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Produto;
import com.murillo.lojagames.repositories.ProdutoRepository;
import com.murillo.lojagames.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto salvar(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	@Override
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
}
