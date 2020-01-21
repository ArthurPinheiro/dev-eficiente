package com.deveficiente.casadocodigo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class Autor extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 400)
    private String descricao;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();
}
