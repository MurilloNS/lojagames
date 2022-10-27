package com.murillo.lojagames.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Cliente;
import com.murillo.lojagames.repositories.ClienteRepository;
import com.murillo.lojagames.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.saveAndFlush(cliente);
	}

}
