package com.deveficiente.casadocodigo.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<CarrinhoDeComprasDTO> livros = new ArrayList<>();

    public void adiciona(Livro livro) {
        livros.add(new CarrinhoDeComprasDTO(livro));
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "livros=" + livros +
                '}';
    }
}
