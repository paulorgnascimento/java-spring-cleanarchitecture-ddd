package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

@Entity
@Table(name = "pedido_itens")
public class PedidoItemData {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoData pedido;

    private String produto;
    private Integer quantidade;

    // getters e setters
}