package com.murillo.lojagames.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murillo.lojagames.repositories.PapelRepository;
import com.murillo.lojagames.services.PapelService;

@Service
public class PapelServiceImpl implements PapelService {
	@Autowired
	private PapelRepository papelRepository;
}