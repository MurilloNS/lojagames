package com.murillo.lojagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murillo.lojagames.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
