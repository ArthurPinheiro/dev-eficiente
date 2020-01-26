package com.deveficiente.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "nome_categoria", nullable = false, unique = true)
    private String nome;

    @Deprecated
    public Categoria(){}

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

}
