package com.paulorgnascimento.cleanarchitecture.domain.entity;

public class PedidoItem {
    private UUID id;
    private String produto;
    private Integer quantidade;

    public PedidoItem(String produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    private void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}