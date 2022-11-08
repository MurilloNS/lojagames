package com.murillo.lojagames.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murillo.lojagames.entities.Cliente;
import com.murillo.lojagames.services.ClienteService;
import com.murillo.lojagames.services.ProdutoService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/cliente/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/administrativo/cliente_cadastro");
		mv.addObject("listarProdutos", produtoService.listarProdutos());
		mv.addObject("cliente", cliente);
		return mv;
	}

	@PostMapping("/cliente/salvar")
	public ModelAndView salvar(Cliente cliente, HttpSession session) {
		clienteService.salvarCliente(cliente, session);
		return cadastrar(new Cliente());
	}

	@GetMapping("/cliente/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/cliente_lista");
		return mv.addObject("listaClientes", clienteService.listarClientes());
	}

	@GetMapping("cliente/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.encontrarCliente(id);
		return cadastrar(cliente);
	}

	@GetMapping("cliente/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		clienteService.apagarCliente(id);
		return listar();
	}
}
