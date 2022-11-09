package com.murillo.lojagames.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Administrador;
import com.murillo.lojagames.exceptions.CpfExistenteException;
import com.murillo.lojagames.exceptions.EmailExistenteException;
import com.murillo.lojagames.messages.Message;
import com.murillo.lojagames.repositories.AdministradorRepository;
import com.murillo.lojagames.services.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {
	@Autowired
	private AdministradorRepository administradorRepository;

	@Override
	public List<Administrador> listarAdministradores() {
		return administradorRepository.findAll();
	}

	@Override
	public Administrador salvarAdministrador(Administrador administrador, HttpSession session) {
		try {
			administrador.setCpf(administrador.getCpf().replace(".", "").replace("-", ""));
			administrador.setSenha(new BCryptPasswordEncoder().encode(administrador.getSenha()));
			if(findByCPF(administrador) != null && administrador.getId() == null) {
				throw new CpfExistenteException("Este CPF já está cadastrado!");
			}
			
			if(findByEmail(administrador) != null && administrador.getId() == null) {
				throw new EmailExistenteException("Este email já está cadastrado!");
			}
			
			session.setAttribute("message", new Message("Administrador cadastrado com sucesso!", "success"));
			return administradorRepository.saveAndFlush(administrador);
		} catch (CpfExistenteException e) {
			session.setAttribute("message", new Message(e.getContent() , "danger"));
		} catch (EmailExistenteException e) {
			session.setAttribute("message", new Message(e.getContent() , "danger"));
		} 
		
		return administrador;
	}

	@Override
	public Administrador encontrarAdministrador(Long id) {
		return administradorRepository.findById(id).get();
	}

	@Override
	public void apagarAdministrador(Long id) {
		administradorRepository.deleteById(id);
	}
	
	private Administrador findByCPF(Administrador administrador) {
		Administrador admCpf = administradorRepository.findByCPF(administrador.getCpf());
		if(admCpf != null) {
			return admCpf;
		}
		
		return null;
	}
	
	private Administrador findByEmail(Administrador administrador) {
		Administrador admEmail = administradorRepository.findByEmail(administrador.getEmail());
		if(admEmail != null) {
			return admEmail;
		}
		
		return null;
	}
}