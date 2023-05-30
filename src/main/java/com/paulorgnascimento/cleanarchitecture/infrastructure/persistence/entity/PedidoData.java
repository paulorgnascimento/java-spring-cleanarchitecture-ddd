package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

@Entity
@Table(name = "pedidos")
public class PedidoData {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItemData> itens;

    @Embedded
    private EnderecoData enderecoEntrega;

    // getters e setters
}


