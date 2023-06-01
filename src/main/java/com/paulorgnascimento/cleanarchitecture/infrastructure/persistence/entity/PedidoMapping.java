package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class PedidoMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PedidoItemMapping> itens;

    @Column(name = "cep_de_entrega")
    private String cepDeEntrega;

    public PedidoMapping() {}

    public PedidoMapping(String cepDeEntrega) {
        this.cepDeEntrega = cepDeEntrega;
    }

    public Long getId() { return id; }

    public Set<PedidoItemMapping> getItens() { return itens; }
    public void setItens(Set<PedidoItemMapping> itens) { this.itens = itens; }

    public String getCepDeEntrega() { return cepDeEntrega; }
    public void setCepDeEntrega(String cepDeEntrega) { this.cepDeEntrega = cepDeEntrega; }
}

