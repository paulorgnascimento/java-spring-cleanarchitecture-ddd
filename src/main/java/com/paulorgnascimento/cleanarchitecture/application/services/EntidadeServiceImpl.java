package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.TB_EntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class EntidadeServiceImpl implements EntidadeService {

    private final EntidadeMapper entidadeMapper;
    private final TB_EntidadeMapper entidadeTableDtoMapper;
    private final EntidadeRepository entidadeTableDtoRepository;

    private final GetTodoService getTodoService;

    public EntidadeServiceImpl(EntidadeMapper entidadeMapper,
                               TB_EntidadeMapper entidadeTableDtoMapper,
                               EntidadeRepository entidadeRepository, GetTodoService getTodoService) {
        this.entidadeMapper = entidadeMapper;
        this.entidadeTableDtoMapper = entidadeTableDtoMapper;
        this.entidadeTableDtoRepository = entidadeRepository;
        this.getTodoService = getTodoService;
    }

    @Override
    public void criarEntidade(EntidadeDto entidadeDto) {

        Todo todo = getTodoService.execute(1);

        Entidade entidade = entidadeMapper.toEntity(entidadeDto);
        TB_Entidade TBEntidade = entidadeTableDtoMapper.toTableDto(entidade);

        entidadeTableDtoRepository.save(TBEntidade);
    }
}
