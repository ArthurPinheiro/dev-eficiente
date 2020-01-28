package com.deveficiente.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    @Column(name = "numero_paginas")
    private int numeroPaginas;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @Column(name = "data_publicacao")
    @Future
    private LocalDateTime dataPublicacao;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "fk_categoria_id")
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,@Size(min = 20) @NotBlank BigDecimal preco,
                 @Size(min = 100) int numeroPaginas, @NotBlank String isbn, @NotNull Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoria = categoria;
    }

}
