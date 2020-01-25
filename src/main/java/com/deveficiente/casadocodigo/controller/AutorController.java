package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Autor;
import com.deveficiente.casadocodigo.domain.NovoAutorForm;
import com.deveficiente.casadocodigo.service.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/salvar")
    public void salvar(@Valid @RequestBody NovoAutorForm form) {
        Autor novoAutor = form.novoAutor();
        this.autorRepository.save(novoAutor);
    }


}
