package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDomainToDataMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDtoToDomainMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoEntity;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeEntity;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.AgregadoRepository;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgregadoServiceImpl implements AgregadoService {

    private final AgregadoDtoToDomainMapper agregadoDtoToDomainMapper;
    private final AgregadoDomainToDataMapper agregadoTableDtoMapper;
    private final AgregadoRepository agregadoRepository;

    private final EntidadeRepository entidadeRepository;

    private final GetTodoService getTodoService;

    public AgregadoServiceImpl(AgregadoDtoToDomainMapper agregadoDtoToDomainMapper,
                               AgregadoDomainToDataMapper agregadoTableDtoMapper,
                               AgregadoRepository agregadoRepository,
                               GetTodoService getTodoService,
                               EntidadeRepository entidadeRepository) {
        this.agregadoDtoToDomainMapper = agregadoDtoToDomainMapper;
        this.agregadoTableDtoMapper = agregadoTableDtoMapper;
        this.agregadoRepository = agregadoRepository;
        this.getTodoService = getTodoService;
        this.entidadeRepository = entidadeRepository;
    }

    @Override
    public void criarAgregado(AgregadoInDto agregadoInDto) {

        Todo todo = getTodoService.execute(1);

        Agregado agregado = agregadoDtoToDomainMapper.fromDto(agregadoInDto);
        AgregadoEntity agregadoEntity = new AgregadoMapper().toEntity(agregado);

        agregadoRepository.save(agregadoEntity);

        for (Entidade entidade : agregadoInDto.getCampo1()) {
            EntidadeEntity entidadeEntity = new EntidadeMapper().toEntity(entidade, agregadoEntity);
            entidadeRepository.save(entidadeEntity);
        }
    }

    @Override
    public AgregadoOutDto consultarAgregado(Long id) {
        Optional<AgregadoEntity> agregadoMappingOptional = agregadoRepository.findById(id);

        if (agregadoMappingOptional.isPresent()) {
            AgregadoEntity agregadoMapping = agregadoMappingOptional.get();
            return null;
            // ; return agregadoTableDtoMapper.dataToDto(agregadoMapping);
        } else {
            return null;
        }
    }
}
