package com.murillo.lojagames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.entities.Cliente;
import com.murillo.lojagames.services.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/administrativo/cliente_cadastro");
		return mv.addObject("cliente", cliente);
	}
	
	@PostMapping("/cliente/salvar")
	public ModelAndView salvar(Cliente cliente) {
		clienteService.salvarCliente(cliente);
		return cadastrar(new Cliente());
	}
	
	@GetMapping("/cliente/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/cliente_lista");
		return mv.addObject("listaClientes", clienteService.listarClientes());
	}
}
