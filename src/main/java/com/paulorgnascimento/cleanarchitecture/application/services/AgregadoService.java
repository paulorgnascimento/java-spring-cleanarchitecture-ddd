package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;

public interface AgregadoService {
    void criarAgregado(AgregadoInDto agregadoInDto);
}
