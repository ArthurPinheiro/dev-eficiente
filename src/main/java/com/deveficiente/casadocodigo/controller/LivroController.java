package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.*;
import com.deveficiente.casadocodigo.service.CategoriaRepository;
import com.deveficiente.casadocodigo.service.LivroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @InitBinder
    public void initBindir(WebDataBinder binder) {
        binder.addValidators(new TituloLivroValidador(livroRepository), new IsbnLivroValidador(livroRepository));
    }

    @GetMapping("/detalhe/{id}")
    public LivroDetalheDTO getLivroDetalheDTO(@PathVariable("id") Long id) throws NotFoundException {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado " + HttpStatus.NOT_FOUND));
        return new LivroDetalheDTO(livro);
    }

    @GetMapping("/listar")
    public Iterable<Livro> listarLivros() {
        return livroRepository.findAll();

    }

    @PostMapping("/salvar")
    @Transactional
    public void salvar(@Valid @RequestBody NovoLivroForm form) {
        Livro novoLivro = form.novoLivro(categoriaRepository);
        this.livroRepository.save(novoLivro);
    }
}
