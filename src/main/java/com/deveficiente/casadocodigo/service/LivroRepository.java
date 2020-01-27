package com.deveficiente.casadocodigo.service;

import com.deveficiente.casadocodigo.domain.Livro;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {
}
