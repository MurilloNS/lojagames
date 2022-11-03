package com.murillo.lojagames.entities;

import javax.persistence.*;

@Entity
@Table(name = "item_produto")
public class ItemProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private Integer quantidade = 0;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public ItemProduto() {
	}

	public ItemProduto(Long id, Integer quantidade, Produto produto, Cliente cliente) {
		this.quantidade = quantidade;
		this.produto = produto;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ItemProduto [id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + ", cliente=" + cliente
				+ "]";
	}
}