package com.murillo.lojagames.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Administrador;
import com.murillo.lojagames.repositories.AdministradorRepository;
import com.murillo.lojagames.services.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService{
	@Autowired
	private AdministradorRepository administradorRepository;

	@Override
	public List<Administrador> listarAdministradores() {
		return administradorRepository.findAll();
	}
}