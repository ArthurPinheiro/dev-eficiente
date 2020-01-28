package com.deveficiente.casadocodigo.service;

import com.deveficiente.casadocodigo.domain.Livro;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {
    Optional<Livro> findByTitulo(String titulo);

    Optional<Livro> findByIsbn(String isbn);
}
