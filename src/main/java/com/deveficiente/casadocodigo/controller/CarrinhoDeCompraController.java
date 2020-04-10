package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Carrinho;
import com.deveficiente.casadocodigo.domain.Livro;
import com.deveficiente.casadocodigo.service.LivroRepository;
import com.deveficiente.casadocodigo.shared.Cookies;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoDeCompraController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Cookies cookies;

    @PostMapping("/{id}")
    public String carrinhoDeCompra(@PathVariable("id") Long id, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {

        Carrinho carrinho = Carrinho.cria(jsonCarrinho);
        carrinho.adiciona(livroRepository.findById(id).get());
        cookies.writeAsJson("carrinho", carrinho, response);

        return carrinho.toString();
    }

    @PutMapping(value = "atualiza/{id}")
    public void atualiza(@PathVariable("id") Long id, @RequestParam int novaQuantidade, @CookieValue("carrinho") String jsonCarrinho, HttpServletResponse response ) {
        Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
        Livro livro = livroRepository.findById(id).get();
        carrinho.atualiza(livro, novaQuantidade);
        cookies.writeAsJson("carrinho", carrinho, response);
    }

}
