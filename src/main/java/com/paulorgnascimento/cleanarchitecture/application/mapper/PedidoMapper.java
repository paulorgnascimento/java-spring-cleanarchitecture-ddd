package com.paulorgnascimento.cleanarchitecture.application.mapper;

public class PedidoMapper {
    public PedidoData mapToData(Pedido pedido) {
        PedidoData pedidoData = new PedidoData();
        pedidoData.setId(pedido.getId());
        // mapear os outros campos

        return pedidoData;
    }

    public Pedido mapToDomain(PedidoData pedidoData) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoData.getId());
        // mapear os outros campos

        return pedido;
    }
}
