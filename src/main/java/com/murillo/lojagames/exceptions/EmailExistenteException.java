package com.murillo.lojagames.exceptions;

public class EmailExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	private String content;

	public EmailExistenteException(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}