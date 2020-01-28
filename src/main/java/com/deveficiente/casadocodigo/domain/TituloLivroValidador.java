package com.deveficiente.casadocodigo.domain;

import com.deveficiente.casadocodigo.service.LivroRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class TituloLivroValidador implements Validator {

    private LivroRepository livroRepository;

    public TituloLivroValidador(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroForm tituloDuplicado = (NovoLivroForm) o;
        Optional<Livro> livro = livroRepository.findByTitulo(tituloDuplicado.getTitulo());

        if (livro.isPresent()) {
            errors.rejectValue("nome", null, "Já existe um titulo cadastrado com esse valor");
        }
    }
}
