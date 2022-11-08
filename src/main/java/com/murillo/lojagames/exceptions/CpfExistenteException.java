package com.murillo.lojagames.exceptions;

public class CpfExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	private String content;

	public CpfExistenteException(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}