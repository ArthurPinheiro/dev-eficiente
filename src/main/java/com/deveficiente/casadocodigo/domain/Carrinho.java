package com.deveficiente.casadocodigo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrinho {

    private Set<CarrinhoDeComprasDTO> livros = new LinkedHashSet<>();

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
       CarrinhoDeComprasDTO novoItem = new CarrinhoDeComprasDTO(livro);
       boolean result = livros.add(novoItem);
       if(!result) {
           CarrinhoDeComprasDTO itemExistente = livros.stream().filter(novoItem :: equals).findFirst().get();
           itemExistente.incrementa();
       }
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "livros=" + livros +
                '}';
    }

    public Set<CarrinhoDeComprasDTO> getLivros() {
        return livros;
    }

    public void atualiza(@NotNull Livro livro, @Positive int novaQuantidade) {
        CarrinhoDeComprasDTO possivelItemAdicionado = new CarrinhoDeComprasDTO(livro);
        Optional<CarrinhoDeComprasDTO> possivelItem = livros.stream().filter(possivelItemAdicionado :: equals).findFirst();
        CarrinhoDeComprasDTO itemQueExiste = possivelItem.get();
        itemQueExiste.atualizaQuantidade(novaQuantidade);
    }

    public BigDecimal getTotal() {
        return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO,
                (atual, proximo) -> atual.add(proximo));
    }
}
