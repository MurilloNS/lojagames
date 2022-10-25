package com.murillo.lojagames.enums;

public enum GeneroGames {
	ACAO("Ação"), TIRO("Jogos de Tiro"), RPG("RPG"), SIMULACAO("Simulação"), PUZZLES("Puzzles"),
	ESTRATEGIA("Estratégia"), MOBA("MOBA (Multiplayer Online Battle Arena)"), AVENTURA("Aventura"),
	PLATAFORMA("Plataforma"), TERROR("Terror"), JOGO_CARTAS("Jogos de Cartas"), ARCADE("Arcade"),
	MUSIC("Jogos Musicias "), SOBREVIVENCIA("Sobrevivência"), CITY_BUILDING("City Building (Construção de Cidades)"),
	LIFE_SIM("Life Sim (Simulador de Vida)"), EDUCATIVO("Jogos Educativos");

	private String genero;

	private GeneroGames(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}
}