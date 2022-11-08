package com.murillo.lojagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.murillo.lojagames.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	@Query("SELECT u FROM Administrador u WHERE u.cpf =:cpf")
	Administrador findByCPF(@Param("cpf") String cpf);
}