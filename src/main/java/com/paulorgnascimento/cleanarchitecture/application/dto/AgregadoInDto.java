package com.paulorgnascimento.cleanarchitecture.application.dto;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;

import java.util.List;

public class AgregadoInDto {

    private List<Entidade> itens;
    private String enderecoDeEntrega;

    public AgregadoInDto(List<Entidade> itens, String enderecoDeEntrega) {
        this.itens = itens;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public List<Entidade> getItens() {
        return itens;
    }

    public void setItens(List<Entidade> itens) {
        this.itens = itens;
    }

    public String getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(String enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}