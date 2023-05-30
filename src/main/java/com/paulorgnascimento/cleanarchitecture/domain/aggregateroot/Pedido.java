package com.paulorgnascimento.cleanarchitecture.domain.aggregateroot;

public class Pedido {
    private UUID id;
    private List<PedidoItem> itens;
    private Endereco enderecoEntrega;


    public Pedido(List<PedidoItem> itens, Endereco enderecoEntrega) {
        this.itens = itens;
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    private void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    private void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
