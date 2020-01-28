package com.deveficiente.casadocodigo.domain;

import com.deveficiente.casadocodigo.service.CategoriaRepository;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class NovoLivroForm {

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    @Column(name = "numero_paginas")
    private int numeroPaginas;

    @NotBlank
    private String isbn;

    @NotNull
    private Long categoriaId;

    @Deprecated
    public NovoLivroForm(){}

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }


    public Livro novoLivro(CategoriaRepository categoriaRepository){
        Categoria categoria = categoriaRepository.findById(categoriaId).get();
        return new Livro(titulo, resumo, preco, numeroPaginas, isbn, categoria);
    }
}
