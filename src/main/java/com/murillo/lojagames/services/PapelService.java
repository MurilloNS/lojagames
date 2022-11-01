package com.murillo.lojagames.services;

import java.util.List;

import com.murillo.lojagames.entities.Papel;

public interface PapelService {
	public List<Papel> listarPapeis();
	
	public Papel salvarPapel(Papel papel);
}