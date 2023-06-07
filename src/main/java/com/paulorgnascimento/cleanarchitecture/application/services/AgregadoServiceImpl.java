package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.AgregadoRepository;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgregadoServiceImpl implements AgregadoService {

    private final AgregadoMapper agregadoMapper;
    private final AgregadoRepository agregadoRepository;

    private final EntidadeRepository entidadeRepository;

    private final GetTodoService getTodoService;

    public AgregadoServiceImpl(AgregadoMapper agregadoMapper,
                               AgregadoRepository agregadoRepository,
                               GetTodoService getTodoService,
                               EntidadeRepository entidadeRepository) {
        this.agregadoMapper = agregadoMapper;
        this.agregadoRepository = agregadoRepository;
        this.getTodoService = getTodoService;
        this.entidadeRepository = entidadeRepository;
    }

    @Override
    public void criarAgregado(AgregadoInDto agregadoInDto) {

        Todo todo = getTodoService.execute(1);

        Agregado agregado = agregadoMapper.fromDto(agregadoInDto);
        AgregadoMapping agregadoMapping = new AgregadoMapper().toEntity(agregado);

        agregadoRepository.save(agregadoMapping);

        for (Entidade entidade : agregadoInDto.getCampo1()) {
            EntidadeMapping entidadeMapping = new EntidadeMapper().toEntity(entidade, agregadoMapping);
            entidadeRepository.save(entidadeMapping);
        }
    }

    @Override
    public AgregadoOutDto consultarAgregado(Long id) {
        Optional<AgregadoMapping> agregadoMappingOptional = agregadoRepository.findById(id);

        if (agregadoMappingOptional.isPresent()) {
            AgregadoMapping agregadoMapping = agregadoMappingOptional.get();
            return null;
            // ; return agregadoTableDtoMapper.dataToDto(agregadoMapping);
        } else {
            return null;
        }
    }
}
