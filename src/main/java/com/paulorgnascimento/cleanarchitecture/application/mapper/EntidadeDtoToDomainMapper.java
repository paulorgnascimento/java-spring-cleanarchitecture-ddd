package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntidadeDtoToDomainMapper {
    Entidade dtoToDomain(EntidadeInDto dto);
}