package com.paulorgnascimento.cleanarchitecture.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgregadoOutDto {
    private int id;
    private List<EntidadeInDto> campo1;
    private String campo2;
}