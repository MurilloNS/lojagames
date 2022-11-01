package com.murillo.lojagames.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class AdministradorPapelId implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Administrador administrador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Papel papel;

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(administrador, papel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdministradorPapelId other = (AdministradorPapelId) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(papel, other.papel);
	}
}