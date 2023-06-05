package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import org.springframework.stereotype.Service;

@Service
public class AgregadoDtoToDomainMapper {

    public Agregado fromDto(AgregadoInDto dto) {
        // Now let's create the ObjetoDeValor.
        ObjetoDeValor campo2vo = new ObjetoDeValor(dto.getCampo2());

        // And then create the Agregado.
        Agregado agregado = new Agregado(dto.getCampo1(), campo2vo);

        return agregado;
    }
}
