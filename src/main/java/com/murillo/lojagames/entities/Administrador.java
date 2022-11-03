package com.murillo.lojagames.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_administradores")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(length = 45, nullable = false, unique = false)
	private String email;

	@Column(nullable = false)
	private String senha;

	@ManyToMany
	@JoinTable(name = "administrador_papel", joinColumns = @JoinColumn(name = "administrador_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private Set<Papel> papeis = new HashSet<>();

	public Administrador() {
	}

	public Administrador(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
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

	public Set<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(Set<Papel> papeis) {
		this.papeis = papeis;
	}

	public void addPapel(Papel papel) {
		this.papeis.add(papel);
	}

	public void removePapel(Papel papel) {
		this.papeis.remove(papel);
	}
}