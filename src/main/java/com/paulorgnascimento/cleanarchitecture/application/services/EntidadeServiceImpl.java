package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeDtoToDomainMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeDomainToDataMapper;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class EntidadeServiceImpl implements EntidadeService {

    private final EntidadeDtoToDomainMapper entidadeDtoToDomainMapper;
    private final EntidadeDomainToDataMapper entidadeTableDtoMapper;
    private final EntidadeRepository entidadeTableDtoRepository;

    private final GetTodoService getTodoService;

    public EntidadeServiceImpl(EntidadeDtoToDomainMapper entidadeDtoToDomainMapper,
                               EntidadeDomainToDataMapper entidadeTableDtoMapper,
                               EntidadeRepository entidadeRepository, GetTodoService getTodoService) {
        this.entidadeDtoToDomainMapper = entidadeDtoToDomainMapper;
        this.entidadeTableDtoMapper = entidadeTableDtoMapper;
        this.entidadeTableDtoRepository = entidadeRepository;
        this.getTodoService = getTodoService;
    }

    @Override
    public void criarEntidade(EntidadeInDto entidadeInDto) {

        Todo todo = getTodoService.execute(1);

        Entidade entidade = entidadeDtoToDomainMapper.dtoToDomain(entidadeInDto);
        TB_Entidade TBEntidade = entidadeTableDtoMapper.domainToData(entidade);

        entidadeTableDtoRepository.save(TBEntidade);
    }
}
