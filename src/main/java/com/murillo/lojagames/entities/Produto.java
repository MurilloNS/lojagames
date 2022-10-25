package com.murillo.lojagames.entities;

import javax.persistence.*;

import com.murillo.lojagames.enums.GeneroGames;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private String imagem;
	
	@Enumerated(EnumType.STRING)
	private GeneroGames generoGames;

	public Produto() {

	}

	public Produto(Long id, String nome, Double preco, Integer quantidade, String imagem, GeneroGames generoGames) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.imagem = imagem;
		this.generoGames = generoGames;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public GeneroGames getGeneroGames() {
		return generoGames;
	}

	public void setGeneroGames(GeneroGames generoGames) {
		this.generoGames = generoGames;
	}

	public Long getId() {
		return id;
	}
}