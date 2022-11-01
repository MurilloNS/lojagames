package com.murillo.lojagames.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class AdministradorPapel {
	@EmbeddedId
	private AdministradorPapelId id;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro = new Date();

	public AdministradorPapel() {
	}

	public AdministradorPapel(AdministradorPapelId id, Date dataCadastro) {
		this.id = id;
		this.dataCadastro = dataCadastro;
	}

	public AdministradorPapelId getId() {
		return id;
	}

	public void setId(AdministradorPapelId id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}