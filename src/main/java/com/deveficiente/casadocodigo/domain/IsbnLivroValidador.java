package com.deveficiente.casadocodigo.domain;

import com.deveficiente.casadocodigo.service.LivroRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class IsbnLivroValidador implements Validator {

    private LivroRepository livroRepository;

    public IsbnLivroValidador(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroForm isbnDuplicado = (NovoLivroForm) o;
        Optional<Livro> livro = this.livroRepository.findByIsbn(isbnDuplicado.getIsbn());

        if (livro.isPresent()) {
            errors.rejectValue("nome", null, "Já existe um ISBN cadastrdo com esse valor");
        }

    }
}
