package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoEntity;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeEntity;

public class EntidadeMapper {

    public EntidadeEntity toEntity(Entidade entidade, AgregadoEntity agregadoEntity) {
        EntidadeEntity entidadeEntity = new EntidadeEntity();
        entidadeEntity.setCampo1(entidade.getCampo1());
        entidadeEntity.setCampo2(entidade.getCampo2());
        entidadeEntity.setCampo3(entidade.getCampo3());
        entidadeEntity.setCampo4(entidade.getCampo4());
        entidadeEntity.setCampo5(entidade.getCampo5());
        entidadeEntity.setAgregado(agregadoEntity);
        return entidadeEntity;
    }

}
