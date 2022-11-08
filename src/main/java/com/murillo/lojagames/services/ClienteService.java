package com.murillo.lojagames.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.murillo.lojagames.entities.Cliente;

public interface ClienteService {
	List<Cliente> listarClientes();
	
	Cliente salvarCliente(Cliente cliente, HttpSession session);
	
	Cliente encontrarCliente(Long id);
	
	void apagarCliente(Long id);
}
