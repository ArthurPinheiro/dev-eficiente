package com.deveficiente.casadocodigo.domain;

import com.deveficiente.casadocodigo.service.CategoriaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class CategoriaValidador implements Validator {

    private CategoriaRepository categoriaRepository;

    public CategoriaValidador(CategoriaRepository categoriaRepository) {
       this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovaCategoriaForm categoriaDuplicada = (NovaCategoriaForm) o;
        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaDuplicada.getNome());

        if (categoria.isPresent()) {
            errors.rejectValue("nome", null,"Já existe uma categoria cadastra com esse valor");
        }
    }
}
