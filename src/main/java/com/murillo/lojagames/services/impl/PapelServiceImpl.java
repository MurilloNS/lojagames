package com.murillo.lojagames.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.entities.Papel;
import com.murillo.lojagames.repositories.PapelRepository;
import com.murillo.lojagames.services.PapelService;

@Service
public class PapelServiceImpl implements PapelService {
	@Autowired
	private PapelRepository papelRepository;

	@Override
	public List<Papel> listarPapeis() {
		return papelRepository.findAll();
	}

	@Override
	public Papel salvarPapel(Papel papel) {
		return papelRepository.saveAndFlush(papel);
	}
}