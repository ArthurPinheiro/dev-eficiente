package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Livro;
import com.deveficiente.casadocodigo.domain.NovoLivroForm;
import com.deveficiente.casadocodigo.service.CategoriaRepository;
import com.deveficiente.casadocodigo.service.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(livroRepository.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public void salvar(@Valid @RequestBody NovoLivroForm form) {
        System.out.println("aquiiiiiii");
        Livro novoLivro = form.novoLivro(categoriaRepository);
        this.livroRepository.save(novoLivro);
    }
}
