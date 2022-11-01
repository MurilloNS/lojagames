package com.murillo.lojagames.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_administradores")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;

	@OneToMany(mappedBy = "id.administrador")
	private Set<AdministradorPapel> administradorPapel;

	public Administrador() {
	}

	public Administrador(Long id, String nome, String cpf, String email, String senha) {
		this.id = id;
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

	public Set<AdministradorPapel> getAdministradorPapel() {
		return administradorPapel;
	}

	public void setAdministradorPapel(Set<AdministradorPapel> administradorPapel) {
		this.administradorPapel = administradorPapel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(id, other.id);
	}
}