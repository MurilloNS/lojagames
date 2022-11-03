package com.murillo.lojagames.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.murillo.lojagames.enums.GeneroGames;

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String nome;

	@Column(nullable = true, columnDefinition = "decimal(10,2)")
	private Double preco;

	private Integer quantidade;
	private String imagem;

	@Enumerated(EnumType.STRING)
	private GeneroGames generoGames;

	@ManyToMany(mappedBy = "produtos")
	private List<Cliente> clientes = new ArrayList<>();

	public Produto() {
	}

	public Produto(String nome, Double preco, Integer quantidade, String imagem, GeneroGames generoGames,
			List<Cliente> clientes) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.imagem = imagem;
		this.generoGames = generoGames;
		this.clientes = clientes;
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

	public void setId(Long id) {
		this.id = id;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}