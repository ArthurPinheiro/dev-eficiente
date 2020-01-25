package com.deveficiente.casadocodigo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 400)
    private String descricao;

    public Autor novoAutor(){
        return new Autor(nome, email, descricao);
    }
}
