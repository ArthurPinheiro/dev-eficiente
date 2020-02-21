package com.deveficiente.casadocodigo.domain;

import java.math.BigDecimal;

public class LivroDetalheDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private CategoriaDetalheDTO categoria;

    public LivroDetalheDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.categoria = new CategoriaDetalheDTO(livro.getCategoria());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public CategoriaDetalheDTO getCategoria() {
        return categoria;
    }
}
