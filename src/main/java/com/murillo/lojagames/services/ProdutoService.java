package com.murillo.lojagames.services;

import java.util.List;

import com.murillo.lojagames.entities.Produto;

public interface ProdutoService {
	List<Produto> listarProdutos();
	
	Produto salvar(Produto produto);
}
