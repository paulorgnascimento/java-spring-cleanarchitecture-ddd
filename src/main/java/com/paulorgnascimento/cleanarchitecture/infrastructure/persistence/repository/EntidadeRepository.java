package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository;

import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeEntity;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadeRepository extends JpaRepository<EntidadeEntity, Long> {
}