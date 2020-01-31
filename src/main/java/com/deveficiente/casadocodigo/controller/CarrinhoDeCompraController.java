package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Carrinho;
import com.deveficiente.casadocodigo.service.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoDeCompraController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/{id}")
    public String carrinhoDeCompra(@PathVariable("id") Long id){
       Carrinho carrinho = new Carrinho();
       carrinho.adiciona(livroRepository.findById(id).get());
       return carrinho.toString();

    }
}
