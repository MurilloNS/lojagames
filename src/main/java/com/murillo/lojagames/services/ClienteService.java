package com.murillo.lojagames.services;

import java.util.List;

import com.murillo.lojagames.entities.Cliente;

public interface ClienteService {
	List<Cliente> findAllClientes();
	
	Cliente cadastrarCliente(Cliente cliente);
}
