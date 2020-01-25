package com.deveficiente.casadocodigo.service;

import com.deveficiente.casadocodigo.domain.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
