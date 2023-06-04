package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgregadoDtoToDomainMapper {

    AgregadoDtoToDomainMapper INSTANCE = Mappers.getMapper( AgregadoDtoToDomainMapper.class );

    @Mapping(source = "campo1", target = "campo1")
    @Mapping(source = "campo2", target = "campo2")
    Agregado toAgregado(AgregadoInDto agregadoInDto);

    List<Entidade> toEntityList(List<EntidadeInDto> entidadeDtoList);

    @Mapping(target = "campo2", ignore = true) // Since we don't have a way to convert String to ObjetoDeValor
    Entidade toEntity(EntidadeInDto entidadeDto);

    ObjetoDeValor toObjetoDeValor(String campo2);
}
