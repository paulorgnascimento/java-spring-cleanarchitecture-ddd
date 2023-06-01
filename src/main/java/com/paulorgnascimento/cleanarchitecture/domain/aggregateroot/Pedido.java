package com.paulorgnascimento.cleanarchitecture.domain.aggregateroot;

import com.paulorgnascimento.cleanarchitecture.domain.entity.PedidoItem;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.Endereco;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private List<PedidoItem> itens;
    private Endereco enderecoDeEntrega;

    public Pedido(Long id, Endereco enderecoDeEntrega) {
        this.id = id;
        this.itens = new ArrayList<>();
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Long getId() { return id; }

    public List<PedidoItem> getItens() { return itens; }
    public void addItem(PedidoItem item) { this.itens.add(item); }

    public Endereco getEnderecoDeEntrega() { return enderecoDeEntrega; }
}


