package com.deveficiente.casadocodigo.controller;

import com.deveficiente.casadocodigo.domain.Autor;
import com.deveficiente.casadocodigo.service.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ResponseEntity<?> listar(Pageable pageable) {
        return new ResponseEntity<>(autorRepository.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@Valid @RequestBody Autor autor) {
        this.autorRepository.save(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<Autor> editar(@RequestBody Autor autor) {
        this.autorRepository.findById(autor.getId());
        this.autorRepository.save(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
}
