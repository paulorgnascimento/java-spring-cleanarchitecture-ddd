package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgregadoDtoToDomainMapper {
    Agregado dtoToDomain(AgregadoInDto agregadoInDto);

}
