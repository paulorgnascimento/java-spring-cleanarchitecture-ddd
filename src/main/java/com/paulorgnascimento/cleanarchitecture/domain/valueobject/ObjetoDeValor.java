package com.paulorgnascimento.cleanarchitecture.domain.valueobject;

public class ObjetoDeValor {

    private String campo2;

    public ObjetoDeValor(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo1() { return campo2; }

    // Value Objects geralmente são imutáveis e, assim, não incluem setters e não tem uma identidade única
}

