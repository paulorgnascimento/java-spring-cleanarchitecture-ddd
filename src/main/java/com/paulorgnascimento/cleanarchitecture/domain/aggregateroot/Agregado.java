package com.paulorgnascimento.cleanarchitecture.domain.aggregateroot;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;

import java.util.ArrayList;
import java.util.List;

public class Agregado {

    private Long id;
    private List<Entidade> campo1;
    private ObjetoDeValor campo2;

    public Agregado(List<Entidade> campo1, ObjetoDeValor campo2) {
        this.campo1 = campo1;
        this.campo2 = campo2;
    }

    public Long getId() { return id; }

    public List<Entidade> getCampo1() { return campo1; }
    public void addItem(Entidade item) { this.campo1.add(item); }

    public ObjetoDeValor getEnderecoDeEntrega() { return campo2; }
}


