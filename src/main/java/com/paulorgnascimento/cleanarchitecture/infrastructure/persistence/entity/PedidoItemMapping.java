package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "pedido_itens")
public class PedidoItemMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private AgregadoMapping pedido;

    @Column(name = "produto")
    private String produto;

    @Column(name = "quantidade")
    private int quantidade;

    public PedidoItemMapping() {}

    public PedidoItemMapping(AgregadoMapping pedido, String produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() { return id; }

    public AgregadoMapping getPedido() { return pedido; }
    public void setPedido(AgregadoMapping pedido) { this.pedido = pedido; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}

