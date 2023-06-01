package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "entidade")
public class TB_Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campo1")
    private String campo1;

    @Column(name = "campo2")
    private String campo2;

    @Column(name = "campo3")
    private int campo3;

    @Column(name = "campo4")
    private int campo4;

    @Column(name = "campo5")
    private double campo5;
}

