package com.paulorgnascimento.cleanarchitecture.domain.entity;

public class PedidoItem {

    private Long id;
    private String produto;
    private int quantidade;

    public PedidoItem(Long id, String produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() { return id; }

    public String getProduto() { return produto; }

    public int getQuantidade() { return quantidade; }
}

