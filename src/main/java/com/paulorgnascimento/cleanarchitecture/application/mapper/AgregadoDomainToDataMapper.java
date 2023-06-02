package com.paulorgnascimento.cleanarchitecture.application.mapper;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgregadoDomainToDataMapper {
    AgregadoMapping domainToData(Agregado agregado);
    AgregadoOutDto dataToDto(AgregadoMapping agregadoMapping);
}
