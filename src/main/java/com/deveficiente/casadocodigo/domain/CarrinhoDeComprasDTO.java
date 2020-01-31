package com.deveficiente.casadocodigo.domain;

import java.math.BigDecimal;

public class CarrinhoDeComprasDTO {

    private String titulo;
    private BigDecimal preco;
    private String isbn;

    @Deprecated
    public CarrinhoDeComprasDTO() {
    }

    public CarrinhoDeComprasDTO(Livro livro) {
        titulo = livro.getTitulo();
        preco = livro.getPreco();
        isbn = livro.getIsbn();
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "CarrinhoDeComprasDTO{" +
                "titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
