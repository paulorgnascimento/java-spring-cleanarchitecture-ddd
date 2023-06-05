package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDomainToDataMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoDtoToDomainMapper;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.AgregadoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        Agregado agregado = agregadoDtoToDomainMapper.fromDto(agregadoInDto);
        AgregadoMapping agregadoMapping = agregadoTableDtoMapper.domainToData(agregado);

        agregadoRepository.save(agregadoMapping);
    }

    @Override
    public AgregadoOutDto consultarAgregado(Long id) {
        Optional<AgregadoMapping> agregadoMappingOptional = agregadoRepository.findById(id);

        if (agregadoMappingOptional.isPresent()) {
            AgregadoMapping agregadoMapping = agregadoMappingOptional.get();
            return agregadoTableDtoMapper.dataToDto(agregadoMapping);
        } else {
            return null;
        }
    }
}
