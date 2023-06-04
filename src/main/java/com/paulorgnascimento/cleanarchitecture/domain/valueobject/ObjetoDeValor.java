package com.paulorgnascimento.cleanarchitecture.domain.valueobject;

public class ObjetoDeValor {

    private String campo1;

    public ObjetoDeValor(String campo1, String campo2, String campo3, String campo4) {
        this.campo1 = campo1;
    }

    public String getCampo1() { return campo1; }

    // Value Objects geralmente são imutáveis e, assim, não incluem setters e não tem uma identidade única
}

