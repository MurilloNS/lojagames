package com.murillo.lojagames.services;

import java.util.List;

import com.murillo.lojagames.entities.Administrador;

public interface AdministradorService {
	public List<Administrador> listarAdministradores();

	public Administrador salvarAdministrador(Administrador administrador);
	
	public Administrador encontrarAdministrador(Long id);
	
	public void apagarAdministrador(Long id);
}
