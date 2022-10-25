package com.murillo.lojagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murillo.lojagames.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
