package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;

public class EntidadeMapper {

    public EntidadeMapping toEntity(Entidade entidade, AgregadoMapping agregadoMapping) {
        EntidadeMapping entidadeMapping = new EntidadeMapping();
        entidadeMapping.setCampo1(entidade.getCampo1());
        entidadeMapping.setCampo2(entidade.getCampo2());
        entidadeMapping.setCampo3(entidade.getCampo3());
        entidadeMapping.setCampo4(entidade.getCampo4());
        entidadeMapping.setCampo5(entidade.getCampo5());
        entidadeMapping.setAgregado(agregadoMapping);
        return entidadeMapping;
    }

}
