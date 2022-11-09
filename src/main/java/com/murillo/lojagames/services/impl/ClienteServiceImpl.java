package com.murillo.lojagames.services.impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Cliente;
import com.murillo.lojagames.exceptions.CpfExistenteException;
import com.murillo.lojagames.exceptions.EmailExistenteException;
import com.murillo.lojagames.messages.Message;
import com.murillo.lojagames.repositories.ClienteRepository;
import com.murillo.lojagames.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente salvarCliente(Cliente cliente, HttpSession session) {
		try {
			cliente.setCpf(cliente.getCpf().replace(".", "").replace("-", ""));
			cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
			if (findClientByCpf(cliente) != null && cliente.getId() == null) {
				throw new CpfExistenteException("Este CPF já está cadastrado!");
			}
			
			if(findClientByEmail(cliente) != null && cliente.getId() == null) {
				throw new EmailExistenteException("Este email já está cadastrado");
			}
			
			session.setAttribute("message", new Message("Cliente cadastrado com sucesso!", "success"));
			return clienteRepository.saveAndFlush(cliente);
		} catch (CpfExistenteException e) {
			session.setAttribute("message", new Message(e.getContent(), "danger"));
		} catch(EmailExistenteException e) {
			session.setAttribute("message", new Message(e.getContent(), "danger"));
		}

		return cliente;
	}

	@Override
	public Cliente encontrarCliente(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void apagarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	private Cliente findClientByCpf(Cliente cliente) {
		Cliente clienteCpf = clienteRepository.findClientByCpf(cliente.getCpf());
		if (clienteCpf != null) {
			return clienteCpf;
		}

		return null;
	}
	
	private Cliente findClientByEmail(Cliente cliente) {
		Cliente clienteEmail = clienteRepository.findClientByEmail(cliente.getEmail());
		if(clienteEmail != null) {
			return clienteEmail;
		}
		
		return null;
	}
}