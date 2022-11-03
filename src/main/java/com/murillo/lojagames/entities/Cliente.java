package com.murillo.lojagames.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String nome;

	@Column(length = 11, nullable = true, unique = true)
	private String cpf;

	@Column(length = 45, nullable = true, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@ManyToMany
	@JoinTable(name = "item_produto", joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"))
	private List<Produto> produtos = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(Long id) {
		super();
		this.id = id;
	}

	public Cliente(String nome, String cpf, String email, String senha, List<Produto> produtos) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}