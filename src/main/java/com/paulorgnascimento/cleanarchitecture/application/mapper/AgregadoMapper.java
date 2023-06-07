package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoEntity;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AgregadoMapper {
    private List<Entidade> campo1;
    private ObjetoDeValor campo2;

    public AgregadoEntity toEntity(Agregado agregado) {
        AgregadoEntity agregadoEntity = new AgregadoEntity();
        agregadoEntity.setObjetoDeValor(agregado.valueobject().getCampo1());
        return agregadoEntity;
    }
}
