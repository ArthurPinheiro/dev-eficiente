package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.IsbnLivroValidador;
import com.deveficiente.casadocodigo.domain.Livro;
import com.deveficiente.casadocodigo.domain.NovoLivroForm;
import com.deveficiente.casadocodigo.domain.TituloLivroValidador;
import com.deveficiente.casadocodigo.service.CategoriaRepository;
import com.deveficiente.casadocodigo.service.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
