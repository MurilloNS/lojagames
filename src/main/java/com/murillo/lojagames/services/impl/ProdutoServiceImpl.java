package com.murillo.lojagames.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.repositories.ProdutoRepository;
import com.murillo.lojagames.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired
	private ProdutoRepository produtoRepository;
}
