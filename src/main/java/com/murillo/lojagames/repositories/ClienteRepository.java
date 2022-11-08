package com.murillo.lojagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murillo.lojagames.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("SELECT u FROM Cliente u WHERE u.cpf=:cpf")
	Cliente findClientByCpf(String cpf);

	@Query("SELECT u FROM Cliente u WHERE u.email=:email")
	Cliente findClientByEmail(String email);
}