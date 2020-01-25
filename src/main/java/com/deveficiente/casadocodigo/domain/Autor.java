package com.deveficiente.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 3, max = 400)
    private String descricao;

    private LocalDateTime instante = LocalDateTime.now();

    public Autor(@NotNull @NotBlank String nome, @NotBlank @Email String email,
                 @NotBlank @Size(min = 3, max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


}
