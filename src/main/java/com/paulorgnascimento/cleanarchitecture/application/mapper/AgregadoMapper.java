package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AgregadoMapper {
    private List<Entidade> campo1;
    private ObjetoDeValor campo2;

    public AgregadoMapping toEntity(Agregado agregado) {
        AgregadoMapping agregadoMapping = new AgregadoMapping();
        agregadoMapping.setObjetoDeValor(agregado.valueobject().getCampo1());
        return agregadoMapping;
    }

    public Agregado fromDto(AgregadoInDto dto) {
        // Now let's create the ObjetoDeValor.
        ObjetoDeValor campo2vo = new ObjetoDeValor(dto.getCampo2());

        // And then create the Agregado.
        Agregado agregado = new Agregado(dto.getCampo1(), campo2vo);

        return agregado;
    }
}
