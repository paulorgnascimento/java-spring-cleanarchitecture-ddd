package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgregadoDtoToDomainMapper {

    AgregadoDtoToDomainMapper INSTANCE = Mappers.getMapper(AgregadoDtoToDomainMapper.class);

    @Mapping(source = "campo1", target = "campo1")
    @Mapping(source = "campo2", target = "campo2", qualifiedByName = "stringToObjetoDeValor")
    Agregado fromDTO(AgregadoInDto agregadoInDto);

    @Named("stringToObjetoDeValor")
    default ObjetoDeValor stringToObjetoDeValor(String campo2) {
        return new ObjetoDeValor(campo2);
    }
}