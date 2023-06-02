package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDomainToDataMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDtoToDomainMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeDtoToDomainMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeDomainToDataMapper;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.AgregadoRepository;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class AgregadoServiceImpl implements AgregadoService {

    private final AgregadoDtoToDomainMapper agregadoDtoToDomainMapper;
    private final AgregadoDomainToDataMapper agregadoTableDtoMapper;
    private final AgregadoRepository agregadoRepository;

    private final GetTodoService getTodoService;

    public AgregadoServiceImpl(AgregadoDtoToDomainMapper agregadoDtoToDomainMapper,
                               AgregadoDomainToDataMapper agregadoTableDtoMapper,
                               AgregadoRepository agregadoRepository, GetTodoService getTodoService) {
        this.agregadoDtoToDomainMapper = agregadoDtoToDomainMapper;
        this.agregadoTableDtoMapper = agregadoTableDtoMapper;
        this.agregadoRepository = agregadoRepository;
        this.getTodoService = getTodoService;
    }

    @Override
    public void criarAgregado(AgregadoInDto agregadoInDto) {

        Todo todo = getTodoService.execute(1);

        Agregado agregado = agregadoDtoToDomainMapper.dtoToDomain(agregadoInDto);
        AgregadoMapping agregadoMapping = agregadoTableDtoMapper.domainToData(agregado);

        agregadoRepository.save(agregadoMapping);
    }
}
