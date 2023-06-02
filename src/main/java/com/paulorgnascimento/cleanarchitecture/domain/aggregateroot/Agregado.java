package com.paulorgnascimento.cleanarchitecture.domain.aggregateroot;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;

import java.util.ArrayList;
import java.util.List;

public class Agregado {

    private Long id;
    private List<Entidade> itens;
    private ObjetoDeValor objetoDeValorDeEntrega;

    public Agregado(List<Entidade> itens, ObjetoDeValor objetoDeValorDeEntrega) {
        this.itens = new ArrayList<>();
        this.objetoDeValorDeEntrega = objetoDeValorDeEntrega;
    }

    public Long getId() { return id; }

    public List<Entidade> getItens() { return itens; }
    public void addItem(Entidade item) { this.itens.add(item); }

    public ObjetoDeValor getEnderecoDeEntrega() { return objetoDeValorDeEntrega; }
}


