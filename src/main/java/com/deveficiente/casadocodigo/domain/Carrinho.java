package com.deveficiente.casadocodigo.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrinho {

    private List<CarrinhoDeComprasDTO> livros = new ArrayList<>();

    @Deprecated
    public Carrinho(){}

    public static Carrinho cria(Optional<String> jsonCarrinho) {
      return jsonCarrinho.map(json -> {
            try{
                return new ObjectMapper().readValue(json, Carrinho.class);
            } catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }
        }).orElse(new Carrinho());
    }

    public void adiciona(Livro livro) {
        livros.add(new CarrinhoDeComprasDTO(livro));
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "livros=" + livros +
                '}';
    }

    public List<CarrinhoDeComprasDTO> getLivros() {
        return livros;
    }
}
