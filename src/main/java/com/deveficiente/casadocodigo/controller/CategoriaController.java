package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Categoria;
import com.deveficiente.casadocodigo.domain.CategoriaValidador;
import com.deveficiente.casadocodigo.domain.NovaCategoriaForm;
import com.deveficiente.casadocodigo.service.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @InitBinder("novaCategoriaForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new CategoriaValidador(categoriaRepository));
    }

    @PostMapping("/salvar")
    public void salvar(@Valid @RequestBody NovaCategoriaForm form) {
        Categoria novaCategoria = new Categoria(form.getNome());
        this.categoriaRepository.save(novaCategoria);

    }

}
